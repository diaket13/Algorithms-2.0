package lintcode;

/**
 * CA
 * 65. 两个排序数组的中位数
 * https://www.lintcode.com/problem/median-of-two-sorted-arrays/description
 * @author wangw
 * @version $$Id: median_of_two_sorted_arrays, v 0.1 2018/5/25 0025 18:38 wangw Exp $$
 */
public class median_of_two_sorted_arrays {
    //此代码有太多值得改进和优化的地方,但是时间复杂度是O(log n)的,不过常数项花的时间太多
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
            double special = specialCase(A,B,halfNum,false);
            if(special != -1.1){
                return special;
            }
            if(A.length > B.length){
                position = (-1 + B.length) / 2 ;
               return findMedian(halfNum,position,-1,B.length,B,A);
            }else {
                position = (-1 + A.length) / 2 ;
              return   findMedian(halfNum,position,-1,A.length,A,B);
            }
        }else{
            double special = specialCase(A,B,halfNum,true);
            if(special != -1.1){
                return special;
            }
            if(A.length > B.length){
                position = (-1 + B.length) / 2 ;
              return   findTwoMedian(halfNum,position,-1,B.length,B,A);
            }else {
                position = (-1 + A.length) / 2 ;
              return   findTwoMedian(halfNum,position,-1,A.length,A,B);
            }
        }
    }

    private double specialCase(int[] a, int[] b, int halfNum, boolean findTwo){
        if (findTwo) {
            if(b.length==0){
                return ( a[halfNum] + a[halfNum -1])/2.0;
            }
            if(a.length==0){
                return (b[halfNum] + b[halfNum-1])/2.0;
            }
            if (b[0] >= a[a.length - 1]) {
                return specialDael(b,a,halfNum);
            }
            if (a[0] >= b[b.length - 1]) {
                return specialDael(a,b,halfNum);
            }
            return -1.1;
        }else {
            if(b.length==0){
                return a[halfNum]+0.0;
            }
            if(a.length==0){
                return b[halfNum]+0.0;
            }
            if(b[0] >= a[a.length - 1]){
                if(a.length - 1< halfNum){
                    return b[halfNum - a.length]+0.0;
                }
                return a[halfNum]+0.0;
            }
            if (a[0] >= b[b.length - 1]){
                if(b.length - 1< halfNum){
                    return a[halfNum - b.length]+0.0;
                }
                return b[halfNum]+0.0;
            }
            return -1.1;
        }
    }
    private double specialDael(int[] big, int[] small, int halfNum){
        if (small.length == halfNum) {
            return (big[0] + small[small.length - 1]) / 2.0;
        } else if (halfNum < small.length) {
            return (small[halfNum] + small[halfNum - 1]) / 2.0;
        } else {
            return (big[halfNum - small.length] + big[halfNum - small.length - 1]) / 2.0;
        }
    }

    private double findMedian(int halfNum, int position, int left, int right, int[] divide, int[] other){
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
        return -1.1;
    }
    private double findTwoMedian(int halfNum, int position, int left, int right, int[] divide, int[] other){
        int aNum = divide[position];
        //position左边共有 position个元素 还差 halfNum - position个
        int bNum = other[halfNum-position];
        //aNum 和 bNum 左边共有halfNum个元素
        int bNum_left = other[halfNum-position-1];
        //aNum在这两个元素中间的话,说明小于或等于aNum的元素有halfNum个,即aNum为2个中位数的右边那个
        if(aNum >= bNum_left && aNum <=bNum){
            int aNum_left = divide[position-1];
            //那么左边那个中位数是谁呢? aNum_left和bNum_left分别是两个数组中最靠近aNum的,所以两者取大即可
            if(aNum_left < bNum_left){
                return (aNum + bNum_left)/2.0;
            }else {
                return (aNum + aNum_left)/2.0;
            }
        }
        if(aNum < bNum_left){
            /*right代表position为right时,中位数应该在right左边,
            而position和right之间已没其他元素,所以,bNum_left和right的左边共有halfNum个,divide[right]>bNum_left
             那么,小于或等于bNum_left的元素有halfNum个,即bNum_left为2个中位数的右边那个
            */
            if(position == right - 1){
                int bNum_left_left = other[halfNum-position-2];
                //那么左边那个就是aNum和bNum_left_left的较大值
                if(aNum > bNum_left_left){
                    return (aNum + bNum_left)/2.0;
                }else {
                    return (bNum_left_left + bNum_left)/2.0;
                }
            }
            int nextPosition = (position + right) / 2;
            return findTwoMedian(halfNum,nextPosition,position,right,divide,other);
        }
        if(aNum > bNum){
            /*
            同理 left代表position为left时,中位数在left右边,而position和left之间已没其他元素,だから,
            小于或等于bNum的元素有halfNum个,即bNum为2个中位数的右边那个
             */
            if(position == left + 1){
                //那么左边那个就是divide[right]和bNum_left争
                int aNum_left = divide[position-1];
                if(aNum_left < bNum_left){
                    return (bNum + bNum_left)/2.0;
                }else {
                    return (bNum + aNum_left)/2.0;
                }
            }
            int nextPosition = (left + position) / 2;
            return findTwoMedian(halfNum,nextPosition,left,position,divide,other);
        }
        return -1.1;
    }
}
