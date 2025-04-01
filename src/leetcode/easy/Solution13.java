package leetcode.easy;

import java.util.Map;

public class Solution13 {
    public int romanToInt(String s) {
        Map<Character, Integer> roman = Map.of(
                'I', 1,
                'V', 5,
                'X', 10,
                'L', 50,
                'C', 100,
                'D', 500,
                'M', 1000
        );
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            int curr = roman.get(s.charAt(i));
            if (i < s.length() - 1) {
                int next = roman.get(s.charAt(i + 1));
                if (isSubstractive(s.charAt(i), s.charAt(i + 1))) {
                    sum -= curr;
                } else {
                    sum += curr;
                }
            } else {
                sum += curr;
            }
        }
        return sum;
    }

    private boolean isSubstractive(char curr, char next) {
        return (curr == 'I' && (next == 'V' || next == 'X')) ||
                (curr == 'X' && (next == 'L' || next == 'C')) ||
                (curr == 'C' && (next == 'D' || next == 'M'));
    }
}
