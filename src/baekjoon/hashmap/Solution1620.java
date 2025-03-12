package baekjoon.hashmap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<Integer, String> map = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            String name = br.readLine();
            map.put(i, name);
            map2.put(name, i);
        }

        while (m-- > 0) {
            String query = br.readLine();
            if (Character.isDigit(query.charAt(0))) {
                sb.append(map.get(Integer.parseInt(query))).append("\n");
            } else {
                sb.append(map2.get(query)).append("\n");
            }
        }

        System.out.println(sb);
    }
}
