package baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution1697 {
    static int MAX = 100000;  // 최대 범위
    static int[] visited = new int[MAX + 1]; // 방문 여부 및 걸린 시간 저장 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());  // 수빈이 위치
        int K = Integer.parseInt(st.nextToken());  // 동생 위치

        System.out.println(bfs(N, K));
    }

    public static int bfs(int N, int K) {
        Queue<Integer> queue = new LinkedList<>();
        Arrays.fill(visited, -1); // 방문 여부 초기화 (-1: 방문하지 않음)
        queue.offer(N);
        visited[N] = 0; // 시작 위치의 시간은 0초

        while (!queue.isEmpty()) {
            int x = queue.poll();

            // 동생 위치에 도착하면 최소 시간 반환
            if (x == K) return visited[x];

            // 이동할 수 있는 세 가지 경우: x-1, x+1, x*2
            for (int nx : new int[]{x - 1, x + 1, x * 2}) {
                if (nx >= 0 && nx <= MAX && visited[nx] == -1) { // 범위 내 & 미방문
                    visited[nx] = visited[x] + 1; // 걸린 시간 +1
                    queue.offer(nx);
                }
            }
        }
        return -1; // 도달 불가능한 경우는 없음 (문제 조건상)
    }
}
