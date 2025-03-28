package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution14502 {
    static int n, m, result = 0;
    static int[][] lab;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        lab = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                lab[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 벽을 0개 세운 상태에서 시작
        dfs(0);
        System.out.println(result);
    }

    static void dfs(int count) {
        // 벽 3개 세우면 정지
        if (count == 3) {
            simulate();
            return;
        }

        // 빈칸(0) 찾아 벽(1) 세우기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (lab[i][j] == 0) {
                    lab[i][j] = 1; // 벽 설치
                    dfs(count + 1); // 다음 벽 설치를 위해 재귀 호출
                    lab[i][j] = 0; // 설치한 벽 다시 제거(다른 경우의 수 탐색)
                }
            }
        }
    }

    static void simulate() {
        // 원본 배열 복사 (원본 유지 목적)
        int[][] temp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                temp[i][j] = lab[i][j];
            }
        }

        // 바이러스(2)가 있는 위치를 모두 큐에 넣기
        Queue<Point> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (temp[i][j] == 2) {
                    queue.add(new Point(i, j));
                }
            }
        }

        // 바이러스 확산 시뮬레이션
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nx = p.x + dx[d];
                int ny = p.y + dy[d];
                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (temp[nx][ny] == 0) { // 빈칸인 경우 바이러스 확산
                        temp[nx][ny] = 2;
                        queue.add(new Point(nx, ny));
                    }
                }
            }
        }

        // 바이러스 확산 후 남은 안전 영역(0) 계산
        int safe = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (temp[i][j] == 0) {
                    safe++;
                }
            }
        }

        // 최대 안전 영역 크기 갱신
        result = Math.max(result, safe);
    }

    // 좌표 정보 저장
    static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
