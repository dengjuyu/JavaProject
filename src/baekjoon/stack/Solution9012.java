package baekjoon.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution9012 {

    private static String checkVps(String str) {
        Stack<Character> stack = new Stack<>();
        for(char s : str.toCharArray()) {
            if (s == '(') {
                stack.push(s);
            } else if (s == ')') {
                if (stack.isEmpty()) {
                    return "NO";
                }
                stack.pop();
            }
        }
        return stack.isEmpty() ? "YES" : "NO";
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++) {
            sb.append(checkVps(br.readLine())).append("\n");
        }

        System.out.print(sb);

    }
}
