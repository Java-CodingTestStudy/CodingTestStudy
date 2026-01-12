package studycodingtest.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.ArrayList;

import java.util.StringTokenizer;

/*
    N : 노드의 개수
    graph : 트리를 인접리스트로 저장
    parent : 부모
    인접 리스트
    dfs

 */
public class BOJ_FindTreeParents {
    static ArrayList<Integer>[] graph; // 인접리스트 저장
    static int[] parent; // parent[i] 는 i번 노드의 부모 노드 번호

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        graph = new ArrayList[N+1];
        parent = new int[N+1];

        // 인접리스트 초기화
        for(int i = 1; i <= N; i++){
            graph[i] = new ArrayList<>();
        }

        // 간선 입력 처리
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        //
        parent[1] = -1;
        dfs(1);

        StringBuilder sb = new StringBuilder();
        // 노드 2부터 ~ N까지
        for (int i = 2; i <= N; i++) {
            sb.append(parent[i]).append('\n');
        }
        System.out.println(sb);
    }

    // 현재 노드cur 을 기준으로 체크
    static void dfs(int cur){
        for(int next: graph[cur]){
            if(parent[next] == 0){ // 아직 방문하지 않은 노드
                parent[next] = cur; // 부모 노드 기록
                dfs(next); // 자식 노드로 DFS 진행
            }
        }
    }
}
