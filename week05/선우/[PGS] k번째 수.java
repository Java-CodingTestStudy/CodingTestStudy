import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        
        int[] answer = new int[commands.length];
        
        for(int i = 0; i < commands.length; i++){
            
            int start = commands[i][0] - 1;
            int end = commands[i][1] - 1;
            int k = commands[i][2] - 1;
            
            int[] arr2 = new int[end - start + 1];
            
            int cnt = 0;
            for(int j = start; j <= end; j++){
                arr2[cnt] = array[j];
                cnt++;
            }
            
            Arrays.sort(arr2);
            
            answer[i] = arr2[k];
        }
        
        return answer;
    }
}
