package java11725;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 각 노드의 부모노드를 탐색 -> 완전 탐색 -> DFS
 * 각 노드와 간선을 한 번씩만 방문하므로 O(N)
 * 
 * Tree란?
 * - 모든 노드가 하나로 연결됨
 * - 노드 개수 N이면 간선 개수는 항상 N-1개
 * 
 * 그래프와 차이
 * - 두 노드 사이의 경로가 항상 하나뿐이다 = 어떤 노드로 가는 유일한 경로
 * - 이 특성으로 인해 입력이 부모->자식 순서를 보장하지 않아도 부모->자식 순으로 탐색이 가능
 * - 그래프에서는 사이클이 있을 수도 있고, 여러 경로로 도달 가능하며 부모가 유일하지 않다
 * - 그래프에서의 visited 는 무한 루프 방지, 트리에서의 visited 는 부모로 되돌아가지 않기 위한 장치
 * 
 * 코테에서 Tree
 * - 간선 N-1개, 사이클 없음, 부모/자식/계층 -> 트리
 * - 깊이/부모 -> DP + DFS
 * - 거리/레벨 -> BFS
 */
public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 노드 개수
        int N = Integer.parseInt(st.nextToken());

        // 그래프 - 1번 노드부터 사용하므로 N+1 크기로 생성
        List<Integer>[] tree = new ArrayList[N + 1];
        // 그래프 초기화
        for (int i = 0; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        // 노드 입력받기 - 트리는 간선 N-1개
        // 부모 자식 관계가 있지만, 무방향으로 저장
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());

            tree[parent].add(child);
            tree[child].add(parent);
        }

        // 각 노드의 부모 노드 저장 배열
        // answer[i] = i번 노드의 부모
        int[] answer = new int[N + 1];

        // 각 노드의 부모 노드 저장, 루트 노드는 1
        dfs(tree, new boolean[N + 1], 1, answer);

        // 배열 순회하면서 부모 출력 (1번은 루트노드)
        for (int i = 2; i <= N; i++) {
            System.out.println(answer[i]);
        }

    }

    /**
     * DFS를 이용해 부모 노드를 찾는 함수
     *
     * @param graph   인접 리스트로 표현된 트리
     * @param visited 방문 여부 체크 배열
     * @param node    현재 방문 중인 노드
     * @param answer  각 노드의 부모를 저장할 배열
     */
    private static void dfs(List<Integer>[] graph, boolean[] visited, int node, int[] answer) {
        // 이미 방문한 노드인 경우 종료
        if (visited[node])
            return;

        // 노드 방문 처리
        visited[node] = true;

        // 연결된 노드 방문
        for (int next : graph[node]) {
            // 아직 방문하지 않은 노드인 경우
            if (!visited[next]) {
                // 현재 노드를 next의 부모로 저장
                answer[next] = node;

                // 다음 노드 탐색
                dfs(graph, visited, next, answer);
            }
        }

    }

    // visited 안쓰는 DFS 방법
    private static void dfsWithoutVisited(List<Integer>[] graph, int node, int parent, int[] answer) {

        for (int next : graph[node]) {
            if (next == parent)
                continue;
        
            graph[next] = node;
        
            dfs(graph, next, node, answer);
        }
    }
}
