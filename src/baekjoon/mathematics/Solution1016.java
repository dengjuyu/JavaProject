package baekjoon.mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1016 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());

        int range = (int)(max - min + 1);
        boolean[] isNotSquareFree = new boolean[range];

        for (long i = 2; i * i <= max; i++) {
            long pow = i * i;
            long start = ((min + pow - 1) / pow) * pow;

            for (long j = start; j <= max; j += pow) {
                isNotSquareFree[(int)(j - min)] = true;
            }
        }

        int count = 0;
        for (int i = 0; i < range; i++) {
            if (!isNotSquareFree[i]) count++;
        }
        System.out.println(count);

    }
}
