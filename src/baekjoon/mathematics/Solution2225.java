package baekjoon.mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution2225 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] dp = new int[K + 1][N + 1];

        for (int i = 0; i <= K; i++) {
            // 0을 만드는 방법은 항상 1개
            dp[i][0] = 1;
        }

        for (int k = 1; k <= K; k++) {
            for (int n = 0; n <= N; n++) {
                if (n > 0) {
                    // K 개의 숫자 중 마지막 숫자가 0 이상 -> K-1 개의 숫자로 N을 만들어야함 (dp[k - 1][n])
                    // 마지막 숫자가 1 이상 -> K 개의 숫자로 N-1 만들어야함 (dp[k][n - 1])
                    dp[k][n] = (dp[k - 1][n] + dp[k][n - 1]) % 1000000000;
                } else {
                    // 0을 만드는 방법은 항상 1개
                    dp[k][n] = dp[k - 1][n];
                }
            }
        }

        System.out.println(dp[K][N]);
    }
}
