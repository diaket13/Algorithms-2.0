package lintcode;

import java.util.LinkedList;
import java.util.List;

/**
 * CA
 * 427. 生成括号
 * https://www.lintcode.com/problem/generate-parentheses/description
 * @author wangw
 * @version $$Id: generate_parentheses, v 0.1 2018/6/14 0014 17:45 wangw Exp $$
 */
public class generate_parentheses {

    private List<String> list = new LinkedList<>();

    /**
     * @param n: n pairs
     * @return: All combinations of well-formed parentheses
     */
    public List<String> generateParenthesis(int n) {
        addList(0, 0, n, new StringBuilder(2 * n));
        return list;
    }

    /*找到规则就好办了,这个的规则如下:
    * 字符串中左括号的数量不小于右括号的数量
    * 当左括号和右括号的数量都为n时 输出字符串
    * 接着不断递归,添加括号*/
    void addList(int left, int right, int n, StringBuilder stringBuilder) {
        if (right == left) {
            if (right == n) {
                list.add(stringBuilder.toString());
            } else {
                stringBuilder.append('(');
                addList(left + 1, right, n, stringBuilder);
            }
        } else {
            StringBuilder s2 = new StringBuilder(2 * n);
            s2.append(stringBuilder);
            if (left < n) {
                stringBuilder.append('(');
                addList(left + 1, right, n, stringBuilder);
            }
            s2.append(')');
            addList(left, right + 1, n, s2);
        }
    }

}
