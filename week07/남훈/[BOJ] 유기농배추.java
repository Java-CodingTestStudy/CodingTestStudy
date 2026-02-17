import java.util.Scanner;
public class Solution {

    static int[][] map;          // 배추밭
    static boolean[][] visited;  // 방문 체크
    static int N, M;             // 배추밭 크기 (행, 열)
    static int[] dx = {1, -1, 0, 0}; // 상하좌우 이동
    static int[] dy = {0, 0, 1, -1};

    // DFS 함수
    static void dfs(int x, int y) {
        visited[x][y] = true;  // 현재 위치 방문 처리

        for (int i = 0; i < 4; i++) { // 상하좌우 확인
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 범위 체크
            if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                // 배추가 있고 아직 방문하지 않았다면
                if (map[nx][ny] == 1 && !visited[nx][ny]) {
                    dfs(nx, ny); // 재귀 호출
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt(); // 테스트 케이스 개수

        for (int t = 0; t < T; t++) {
            M = sc.nextInt(); // 가로
            N = sc.nextInt(); // 세로
            int K = sc.nextInt(); // 배추 개수

            map = new int[N][M];
            visited = new boolean[N][M];

            // 배추 심기
            for (int i = 0; i < K; i++) {
                int x = sc.nextInt(); // 가로 좌표
                int y = sc.nextInt(); // 세로 좌표
                map[y][x] = 1;       // 배추 심기
            }

            int count = 0; // 배추 그룹 개수

            // 전체 배추밭 순회
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 1 && !visited[i][j]) {
                        dfs(i, j); // 연결된 배추 전부 방문
                        count++;   // 그룹 1개 추가
                    }
                }
            }
            System.out.println(count);
        }
        sc.close();
    }
}