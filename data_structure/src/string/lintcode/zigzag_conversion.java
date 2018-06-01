package string.lintcode;

import java.util.ArrayList;
import java.util.ListIterator;

/**
 * CA
 * 1363. ZigZag Conversion
 * https://www.lintcode.com/problem/zigzag-conversion/description
 * @author wangw
 * @version $$Id: zigzag_conversion, v 0.1 2018/6/1 0001 18:43 wangw Exp $$
 */
public class zigzag_conversion {
    /**
     * @param s: the given string
     * @param numRows: the number of rows
     * @return: the string read line by line
     */
    public String convert(String s, int numRows) {
        /*
        Z变换,实则是按一定规律排列添加字符
        设numRows个链表或者StringBuilder 然后正序倒序来回不停地每次往其中一个对象添加1个字符
         */
        //特殊情况处理了
        if(numRows == 1){
            return s;
        }
        //第一步 建存储结构
        ArrayList<StringBuilder> list = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuilder());
        }
        //第二步,来回遍历填充这里利用listIterator
        ListIterator iter = list.listIterator();
        //down代表时候是往后遍历
        boolean down = true;
        char[] chars = s.toCharArray();
        StringBuilder sb;
        //反复遍历填充
        for (char c : chars) {
            if (down) {
                if (iter.hasNext()) {
                    sb = (StringBuilder) iter.next();
                } else {
                    iter.previous();
                    sb = (StringBuilder) iter.previous();
                    down = !down;
                }
                sb.append(c);
            } else {
                if (iter.hasPrevious()) {
                    sb = (StringBuilder) iter.previous();
                } else {
                    iter.next();
                    sb = (StringBuilder) iter.next();
                    down = !down;
                }
                sb.append(c);
            }
        }
        //第三步,汇总
        StringBuilder all = new StringBuilder();
        for(StringBuilder part : list){
            all.append(part);
        }
        return all.toString();
    }
}
