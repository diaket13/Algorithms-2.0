package lintcode;

import java.util.HashMap;

/**
 * 384. 最长无重复字符的子串
 * https://www.lintcode.com/problem/longest-substring-without-repeating-characters/description
 * @author wangw
 * @version $$Id: longest_substring_without_repeating_characters, v 0.1 2018/5/17 0017 16:18 wangw Exp $$
 */
public class longest_substring_without_repeating_characters {
    /**
     * @param s: a string
     * @return: an integer
     */
    public int lengthOfLongestSubstring(String s) {
        //两根指针,一根指向开始,一根往后遍历
        int begin=0,end;
        //再来个目前找到的最长的子串的长度
        int length = 0;
        //最后来个hash表来保存已经出现过的字符
        HashMap<Character,Boolean> map = new HashMap<>(26);
        //先获取字符串的char数组
        char[] chars = s.toCharArray();
        if(chars.length==1){
            return 1;
        }
        /*
        子字符串位置从begin到end
        具体思路,end从0开始,找到重复的字符就将此字符第一次出现的位置+1标记为子字符串的开始位置,即begin.
        保证begin到end之间的所有字符都是不重复的
         */
        //开始从头找
        for(end = 0;end<chars.length;end++){
            char c = chars[end];
            Boolean exist = map.get(c);
            //每遍历一个,就从哈希表中查看是否出现过
            if(exist!=null && exist){
                //出现了,就先计算当前字符串的长度,将较长的存入length
                length = length < end-begin ? end-begin : length;
                //再把从开始位置到出现的字符的位置之前的所有字符都设置为未出现
                for(;begin<end;begin++){
                    char b = chars[begin];
                    if(b == c){
                        //并将开始位置设置为出现的字符的位置+1
                        begin++;
                        break;
                    }
                    map.put(b,false);
                }
            }else{
                //没出现,则记为出现
                map.put(c,true);
            }
        }
        return length < end-begin ? end-begin : length;
    }

}
