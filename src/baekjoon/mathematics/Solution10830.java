package baekjoon.mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution10830 {
    static int N;
    static long B;
    static int[][] arr;
    static int MOD = 1000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        B = Long.parseLong(st.nextToken());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken()) % MOD;
            }
        }
        int[][] r = calculate(arr, B);

        StringBuilder sb = new StringBuilder();
        for (int[] row : r) {
            for (int j = 0; j < N; j++) {
                sb.append(row[j]);
                if (j != N - 1) sb.append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    static int[][] calculate(int[][] a, long b) {
        if (b == 1L) return a;

        int[][] half = calculate(a, b / 2);
        int[][] result = multiply(half, half);

        if (b % 2 == 1) {
            result = multiply(result, a);
        }
        return result;
    }

    static int[][] multiply(int[][] arrA, int[][] arrB) {
        int n = arrA.length;
        int[][] res = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    res[i][j] += (arrA[i][k] * arrB[k][j]) % MOD;
                }
                res[i][j] %= MOD;
            }
        }
        return res;
    }
}
