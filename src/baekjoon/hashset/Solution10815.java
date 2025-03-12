package baekjoon.hashset;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringJoiner;
import java.util.StringTokenizer;

public class Solution10815 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashSet<Integer> set = new HashSet<>();

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        int m = Integer.parseInt(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        StringJoiner sj = new StringJoiner(" ");

        for (int j = 0; j < m; j++) {
            sj.add(set.contains(Integer.parseInt(st2.nextToken())) ? "1" : "0");
        }

        System.out.println(sj);
    }
}
