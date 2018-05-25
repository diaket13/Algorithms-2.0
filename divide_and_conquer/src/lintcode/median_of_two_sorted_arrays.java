package lintcode;

/**
 * 65. 两个排序数组的中位数
 * https://www.lintcode.com/problem/median-of-two-sorted-arrays/description
 * @author wangw
 * @version $$Id: median_of_two_sorted_arrays, v 0.1 2018/5/25 0025 18:38 wangw Exp $$
 */
public class median_of_two_sorted_arrays {
    /*
    * @param A: An integer array
    * @param B: An integer array
    * @return: a double whose format is *.5 or *.0
    */
    public double findMedianSortedArrays(int[] A, int[] B) {
        int num = A.length + B.length;
        if ((num & 1) == 1) {
            return findSingle(A, B, num / 2 + 1);
        } else {
            return findDouble(A, B, num / 2, num / 2 + 1);
        }
    }

    private double findSingle(int[] a, int[] b, int position) {
        return 0.0;
    }

    private double findDouble(int[] a, int[] b, int left, int right) {
        return 0.5;
    }
}
