package programmers.second;

public class SecretCode {
    static int globalN;
    static int[][] globalQ;
    static int[] globalAns;
    static int count;

    public int solution(int n, int[][] q, int[] ans) {
        globalN = n;
        globalQ = q;
        globalAns = ans;
        count = 0;

        int[] combi = new int[5];
        // start = 1; 후보 조합의 숫자를 1부터 선택
        // idx = 0; 아직 아무 숫자도 선택하지 않음
        generate(1, 0, combi);
        return count;
    }

    private void generate(int start, int idx, int[] combi) {
        // combi 배열 완성
        if (idx == 5) {
            // 플래그 초기화
            boolean valid = true;
            // 각 시도마다 공통 요수 개수 계산
            for (int i = 0; i < globalQ.length; i++) {
                int common = 0;
                int p1 = 0; // combi 배열 인덱스
                int p2 = 0; // globalQ 배열 인덱스

                while (p1 < combi.length && p2 < globalQ[i].length) {
                    // 두 배열의 현재 숫자가 같은 경우
                    if (combi[p1] == globalQ[i][p2]) {
                        common++;
                        p1++;
                        p2++;
                    } else if (combi[p1] < globalQ[i][p2]) {
                        // 콤비 배열의 현재 숫자가 더 작으면 콤비의 다음 숫자로 이동
                        p1++;
                    } else {
                        // 시도 배열의 현재 숫자가 더 작으면 시도의 다음 숫자로 이동
                        p2++;
                    }
                }
                // 현재 시도에 대해 공통 요소 개수가 일치하는지 확인
                if (common != globalAns[i]) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                count++;
            }
            return;
        }
        // 배열 채워넣기
        // 오름차순 -> 이전 선택값보다 큰값
        // 1 ~ globalN 까지 선택 가능
        // idx : 현재까지 선택한 숫자의 개수 -> 남은 자리수 5 - idx
        for (int num = start; num <= globalN - (5 - idx) + 1; num++) {
            combi[idx] = num;
            generate(num + 1, idx + 1, combi);
        }
    }
}
