package lintcode;

import java.util.LinkedList;

/**
 * 588号题
 * https://www.lintcode.com/problem/partition-equal-subset-sum/description
 * @author wangw
 * @version $$Id: partition_equal_subset_sum, v 0.1 2018/5/14 0014 19:13 wangw Exp $$
 */
public class partition_equal_subset_sum {
    /**
     * @param nums: a non-empty array only positive integers
     * @return: true if can partition or false
     */
    public boolean canPartition(int[] nums) {
        //先排序
        //因为都不大于100 空间换时间 直接用计数排序
        int count = 0;
        int[] positions = new int[101];
        int[] sorts = new int[nums.length];
        for(int i : nums){
            positions[i]++;
        }
        for(int i=1;i<positions.length;i++){
            positions[i]+=positions[i-1];
        }
        for(int i=nums.length -1;i>=0;i--){
            int num = nums[i];
            int position = --positions[num];
            sorts[position]=num;
            //顺便计算出数组的元素和
            count += num;
        }
        //小套路,元素和是基数直接false
        if((count & 1) == 0){
            count >>= 1;
        }else{
            //元素和非偶,直接关了
            return false;
        }
        //排序完毕,接下来开始动态规划
        //根据题意,搞两个子数组
        LinkedList<Integer> side1 = new LinkedList<>();
        LinkedList<Integer> side2 = new LinkedList<>();
        int countSide1 = 0;
        int countSide2 = 0;
        //开始从最大的元素开始考虑状态
        int max=sorts[sorts.length -1];
        //将max放入side1
        side1.add(max);
        countSide1 += max;
        if(countSide1 > count){
            return false;
        }else if(countSide1 == count){
            return true;
        }
        //算出剩余还需多少
        int remain1 = count - countSide1;
        //假设存在的话,side1里面的其他元素肯定都小于等于remain1,那么大于remain1的除了max的其他元素都处于side2中
        //positions[count]是最小的一个大于count的元素位置
        for(int position = positions[count];position<sorts.length -1;position++){
            side2.add(sorts[position]);
            countSide2+=sorts[position];
        }
        if(countSide2 > count){
            return false;
        }else if(countSide2 == count){
            return true;
        }
        int remain2 = count - countSide1;
        //同理,假设存在的话,side2里面的其他元素肯定都小于等于remain2,那么大于remain2的小于等于remain1的其他元素都处于side1中

        //接下来,剩余没被分配的是下标0~positions[count]-1的元素
        //同时题目转换为了查找剩余元素中,元素和加起来等于count的子数组
        //又从最大的开始
        int max1 = sorts[positions[count]-1];
        //因为这时countSide1!=countSide2,所以有两种放法
        return true;
    }

    public boolean canPartition1(int[] nums) {
        //先排序
        //因为都不大于100 空间换时间 直接用计数排序
        int length = nums.length;
        int count = 0;
        int[] positions = new int[101];
        int[] sorts = new int[nums.length];
        for(int i : nums){
            positions[i]++;
        }
        for(int i=1;i<positions.length;i++){
            positions[i]+=positions[i-1];
        }
        for(int i=nums.length -1;i>=0;i--){
            int num = nums[i];
            int position = --positions[num];
            sorts[position]=num;
            //顺便计算出数组的元素和
            count += num;
        }
        //小套路,元素和是基数直接false
        if((count & 1) == 0){
            count >>= 1;
        }else{
            //元素和非偶,直接关了
            return false;
        }
        //排序完毕,接下来开始动态规划
        return dynamicFind(sorts,positions,length,count);
    }

    private boolean dynamicFind(int[] sorts,int[] positions,int length,int count){
        /*问题分析:
        * 可以转变为length长的数组中是否存在元素和为count的子数组问题
        * */
        //从最大的元素出发
        int max = sorts[length-1];
        if(max > count){
            //转变为length-1长的数组中,是否存在元素和为count的子数组问题
            //显而易见,边界条件如下:
            if(length==1){
                return false;
            }
            return dynamicFind(sorts, positions, length-1, count);
        }else if (max == count){
            //直接找到了
            return true;
        }else{
            int nextCount =count - max;
            int nextLength =0;
            for(int i = length -2;i>=0;i--){
                if(sorts[i]<=nextCount){
                    nextLength = i;
                    break;
                }
            }
            /*
            根据假设这个子数组是否包含max转变为
            length-1长的数组中,是否存在元素和为count的子数组
            或
            nextLength长的数组中是否存在元素和为nextCount的子数组问题
             */
            //显而易见,边界条件如下:
            if(nextLength==0 || length==1){
                return false;
            }
            return dynamicFind(sorts, positions, nextLength, nextCount) || dynamicFind(sorts, positions, length-1, count);
        }
    }
}
