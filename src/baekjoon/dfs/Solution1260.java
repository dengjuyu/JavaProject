package baekjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution1260 {
    static boolean[] visited;
    static List<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer spot = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(spot.nextToken());
            int e = Integer.parseInt(spot.nextToken());

            graph[s].add(e);
            graph[e].add(s);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(graph[i]);
        }

        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        dfs(v, sb);
        System.out.println(sb.toString().trim());

        Arrays.fill(visited, false);

        bfs(v, sb2);
        System.out.println(sb2.toString().trim());
    }

    static void dfs(int node, StringBuilder sb) {
        if (visited[node]) return;

        visited[node] = true;
        sb.append(node).append(" ");

        for (int next : graph[node]) {
            dfs(next, sb);
        }
    }

    static void bfs(int start, StringBuilder sb) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            sb.append(node).append(" ");

            for (int next : graph[node]) {
                if (!visited[next]) {
                    queue.add(next);
                    visited[next] = true;
                }
            }
        }
    }
}
