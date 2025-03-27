package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution1193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());

        // 대각선 번호 찾기
        int line = 1;
        while (line * (line + 1) / 2 < x) {
            line++;
        }

        // 바로 이전 대각선까지의 총 분수 개수
        int prevCount = (line - 1) * line / 2;
        // 현재 대각선에서의 위치
        int offset = x - prevCount;

        int numerator, denominator;
        // 짝수 대각선
        if (line % 2 == 0) {
            numerator = offset;
            denominator = line - offset + 1;
        } else {
            // 홀수
            numerator = line - offset + 1;
            denominator = offset;
        }

        System.out.println(numerator + "/" + denominator);

    }
}
