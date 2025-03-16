package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution14500 {
    static int N, M;
    static int[][] nums;
    static boolean[][] visited;
    static int maxSum = 0;

    static int[] dx = {0, 0, -1, 1}; // 동, 서, 남, 북
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nums = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                nums[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                dfs(i, j, 1, nums[i][j]);
                visited[i][j] = false;

                checkException(i, j);
            }
        }

        System.out.println(maxSum);
    }

    static void dfs(int x, int y, int depth, int sum) {
        if (depth == 4) {
            maxSum = Math.max(maxSum, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < N && ny < M && !visited[nx][ny]) {
                visited[nx][ny] = true;
                dfs(nx, ny, depth + 1, sum + nums[nx][ny]);
                visited[nx][ny] = false;
            }
        }
    }

    // ㅗ, ㅜ, ㅓ, ㅏ
    static void checkException(int x, int y) {
        int[][] exceptions = {
                {0, 1, 2}, // 동, 서, 남 (ㅜ)
                {0, 1, 3}, // 동, 서, 북 (ㅗ)
                {0, 2, 3}, // 동, 남, 북 (ㅏ)
                {1, 2, 3} // 서, 남, 북 (ㅓ)
        };

        for (int[] ex : exceptions) {
            int sum = nums[x][y];
            boolean isValid = true;

            for (int i = 0; i < 3; i++) {
                int nx = x + dx[ex[i]];
                int ny = y + dy[ex[i]];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                    isValid = false;
                    break;
                }
                sum += nums[nx][ny];
            }

            if (isValid) {
                maxSum = Math.max(maxSum, sum);
            }
        }
    }
}
