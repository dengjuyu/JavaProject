package baekjoon.implementation;

import java.io.*;
import java.util.*;

public class Solution16236 {
    static int N;
    static int[][] space;
    static Shark shark;
    static int[] dx = {-1, 1, 0, 0}; // 상, 하, 좌, 우
    static int[] dy = {0, 0, -1, 1};
    static int totalTime = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        space = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                space[i][j] = Integer.parseInt(st.nextToken());
                if (space[i][j] == 9) {
                    shark = new Shark(i, j, 2);  // 초기 크기 2
                    space[i][j] = 0;
                }
            }
        }
        bfs();
        System.out.println(totalTime);
    }

    // 먹이 찾기
    public static void bfs() {
        while (true) {
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
                if (a[2] == b[2]) {
                    if (a[0] == b[0]) return a[1] - b[1];
                    return a[0] - b[0];
                }
                return a[2] - b[2];
            });

            Queue<int[]> queue = new LinkedList<>();
            boolean[][] visited = new boolean[N][N];
            queue.add(new int[]{shark.x, shark.y, 0});
            visited[shark.x][shark.y] = true;
            boolean found = false;

            while (!queue.isEmpty()) {
                int[] current = queue.poll();
                int x = current[0];
                int y = current[1];
                int dist = current[2];

                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]) {
                        if (space[nx][ny] <= shark.size) { // 이동 가능
                            visited[nx][ny] = true;
                            queue.add(new int[]{nx, ny, dist + 1});
                            if (space[nx][ny] > 0 && space[nx][ny] < shark.size) {
                                pq.add(new int[]{nx, ny, dist + 1});
                                found = true;
                            }
                        }
                    }
                }
            }

            if (pq.isEmpty()) break;  // 먹을 수 있는 물고기가 없는 경우 종료

            int[] target = pq.poll();
            int targetX = target[0];
            int targetY = target[1];
            int distance = target[2];

            // 아기 상어 위치 업데이트
            shark.updatePosition(targetX, targetY);
            totalTime += distance;
            shark.eat();
            space[targetX][targetY] = 0;
        }
    }

    static class Shark {
        int x, y; // 현재 위치
        int size; // 사이즈
        int eatCount; // 먹은 횟수

        public Shark(int x, int y, int size) {
            this.x = x;
            this.y = y;
            this.size = size;
            this.eatCount = 0;
        }

        public void eat() {
            eatCount++;
            if (eatCount == size) {
                size++; // 크기 증가
                eatCount = 0; // 먹은 횟수 초기화
            }
        }

        public void updatePosition(int newX, int newY) {
            this.x = newX;
            this.y = newY;
        }
    }
}
