package programmers.second;

public class Server {
    public int solution(int[] players, int m, int k) {
        int n = players.length; // 24시간
        int[] serversNeeded = new int[n]; // 각 시간대별 필요한 서버 수

        // 각 시간대별 필요한 서버 수 계산
        // m명 미만: 0대
        // m명 이상 2m명 미만: 1대
        // 2m명 이상 3m명 미만: 2대...
        for (int i = 0; i < n; i++) {
            if (players[i] < m) {
                serversNeeded[i] = 0;
            } else {
                serversNeeded[i] = (players[i] / m);
            }
        }

        int totalExpansions = 0;
        int[] activeServers = new int[n]; // 각 시간대별 증설한 서버 수

        // 각 시간대별로 처리
        for (int time = 0; time < n; time++) {
            // 필요한 서버 수
            int need = serversNeeded[time];

            // 이미 운영 중인 서버 수 (time-k+1부터 time-1까지 증설한 서버들)
            int running = 0;
            for (int t = Math.max(0, time - k + 1); t < time; t++) {
                running += activeServers[t];
            }

            // 추가로 필요한 서버 수
            int additional = Math.max(0, need - running);

            // 추가 서버 증설
            if (additional > 0) {
                activeServers[time] = additional;
                totalExpansions += additional;
            } else {
                activeServers[time] = 0;
            }
        }

        return totalExpansions;
    }
}
