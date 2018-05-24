package lintcode;

/**
 * 392. 打劫房屋
 * https://www.lintcode.com/problem/house-robber/description
 */
public class house_robber {
    /**
     * @param A: An array of non-negative integers
     * @return: The maximum amount of money you can rob tonight
     */
    public long houseRobber(int[] A) {
        //跟经典的爬楼梯没什么区别,分析见下面的方法,这里直接开写
        if(A.length==0){
            return 0;
        }
        if(A.length==1){
            return A[0];
        }
        if(A.length==2){
            return Math.max(A[0],A[1]);
        }
        long max=0;
        long fn_2=A[0];
        long fn_1= Math.max(A[0],A[1]);
        for(int i=2;i<A.length;i++){
            max = Math.max(fn_1,fn_2+A[i]);
            fn_2 = fn_1;
            fn_1 =max;
        }
        return max;
    }

    public long raider(int[] a,int n){
        //边界条件
        if(n==1){
            return a[0];
        }
        if(n==2){
            return Math.max(a[0],a[1]);
        }
        //状态转移方程
        /*
        if f(n-1)中 n-1 没被收录
        f(n)= f(n-1) + n
        n-1 被收录
        f(n-2) + n > f(n-1) ? f(n-2) = n : f(n-1)
         */
        //f(n) = max(f(n-1),f(n-2)+a[n-1]);
    }
}
