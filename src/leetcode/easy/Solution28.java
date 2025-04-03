package leetcode.easy;

public class Solution28 {
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) return 0;

        int hLength = haystack.length();
        int nLength = needle.length();

        // haystack의 길이가 needle보다 짧으면 -1
        if (hLength < nLength) return -1;

        // haystack에서 needle을 찾기
        for (int i = 0; i <= hLength - nLength; i++) {
            int j = 0;
            while (j < nLength && haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            }
            if (j == nLength) {
                return i;  // 첫 번째로 일치하는 인덱스 반환
            }
        }

        return -1;  // 일치하지 않으면 -1 반환
    }

    public static void main(String[] args) {
        Solution28 solution28 = new Solution28();
        String haystack = "leetcode";
        String needle = "leeto";
        System.out.println(solution28.strStr(haystack, needle));  // 출력: -1
    }
}
