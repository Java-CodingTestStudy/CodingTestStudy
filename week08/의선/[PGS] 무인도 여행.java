import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    int n,m;
    List<Integer> list = new ArrayList<>();
    int[] dx = {1,-1,0,0};
    int[] dy = {0,0,1,-1};

    public int[] solution(String[] maps) {
        int[] answer = {};

        n = maps.length;
        m = maps[0].length();

        char[][] arr = new char[n][m];

        for(int i=0;i<n;i++){
            for(int j = 0;j<m;j++){
                arr[i][j] = maps[i].charAt(j);
            }
        }


        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int temp = dfs(i,j,arr);
                if(temp!=0) {
                    list.add(temp);
                }

            }
        }
        if(list.isEmpty()){
            return new int[]{-1};
        }
        Collections.sort(list);



        return list.stream().mapToInt(i -> i).toArray();
    }
    public int dfs(int i, int j, char[][] arr) {
        if (i < 0 || j < 0 || i >= n || j >= m || arr[i][j] == 'X') {
            return 0;
        }

        int sum = arr[i][j] - '0';
        arr[i][j] = 'X';


        for (int d = 0; d < 4; d++) {
            int nx = i + dx[d];
            int ny = j + dy[d];
            sum += dfs(nx, ny, arr);
        }

        return sum;
    }
}