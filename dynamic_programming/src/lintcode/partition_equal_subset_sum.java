package lintcode;

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
        //排序完毕,接下来开始动态规划
        if((count & 1) == 0){
            count >>= 1;
        }else{
            //元素和非偶,直接关了
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int i = 2222222;
        System.out.println(i&1);
        int j = 3;
        System.out.println(j&1);
        System.out.println(i>>1);
        System.out.println(i);
    }
}
