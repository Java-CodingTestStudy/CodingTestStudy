package 트리;

import java.io.*;
import java.util.*;

public class Main1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        int[] parent = new int[n + 1];
        boolean[] visited = new boolean[n + 1];

        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        visited[1] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int next : graph[cur]) {
                if (!visited[next]) {
                    visited[next] = true;
                    parent[next] = cur;
                    q.add(next);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= n; i++) {
            sb.append(parent[i]).append('\n');
        }
        System.out.print(sb);
    }
}
