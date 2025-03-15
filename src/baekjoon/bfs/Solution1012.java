package baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution1012 {
    static int[][] graph;
    static boolean[][] visited;
    static int M, N;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken()); // 가로 길이 (열)
            N = Integer.parseInt(st.nextToken()); // 세로 길이 (행)
            int K = Integer.parseInt(st.nextToken()); // 배추 개수

            graph = new int[M][N]; // 배추 위치 저장
            visited = new boolean[M][N]; // 방문 여부

            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                graph[x][y] = 1; // 배추 위치 저장
            }

            int count = 0;
            for (int m = 0; m < M; m++) {
                for (int n = 0; n < N; n++) {
                    if (graph[m][n] == 1 && !visited[m][n]) {
                        bfs(m, n);
                        count++;
                    }
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }

    static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int cx = node[0], cy = node[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && ny >= 0 && nx < M && ny < N) {
                    if (graph[nx][ny] == 1 && !visited[nx][ny]) {
                        queue.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }
}
