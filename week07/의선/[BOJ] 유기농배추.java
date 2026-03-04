import java.util.Scanner;

public class Main {

    static int[][] arr;
    static int m, n;
    static int[][] d = {{0,1}, {1,0}, {0,-1}, {-1,0}};

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();

        for (int t = 0; t < testcase; t++) {

            m = sc.nextInt();
            n = sc.nextInt();
            arr = new int[m][n];

            int k = sc.nextInt();
            for (int i = 0; i < k; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                arr[x][y] = 1;
            }

            int cnt = 0;

            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    if(arr[i][j] == 1) {
                        dfs(i, j);
                        cnt++;
                    }
                }
            }

            System.out.println(cnt);
        }
    }

    static void dfs(int x, int y) {
        arr[x][y] = 0;  // 방문 처리

        for(int i = 0; i < 4; i++) {
            int nx = x + d[i][0];
            int ny = y + d[i][1];

            if(nx >= 0 && ny >= 0 && nx < m && ny < n) {
                if(arr[nx][ny] == 1) {
                    dfs(nx, ny);
                }
            }
        }
    }
}
