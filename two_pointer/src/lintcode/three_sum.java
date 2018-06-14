package lintcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * CA
 * 57. 三数之和
 * https://www.lintcode.com/problem/3sum/description
 * @author wangw
 * @version $$Id: three_sum, v 0.1 2018/6/4 0004 10:39 wangw Exp $$
 */
public class three_sum {

    /**
     * @param numbers: Give an array numbers of n integer
     * @return: Find all unique triplets in the array which gives the sum of zero.
     */
    public List<List<Integer>> threeSum(int[] numbers) {
        /*先排序 然后从头遍历 将此数记为first
        * 接着将first后面一位的数记为second
        * 数组最后一位的数记为third
        * 接着 second和third的位置都玩中间走,直到相遇*/
        Arrays.sort(numbers);
        List<List<Integer>> list = new LinkedList<>();
        Integer last = null;
        for (int i = 0; i < numbers.length - 2; i++) {
            int first = numbers[i];
            if (last != null) {
                if (last == first) {
                    continue;
                }
            }
            int j = i + 1;
            int k = numbers.length - 1;
            int second = numbers[j];
            int third = numbers[k];
            /*如果三个数相加大于0 则third减小 小于0 则second增大
            * 因为是排过序的
            * 要使得相加的数减小 只能让third的位置左移
            * 同理 相加的数增大 只能让second的位置右移
            * 这样只需要o(n)的时间复杂度就可以将位置i为first的所有情况遍历完
            * 总共的时间复杂度是o(n^2)*/
            while (j < k) {
                if (first + second + third > 0) {
                    while (j < k) {
                        int next = numbers[--k];
                        if (third != next) {
                            third = next;
                            break;
                        }
                    }
                    continue;
                }
                if (first + second + third == 0) {
                    List<Integer> integer = new ArrayList<>(3);
                    integer.add(first);
                    integer.add(second);
                    integer.add(third);
                    list.add(integer);
                }
                while (j < k) {
                    int next = numbers[++j];
                    if (second != next) {
                        second = next;
                        break;
                    }
                }
            }
            last = first;
        }
        return list;
    }

}
