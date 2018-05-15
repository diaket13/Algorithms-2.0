package lintcode;

/**
 * WA
 * 971号题
 * https://www.lintcode.com/problem/surplus-value-backpack/description
 */
public class surplus_value_backpack {
    /**
     * @param k1: The coefficient of A
     * @param k2: The  coefficient of B
     * @param c: The volume of backpack
     * @param n: The amount of A
     * @param m: The amount of B
     * @param a: The volume of A
     * @param b: The volume of B
     * @return: Return the max value you can get
     */
    public long getMaxValue(int k1, int k2, int c, int n, int m, int[] a, int[] b) {
        // Write your code here
        long maxValue = 0L;
        //if k1 < k2
        if (k1 > k2) {
            int temp = k1;
            k1 = k2;
            k2 = temp;
            int[] clone = a.clone();
            a = b.clone();
            b = clone.clone();
            temp = n;
            n = m;
            m = temp;
        }
        /*
        贪心算法,思路如下:
        每次寻找放入后价值最大(且体积最小)的物品
        直到什么都放不下为止
        over
         */
        while (true) {
            long max = 0L;
            int position1 = -1;
            for (int i = 0; i < n; i++) {
                long value = (long) k1 * (c - a[i]);
                if (max < value) {
                    max = value;
                    position1 = i;
                }
            }
            int position2 = -1;
            for (int i = 0; i < m; i++) {
                long value = (long) k2 * (c - b[i]);
                if (max < value) {
                    max = value;
                    position2 = i;
                }
            }
            maxValue += max;
            if (position2 > -1) {
                c -= b[position2];
                b[position2] = c;
            } else if (position1 > -1) {
                c -= a[position1];
                a[position1] = c;
            } else {
                return maxValue;
            }
        }
    }

    public static void main(String[] args) {
        int a = Integer.MAX_VALUE;
        int b = 222;
        long c = a * (long) b;
        long d = 222;
        d *= a;
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
    }
}
