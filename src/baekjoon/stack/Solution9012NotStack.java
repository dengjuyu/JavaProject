package baekjoon.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution9012NotStack {
    private static String checkVps(String str) {
        int count = 0;

        for (char s : str.toCharArray()) {
            if (s == '(') {
                count++;
            } else {
                count--;
                if (count < 0) {
                    return "NO";
                }
            }
        }
        return count == 0 ? "YES" : "NO";

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            sb.append(checkVps(br.readLine())).append("\n");
        }

        System.out.println(sb);
    }
}
