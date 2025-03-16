package baekjoon.mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution1759 {
    static int L, C; // L : 암호의 길이, C : 사용 가능한 문자 수
    static char[] chars; // C 개의 문자 저장
    static char[] selected; // 현재 선택한 암호 저장

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        chars = new char[C];
        selected = new char[L];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            chars[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(chars); // 알파벳 순서대로 정렬

        dfs(0, 0, 0, 0);
    }

    static void dfs(int len, int start, int vowel, int consonant) {
        // len : 현재 선택한 문자 개수, start : 다음 선택할 문자 인덱스, vowel : 선택한 모음 수, consonant : 선택한 자음 수
        if (len == L) {
            if (vowel >= 1 && consonant >= 2) {
                System.out.println(new String(selected));
            }
            return;
        }

        for (int i = start; i < C; i++) {
            selected[len] = chars[i];

            if (isVowel(chars[i])) {
                dfs(len + 1, i + 1, vowel + 1, consonant);
            } else {
                dfs(len + 1, i + 1, vowel, consonant + 1);
            }
        }
    }

    static boolean isVowel(char c) {
        // 모음 판별 메서드
        return "aeiou".indexOf(c) != -1;
    }
}
