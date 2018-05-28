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
        int halfNum = num / 2 + 1;
        int position;
        if(A.length > B.length){
            position = B.length / 2 + 1;
            findMedian(halfNum,position,B,A);
        }else {
            position = A.length / 2 + 1;
            findMedian(halfNum,position,A,B);
        }
    }

    double findMedian(int halfNum,int position,int[] divide,int[] other){
        int aNum = divide[position];
        int bNum = other[halfNum-position];
    }
}
