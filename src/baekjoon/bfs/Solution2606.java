package baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution2606 {
    static boolean[] visited;
    static List<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int totalComputers = Integer.parseInt(br.readLine());
        int connectedComputers = Integer.parseInt(br.readLine());

        visited = new boolean[totalComputers + 1];
        graph = new ArrayList[totalComputers + 1];

        for (int i = 1; i <= totalComputers; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < connectedComputers; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            graph[s].add(e);
            graph[e].add(s);
        }

        int count = bfs(1);
        System.out.println(count);

    }

    static int bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        int count = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int next : graph[node]) {
                if (!visited[next]) {
                    queue.add(next);
                    visited[next] = true;
                    count++;
                }
            }
        }

        return count;
    }
}
