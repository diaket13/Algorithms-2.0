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
        int halfNum = num / 2;
        int position;
        if((num & 1)==1){
            if(A.length > B.length){
                position = (-1 + B.length) / 2 ;
                findMedian(halfNum,position,-1,B.length,B,A);
            }else {
                position = (-1 + A.length) / 2 ;
                findMedian(halfNum,position,-1,A.length,A,B);
            }
        }else{
            if(A.length > B.length){
                position = (-1 + B.length) / 2 ;
                findTwoMedian(halfNum,position,-1,B.length,B,A);
            }else {
                position = (-1 + A.length) / 2 ;
                findTwoMedian(halfNum,position,-1,A.length,A,B);
            }
        }
    }

    double findMedian(int halfNum,int position,int left,int right,int[] divide,int[] other){
        int aNum = divide[position];
        //position左边共有 position个元素 还差 halfNum - position个
        int bNum = other[halfNum-position];
        //aNum 和 bNum 左边共有halfNum个元素
        int bNum_left = other[halfNum-position-1];
        //aNum在这两个元素中间的话,说明小于或等于aNum的元素有halfNum个,则aNum为中位数
        if(aNum >= bNum_left && aNum <=bNum){
            return aNum+0.0;
        }
        if(aNum < bNum_left){
            if(position == right - 1){
                return bNum_left+0.0;
            }
            int nextPosition = (position + right) / 2;
            return findMedian(halfNum,nextPosition,position,right,divide,other);
        }
        if(aNum > bNum){
            if(position == left + 1){
                return bNum+0.0;
            }
            int nextPosition = (left + position) / 2;
            return findMedian(halfNum,nextPosition,left,position,divide,other);
        }
    }
    double findTwoMedian(int halfNum,int position,int left,int right,int[] divide,int[] other){
        int aNum = divide[position];
        //position左边共有 position个元素 还差 halfNum - position个
        int bNum = other[halfNum-position];
        //aNum 和 bNum 左边共有halfNum个元素
        int bNum_left = other[halfNum-position-1];
        //aNum在这两个元素中间的话,说明小于或等于aNum的元素有halfNum个,即aNum为2个中位数的右边那个
        if(aNum >= bNum_left && aNum <=bNum){
            int aNum_left = divide[position-1];
            if(aNum_left < bNum_left){
                return (aNum + bNum_left)/2.0;
            }else {
                return (aNum + aNum_left)/2.0;
            }
        }
        if(aNum < bNum_left){
            //right代表上一次查的结果 中位数应该在right左边
            if(position == right - 1){
                return bNum_left+0.0;
            }
            int nextPosition = (position + right) / 2;
            return findMedian(halfNum,nextPosition,position,right,divide,other);
        }
        if(aNum > bNum){
            if(position == left + 1){
                return bNum+0.0;
            }
            int nextPosition = (left + position) / 2;
            return findMedian(halfNum,nextPosition,left,position,divide,other);
        }
    }
}
