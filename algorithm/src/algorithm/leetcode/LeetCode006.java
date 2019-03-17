package algorithm.leetcode;

import java.util.ArrayList;

public class LeetCode006 {

    public static String convert(String s, int numRows) {
        if (numRows == 1) return s;

        ArrayList<StringBuilder> zigzag = new ArrayList();
        for (int i = 0; i < Math.min(numRows, s.length()); i++)
            zigzag.add(new StringBuilder());

        boolean goingDown = false;
        int currRow = 0;

        for (char ch : s.toCharArray()) {
            zigzag.get(currRow).append(ch);

            if (currRow == numRows - 1 || currRow == 0) goingDown = !goingDown;

            currRow += goingDown ? 1 : -1;
        }

        StringBuilder res = new StringBuilder();
        for (StringBuilder sb : zigzag)
            res.append(sb.toString());


        return res.toString();
    }


    public static void main(String[] args) {
        System.out.println(convert("", 1));
    }
}
