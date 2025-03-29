package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution15686 {
    // 마을 크기 nxn, 선택할 치킨집의 개수 m
    static int n, m;
    // 2차원 배열, 마을 저장
    static int[][] village;
    // 치킨집 저장 리스트
    static List<Point> chickens = new ArrayList<>();
    // 집 저장 리스트
    static List<Point> houses = new ArrayList<>();
    // 선택된 치킨집 조합 저장 리스트
    static List<Point> selectedChickens = new ArrayList<>();

    // 최소 도시 치킨 거리
    static int minDistance = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        village = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j< n; j++) {
                int spot = Integer.parseInt(st.nextToken());
                village[i][j] = spot;
                if (spot == 1) {
                    houses.add(new Point(i, j));
                } else if (spot == 2) {
                    chickens.add(new Point(i, j));
                }
            }
        }
        // 치킨집 조합 생성
        combination(0, 0);
        System.out.println(minDistance);
    }

    // dfs
    static void combination(int idx, int count) {
        // idx: 치킨집 리스트에서 현재 탐색할 인덱스
        // count: 현재까지 선택한 치킨집의 개수
        if (count == m) {
            // 현재 선택된 조합으로 도시 치킨 거리 계산
            int total = calculate();
            minDistance = Math.min(minDistance, total);
            return;
        }
        // 목록 끝 -> 종료
        if (idx >= chickens.size()) {
            return;
        }

        // 현재 치킨집 선택하는 경우
        selectedChickens.add(chickens.get(idx));
        combination(idx + 1, count + 1);

        // 현재 치킨집 선택하지 않는 경우
        selectedChickens.remove(selectedChickens.size() - 1);
        combination(idx + 1, count);
    }

    // 도시 치킨 거리 계산 메서드
    static int calculate() {
        // 모든 집의 최소 치킨 거리 누적
        int sum = 0;
        // 모든 집에 대해 선택한 치킨집과의 거리 계산
        for (Point house : houses) {
            // 각 집의 최소 거리를 구하기 위해
            int min = Integer.MAX_VALUE;
            for (Point chicken : selectedChickens) {
                // 거리 계산
                int d = Math.abs(house.x - chicken.x) + Math.abs(house.y - chicken.y);
                // 둘 중 작은 값
                min = Math.min(min, d);
            }
            // 누적
            sum += min;
        }
        return sum;
    }

    // 집, 치킨집 좌표 저장 목적
    static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
