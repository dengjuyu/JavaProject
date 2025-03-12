package baekjoon.hashset;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution7785 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        // 사전 역순(내림차순) 정렬을 위해 TreeSet 사용
        Set<String> set = new TreeSet<>(Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String records = st.nextToken();
            if ("enter".equals(records)) {
                set.add(name);
            } else {
                set.remove(name);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String s : set) {
            sb.append(s).append("\n");
        }

        System.out.println(sb);
    }
}
