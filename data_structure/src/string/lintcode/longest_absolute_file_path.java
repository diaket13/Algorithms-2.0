package string.lintcode;

import java.util.ArrayList;

/**
 * CA
 * 643. Longest Absolute File Path
 * https://www.lintcode.com/problem/longest-absolute-file-path/description
 * @author wangw
 * @version $$Id: longest_absolute_file_path, v 0.1 2018/6/14 0014 16:23 wangw Exp $$
 */
public class longest_absolute_file_path {

    /**
     * @param input: an abstract file system
     * @return: return the length of the longest absolute path to file
     */
    public int lengthLongestPath(String input) {
        /*将字符串变成字符数组,对\n \t . 三个字符特殊处理就好
        * \n 代表新行 统计上一行的东西然后清0
        * \t 代表目录位置 有几个就是几级目录
        * . 代表是文件*/
        char[] chars = input.toCharArray();
        int length = 0;
        int part = 0;
        int position = 0;
        boolean isFile = false;
        ArrayList<Integer> dir = new ArrayList<>();
        for (char c : chars) {
            if (c == '\n') {
                if (isFile) {
                    int len = 0;
                    for (int i = 0; i < position; i++) {
                        len += dir.get(i);
                        len++;
                    }
                    len += part;
                    if (len > length) {
                        length = len;
                    }
                } else {
                    dir.add(position, part);
                }

                part = 0;
                position = 0;
                isFile = false;
                continue;
            }
            if (c == '\t') {
                position++;
                continue;
            }
            if (c == '.') {
                isFile = true;
            }
            part++;
        }
        if (isFile) {
            int len = 0;
            for (int i = 0; i < position; i++) {
                len += dir.get(i);
                len++;
            }
            len += part;
            if (len > length) {
                length = len;
            }
        }
        return length;
    }

}
