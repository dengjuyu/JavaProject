package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution14503 {
    // 로봇 청소기 방 nxm
    static int n, m;
    static int[][] rooms;
    static boolean[][] cleaned;

    // 로봇 청소기 최초 위치, 방향
    static int fn, fm, direction;
    static int count = 0;

    // 방향: 0:북 1:동 2:남 3:서
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        // 1. 청소 안됨
            // 청소
        // 2-1. 동서남북 청소 완료
            // 바라보는 방향 유지 - 후진 - 1단계로
            // 후진 불가 - 멈춤
        // 2-2. 동서남북 청소 미완
            // 반시계방향 90도 회전
            // 바라보는 방향 기준 앞칸이 청소 필요 - 전진 - 1단계로

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        rooms = new int[n][m];
        cleaned = new boolean[n][m];

        st = new StringTokenizer(br.readLine());
        fn = Integer.parseInt(st.nextToken());
        fm = Integer.parseInt(st.nextToken());
        direction = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                rooms[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        clean(fn, fm);
        System.out.println(count);
    }

    static boolean validate(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < m && rooms[x][y] == 0;
    }

    static void clean(int x, int y) {
        while (true) {
            if (!cleaned[x][y]) {
                cleaned[x][y] = true;
                count++;
            }

            boolean moved = false;
            for (int i = 0; i < 4; i++) {
                // 반시계 90도 회전
                direction = (direction + 3) % 4;
                int nx = x + dx[direction];
                int ny = y + dy[direction];

                if (validate(nx, ny) && !cleaned[nx][ny]) {
                    x = nx;
                    y = ny;
                    moved = true;
                    break;
                }
            }

            if (!moved) {
                int backDir = (direction + 2) % 4;
                int bx = x + dx[backDir];
                int by = y + dy[backDir];
                if (validate(bx, by)) {
                    x = bx;
                    y = by;
                } else {
                    break;
                }

            }

        }
    }

}
