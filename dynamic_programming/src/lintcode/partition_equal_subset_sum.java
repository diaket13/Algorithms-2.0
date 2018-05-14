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
        }
        int count = 0;
        int max = -1;
        for(int i : nums){
            count += i;
            max = max > i ? max:i;
        }
        //if max * 2 > count, can't find
        if(max * 2 > count){
            return false;
        }
        if(max * 2 == count){
            return true;
        }
    }

}
