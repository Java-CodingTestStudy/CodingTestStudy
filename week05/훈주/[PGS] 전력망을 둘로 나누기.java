import java.util.ArrayList;
import java.util.List;

class Solution {

    private List<Integer>[] graph;
    private boolean[] visited;

    public int solution(int n, int[][] wires) {

        int minDiff = Integer.MAX_VALUE;

        // 간선 하나씩 제거
        for (int i = 0; i < wires.length; i++) {

            // 그래프 초기화
            graph = new ArrayList[n + 1];
            for (int j = 1; j <= n; j++) {
                graph[j] = new ArrayList<>();
            }

            // i번째 간선 제외하고 연결
            for (int j = 0; j < wires.length; j++) {
                if (i == j) continue;

                int v1 = wires[j][0];
                int v2 = wires[j][1];

                graph[v1].add(v2);
                graph[v2].add(v1);
            }

            visited = new boolean[n + 1];

            // 한쪽 네트워크 크기 계산
            int count = dfs(1);

            int diff = Math.abs(n - 2 * count);
            minDiff = Math.min(minDiff, diff);
        }

        return minDiff;
    }

    // DFS로 연결된 노드 개수 계산
    private int dfs(int node) {

        visited[node] = true;
        int count = 1;

        for (int next : graph[node]) {
            if (!visited[next]) {
                count += dfs(next);
            }
        }

        return count;
    }
}