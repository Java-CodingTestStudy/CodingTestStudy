import java.util.ArrayList;
import java.util.List;

class Solution {
    static List<int[]> list = new ArrayList<int[]>();
    public int[][] solution(int n) {
        int[][] answer = {};

        hanoi(n,1,2,3);
        answer = list.toArray(answer);

        return answer;
    }
    public static void hanoi(int n, int start, int mid, int end){

        if(n == 0){
            return;
        }
        
        
        hanoi(n-1, start, end, mid);   
        list.add(new int[]{start,end});  
        hanoi(n-1, mid,start , end);   

    }
}