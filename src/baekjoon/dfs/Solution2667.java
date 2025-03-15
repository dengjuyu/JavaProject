package baekjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution2667 {
    static int N;
    static int[][] graph;
    static boolean[][] visited;
    static List<Integer> houseCounts = new ArrayList<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                graph[i][j] = line.charAt(j) - '0';
            }
        }

        int totalComplexes = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (graph[i][j] == 1 && !visited[i][j]) {
                    count = 0;
                    dfs(i, j);
                    houseCounts.add(count);
                    totalComplexes++;
                }
            }
        }

        Collections.sort(houseCounts);
        System.out.println(totalComplexes);
        for (int houses : houseCounts) {
            System.out.println(houses);
        }
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;
        count++;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                if (graph[nx][ny] == 1 && !visited[nx][ny]) {
                    dfs(nx, ny);
                }
            }
        }
    }
}
