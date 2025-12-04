package 배열;

class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        
        
        int n = board.length;
        
        //위
        if(h>0){
            if(board[h][w].equals(board[h-1][w])){
                answer++;
            }
        }
        //왼
        if(w>0){
            if(board[h][w].equals(board[h][w-1])){
                answer++;
            }
        }
        //아래
        if(h<n-1){
           if(board[h][w].equals(board[h+1][w])){
                answer++;
            } 
        }
        //오
        if(w<n-1){
            if(board[h][w].equals(board[h][w+1])){
                answer++;
            }
        }
        
        
        
        
        return answer;
    }
}
