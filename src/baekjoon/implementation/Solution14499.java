package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution14499 {
    static int N, M, x, y, K;
    static int[][] map;
    static int[] dice = new int[6];
    static int[] dx = {0, 0, -1, 1};  // 동, 서, 북, 남
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력 받기
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        // 지도 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 명령어 입력 및 처리
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < K; i++) {
            int command = Integer.parseInt(st.nextToken()) - 1;  // 1,2,3,4 -> 0,1,2,3
            int nx = x + dx[command];
            int ny = y + dy[command];

            // 범위 체크: 범위를 벗어나면 명령 무시
            if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

            // 주사위 굴리기
            rollDice(command);

            // 주사위 바닥과 지도 값 갱신
            if (map[nx][ny] == 0) {
                map[nx][ny] = dice[5];
            } else {
                dice[5] = map[nx][ny];
                map[nx][ny] = 0;
            }

            // 좌표 갱신
            x = nx;
            y = ny;

            // 윗면 값 출력
            sb.append(dice[0]).append("\n");
        }

        System.out.println(sb);
    }

    // 주사위 굴리기
    private static void rollDice(int direction) {
        int[] temp = dice.clone();
        switch (direction) {
            case 0: // 동쪽
                dice[0] = temp[3];
                dice[2] = temp[0];
                dice[5] = temp[2];
                dice[3] = temp[5];
                break;
            case 1: // 서쪽
                dice[0] = temp[2];
                dice[3] = temp[0];
                dice[5] = temp[3];
                dice[2] = temp[5];
                break;
            case 2: // 북쪽
                dice[0] = temp[4];
                dice[1] = temp[0];
                dice[5] = temp[1];
                dice[4] = temp[5];
                break;
            case 3: // 남쪽
                dice[0] = temp[1];
                dice[4] = temp[0];
                dice[5] = temp[4];
                dice[1] = temp[5];
                break;
        }
    }
}
