import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int m=0;
    static int n=0;
    static int k=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader( new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T= Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            StringTokenizer st= new StringTokenizer(br.readLine());
             m= Integer.parseInt(st.nextToken());
             n= Integer.parseInt(st.nextToken());
             k= Integer.parseInt(st.nextToken());
            int[][] place= new int[m][n];
            for(int p=0; p<k; p++){

                    StringTokenizer st2 = new StringTokenizer(br.readLine());
                   int x=Integer.parseInt(st2.nextToken());
                    int y= Integer.parseInt(st2.nextToken());
                    place[x][y]=1;

            }
            int result=0;

            int answer=searching(m,n,k,place,new int[m][n],result);
            System.out.println(answer);
        }
    }

    private static int searching(int m, int n, int k, int[][] place, int[][] visited, int result) {

        //전체 탐색 메서드
        for(int i=0; i<m; i++){
            for(int i2=0; i2<n; i2++){
                if(visited[i][i2]==0 && place[i][i2]==1){
                    result+=1;
                    dfs(i,i2,place,visited);
                }
            }
        }

        return result;
    }

    private static void dfs(int x, int y, int[][] place, int[][] visited ) {
        //범위 확인(그래프는 꼭 범위를 확인해야한다)
        if(x<0||y<0||x>=m||y>=n ) return ;

        //배추가 아니면 return
        if(place[x][y]==0) return;

        //재귀 돌리기

        if(visited[x][y]==0 && place[x][y]==1) {
            visited[x][y]=1;
            dfs(x + 1, y,  place, visited);
            dfs(x, y + 1,  place, visited );
            dfs(x - 1, y,  place, visited);
            dfs(x, y - 1, place, visited);
        }
    }


}
