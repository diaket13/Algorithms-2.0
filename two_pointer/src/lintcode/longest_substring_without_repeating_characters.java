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
        //两根指针,一根指向开头,一根往后遍历
        int begin=0,end;
        //再来个目前找到的最长的子串的长度
        int length = 0;
        //最后来个hash表来保存已经出现过的字符
        HashMap<Character,Boolean> map = new HashMap<>();
        //先获取字符串的char数组
        char[] chars = s.toCharArray();
        if(chars.length==1){
            return 1;
        }
        for(end = 0;end<chars.length;end++){
            char c = chars[end];
            Boolean exist = map.get(c);
            if(exist!=null && exist){
                length = length < end-begin ? end-begin : length;
                for(;begin)
            }

        }
        // write your code here
    }

}
