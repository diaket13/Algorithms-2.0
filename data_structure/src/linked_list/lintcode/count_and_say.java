package linked_list.lintcode;

import java.util.LinkedList;

/**
 * 420. 报数
 * https://www.lintcode.com/problem/count-and-say/description
 * @author wangw
 * @version $$Id: count_and_say, v 0.1 2018/5/31 0031 11:40 wangw Exp $$
 */
public class count_and_say {
    /**
     * @param n: the nth
     * @return: the nth sequence
     */
    public String countAndSay(int n) {
        //字符串的处理 可以用char链表来做,省事
        LinkedList<Character> string = new LinkedList<>();
        string.add('1');
        LinkedList<Character> nextString = new LinkedList<>();
        //每次都报数string,结果记到nextString 最后将nextString的结果放到string 开始下一轮
        //n-- 提高代码阅读难度~~
        while (n-->1){
            int count = 0;
            Character now = null;
            for(char c : string){
                if(count == 0){
                    now = c;
                    count ++;
                    continue;
                }
                //逻辑就跟问题描述的一样,很简单,不复述
                if(now == c){
                    count++;
                }else {
                    //这个地方做个处理,因为计数很难超过10,所以10一下用简单的方式处理了
                    if(count<10){
                        nextString.add((char) ('0' + count));
                    }else {
                        char[] countNums = Integer.toString(count).toCharArray();
                        for (char num : countNums){
                            nextString.add(num);
                        }
                    }
                    nextString.add(now);
                    now = c;
                    count = 1;
                }
            }
            //跳出循环后,把剩余的给处理了
            if(now != null){
                if(count<10){
                    nextString.add((char) ('0' + count));
                }else {
                    char[] countNums = Integer.toString(count).toCharArray();
                    for (char num : countNums){
                        nextString.add(num);
                    }
                }
                nextString.add(now);
            }
            string = nextString;
            nextString = new LinkedList<>();
        }
        StringBuilder sb = new StringBuilder();
        for(char c : string){
            sb.append(c);
        }
        return sb.toString();
    }

}
