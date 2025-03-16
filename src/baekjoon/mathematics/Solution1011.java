package baekjoon.mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1011 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = y - x; // 총 이동 거리

            int k = (int) Math.sqrt(d);

            if (d == k * k) {
                sb.append(2 * k - 1).append("\n");
            } else if (d <= k * k + k) {
                sb.append(2 * k).append("\n");
            } else {
                sb.append(2 * k + 1).append("\n");
            }
        }
        System.out.println(sb);

    }
}
