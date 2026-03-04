
class Solution {

    boolean flag;

    int[][] d2 = {{0,2},{2,0},{0,-2},{-2,0}};
    int[][] d1 = {{0,1},{1,0},{0,-1},{-1,0}};
    int[][] dk = {{1,1},{1,-1},{-1,-1},{-1,1}};


    public int[] solution(String[][] places) {
        int[] answer = new int [5];



        for(int i=0;i<5;i++){
            char[][] arr = new char[5][5];
            boolean[][] visited = new boolean[5][5];
            for(int j=0;j<5;j++){
                for(int k=0;k<5;k++){
                    arr[j][k] = places[i][j].charAt(k);
                }
            }
            flag = true;
            for(int j=0;j<5;j++){
                for(int k=0;k<5;k++){
                    if (!check(j, k, arr)) { // 위반 발견 시
                        flag = false;
                        break;
                    }

                }
                if(!flag) break;
            }
            if(flag){
                answer[i] = 1;
            }else{
                answer[i] = 0;
            }



        }




        return answer;
    }

    boolean check(int x, int y, char[][] arr) {

        //안되는거
        if(arr[x][y]=='P'){

            // 바로 옆에 앉는 경우
            for(int i=0;i<4;i++){
                int dx = x + d1[i][0];
                int dy = y + d1[i][1];

                if (dx >= 0 && dx < 5 && dy >= 0 && dy < 5) {
                    if (arr[dx][dy] == 'P') return false; // 즉시 위반
                }
            }
            //파티션x 직선거리 ==2
            for(int i=0;i<4;i++){

                int dx = x + d2[i][0];
                int dy = y + d2[i][1];

                int xp = x + d1[i][0];
                int yp = y + d1[i][1];

                if (dx >= 0 && dx < 5 && dy >= 0 && dy < 5) {
                    if (arr[dx][dy] == 'P') {
                        // 사이에 있는 칸 확인
                        int mx = x + d1[i][0];
                        int my = y + d1[i][1];
                        if (arr[mx][my] != 'X') return false; // 파티션이 없으면 위반
                    }
                }
            }
            //파티션x 대각선 ==2
            for(int i=0;i<4;i++){

                int dx = x + dk[i][0];
                int dy = y + dk[i][1];

                int xp1 = x + dk[i][0];
                int yp1 = y;

                int xp2 = x;
                int yp2 = y + dk[i][1];



                if (dx >= 0 && dx < 5 && dy >= 0 && dy < 5) {
                    if (arr[dx][dy] == 'P') {
                        // 인접한 두 칸이 모두 파티션이어야 함
                        if (arr[x][dy] != 'X' || arr[dx][y] != 'X') return false;
                    }
                }




            }



        }






        return true;
    }
}