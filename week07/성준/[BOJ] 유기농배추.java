import java.util.*;
import java.io.*;

public class Main{
    static int M, N;
    static int[][] field;
    static boolean[][] visited;
    
    // 방향이요
    static int dx[] = {0,0,-1,1};
    static int dy[] = {-1,1,0,0};
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); //테스트 케이스 개수
        
        while(T>0){
            T--;
            M = sc.nextInt(); // 가
            N = sc.nextInt(); // 세
            int K = sc.nextInt(); // 배추 개수
            
            field = new int[N][M];
            visited = new boolean[N][M];
            
            for(int i = 0; i<K; i++){
                int x = sc.nextInt();
                int y = sc.nextInt();
                field[y][x] = 1; // 배추 심어!
            }
            
            int giantWorm = 0; // 왕꿈틀이
            
            for(int y = 0; y < N; y++){
                for(int x = 0; x < M; x++){
                    // 배추가 있는데 방문 안했으
                    if (field[y][x] == 1 && !visited[y][x]){
                        bfs(x,y);
                        // dfs(x,y);
                        giantWorm++; // 그룹 발견하면 꿈틀스 추가
                    }
                }
            }
            System.out.println(giantWorm);
        }
    }
    
    static void bfs(int startX, int startY){
        Queue<int[]> queue = new LinkedList<>();
        //.add 썼었는데 add 는 꽉 차면 Exception 발생해서 offer 써봄 offer 는 꽉차면 false 발생
        queue.offer(new int[]{startX, startY});
        visited[startY][startX] = true;
        
        // .isequals() 값비교 isEmpty 비어있는거 체크 .isequals()로 되는지 이것저것 시도해봤는데 걍 암기하라고 함
        while (!queue.isEmpty()){
            int[] cur = queue.poll();
            int cx = cur[0], cy = cur[1];
            
            // 4방향
            for(int d = 0; d < 4; d++){
                int nx = cx + dx[d];
                int ny = cy + dy[d];
                
                // 범위, 배추, 미방문 체크
                if (nx >= 0 && nx < M && ny >= 0 && ny < N && field[ny][nx] == 1 && !visited[ny][nx]){
                    visited[ny][nx] = true;
                    queue.offer(new int[]{nx,ny});
                }
            }
        }
    }
    /*
        static void dfs(int x, int y) {
            visited[y][x] = true;

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx >= 0 && nx < M && ny >= 0 && ny < N && field[ny][nx] == 1 && !visited[ny][nx]) {
                    dfs(nx, ny); // 재귀 호출
            }
        }
    }
    */
}