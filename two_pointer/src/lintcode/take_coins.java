package lintcode;

/**
 * CA
 * 1399. 拿硬币
 * https://www.lintcode.com/problem/take-coins/description
 * @author wangw
 * @version $$Id: take_coins, v 0.1 2018/5/23 0017 00:29 wangw Exp $$
 */
public class take_coins {
    /**
     * @param list: The coins
     * @param k: The k
     * @return: The answer
     */
    public int takeCoins(int[] list, int k) {
        /*
         依然是比较每一种情况的长度,取最长的,但是每一种情况之间存在联系.
         即A的取值是:[0~x]+[y~length-1] 与 B的取值:[0~x-1]+[y-1~length-1]之间只差了2个数
         所以,在已知一个情况的长度的情况下,可以仅通过O(1)的时间就算出下一个情况的长度
         那么,该算法的时间复杂度就是O(k) + O(k*1) = O(k)
          */
        int max =0;
        int i;
        //先计算情况[0~k-1]的长度
        for(i =0;i<k;i++){
            max+=list[i];
        }
        i=k-1;
        int temp =max;
        for(int j=list.length-1;j>(list.length-k-1);j--,i--){
            //这里每次计算的情况是 [0~i-1]+[j~length-1]
            temp = temp + list[j] - list[i];
            if(temp > max){
                //保留最大的
                max = temp;
            }
        }
        return max;
    }

}
