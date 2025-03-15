package baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution7576 {
    static int M, N;
    static int[][] graph;
    static Queue<int[]> queue = new LinkedList<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        graph = new int[N][M];
        int unripeCount = 0; // 익지 않은 토마토 개수

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if (graph[i][j] == 1) {
                    queue.add(new int[]{i, j}); // 익은 토마토 위치 저장
                } else if (graph[i][j] == 0) {
                    unripeCount++;
                }
            }
        }

        if (unripeCount == 0) {
            System.out.println(0);
            return;
        }

        int days = bfs();
        System.out.println(checkAllRipe() ? days : -1);

    }

    static int bfs() {
        int days = -1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            days++;

            for (int i = 0; i < size; i++) {
                int[] node = queue.poll();
                int cx = node[0], cy = node[1];

                for (int j = 0; j < 4; j++) {
                    int nx = cx + dx[j];
                    int ny = cy + dy[j];

                    if (nx >= 0 && ny >= 0 && nx < N && ny < M && graph[nx][ny] == 0) {
                        queue.add(new int[]{nx, ny});
                        graph[nx][ny] = 1;
                    }
                }
            }
        }

        return days;
    }

    static boolean checkAllRipe() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (graph[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
