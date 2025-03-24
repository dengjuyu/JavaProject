package programmers.second;

import java.util.LinkedList;
import java.util.Queue;

public class Server {
    public int solution(int[] players, int m, int k) {
        int serverCount = 0; // 현재 사용 중인 서버 수
        int answer = 0; // 총 증설 횟수
        Queue<Integer> serverEndTime = new LinkedList<>(); // 서버 만료 시각 저장

        for (int i = 0; i < 24; i++) {
            // 1. 만료된 서버 제거
            while (!serverEndTime.isEmpty() && serverEndTime.peek() <= i) {
                serverEndTime.poll();
                serverCount--;
            }

            // 2. 현재 서버로 감당 가능한 유저 수
            int capacity = serverCount * m;

            // 3. 감당 못하는 유저 수 계산
            int excess = players[i] - capacity;

            if (excess > 0) {
                // 4. 부족한 유저 수를 커버하기 위한 서버 수 계산
                int additionalServers = (int) Math.ceil((double) excess / m);

                // 5. 서버 증설 및 만료 시각 등록
                for (int j = 0; j < additionalServers; j++) {
                    serverEndTime.offer(i + k); // k시간 뒤 만료
                }
                serverCount += additionalServers;
                answer += additionalServers;
            }

            // 테스트 출력
            System.out.println("시각 " + i + ": players = " + players[i] + ", 증설된 서버 수 = " +
                    Math.max(0, (int) Math.ceil((double) (players[i] - capacity) / m)) +
                    ", 사용 중인 서버 수 = " + serverCount);
        }

        return answer;
    }
}
