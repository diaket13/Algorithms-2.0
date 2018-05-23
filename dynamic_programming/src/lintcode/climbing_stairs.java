package lintcode;

/**
 * CA
 * 111. 爬楼梯
 * https://www.lintcode.com/problem/climbing-stairs/description
 */
public class climbing_stairs {
    /**
     * @param n: An integer
     * @return: An integer
     */
    public int climbStairs(int n) {
        /*
        最简单的动态规划题
         */
        //给出边界
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        //状态转移方程 F(N) = F(N-1) + F(N-2)
        int fn_1 = 2;
        int fn_2 = 1;
        int fn = 0;
        for(int i =3;i<=n;i++){
            fn = fn_1 +fn_2;
            fn_2 =fn_1;
            fn_1 = fn;
        }
        return fn;
    }

}
