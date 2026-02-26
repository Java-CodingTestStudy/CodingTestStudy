import java.util.*;

class Solution {
    
    private static final int N = 5;
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};
    
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];  

        for (int i = 0; i < places.length; i++) { 
            if (isValid(places[i])) answer[i] = 1;
            else answer[i] = 0;
        }

        return answer;
    }

    private boolean isValid(String[] map) { 
        
        // map 순회
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) { 
                
                // 사람이면 상하좌우 탐색
                if (map[i].charAt(j) == 'P') {
                    if (!bfs(map, i, j)) return false;
                }
            }
        }

        return true;
    }
    
    // (x, y)에서 시작하는 BFS: 거리 2 이내에서 다른 P 발견하면 위반
    private boolean bfs(String[] map, int x, int y) {
        boolean[][] visited = new boolean[N][N];
        Queue<int[]> queue = new LinkedList<>();        // x, y, dist
        
        // 맨 처음 위치 삽입
        queue.offer(new int[]{x, y, 0});
        visited[x][y] = true;
        
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curx = cur[0];
            int cury = cur[1];
            int dist = cur[2];
            
            // 거리가 2이상이면 skip
            if(dist >= 2) continue;
            
            // 상하좌우 탐색
            for(int i = 0; i < 4; i++) {
                int nx = curx + dx[i];
                int ny = cury + dy[i];
                int nd = dist + 1;
                
                // 범위를 벗어나거나, 이미 방문한 곳이라면 skip
                if(nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny]) continue;
                
                // 파티션으로 막힌 경우 skip
                if(map[nx].charAt(ny) == 'X') continue;
                
                // 사람이 있는 경우 실패
                if(map[nx].charAt(ny) == 'P') return false;
                
                // 빈 자리인 경우 탐색 계속
                if(map[nx].charAt(ny) == 'O') {
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny, nd});
                }
            }
        }
        
        return true;
        
    }

    
}