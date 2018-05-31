package linked_list.lintcode;

/**
 * 1229. Circular Array Loop
 * https://www.lintcode.com/problem/circular-array-loop/description
 * @author wangw
 * @version $$Id: circular_array_loop, v 0.1 2018/5/31 0031 17:38 wangw Exp $$
 */
public class circular_array_loop {
    /**
     * @param nums: an array of positive and negative integers
     * @return: if there is a loop in this array
     */
    public boolean circularArrayLoop(int[] nums) {
        /*把数组链表化
        两个注意点:
        1.走过的位置,将其置为0,用于当其他的路线走到这里的时候就直接结束.节省时间

         */
        if(nums.length ==0){
            return false;
        }
        for(int i =0;i<nums.length;i++){
            if(nums[i]==0){
                continue;
            }
            boolean forward = nums[i] > 0;
            int now =i;
            while (true){
                if ((forward && nums[now] < 0) || (!forward && nums[now] > 0)) {
                    break;
                }
                int next = (now + nums[now]) % nums.length;
                if (next < 0) {
                    next += nums.length;
                }
                nums[now] = 0;
                if (now != i && next == i) {
                    return true;
                }
                if (nums[next] == 0) {
                    break;
                }
                now = next;
            }
        }
        return false;
    }

}
