package week5;

import java.util.*;
class Solution2 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = {};

        int len = commands.length;
        answer = new int[len];

        for(int i=0;i<len;i++){

            int start = commands[i][0];
            int end = commands[i][1];
            int idx = commands[i][2];

            int[] subArray = Arrays.copyOfRange(array,start-1,end);

            Arrays.sort(subArray);
            answer[i] = subArray[idx-1];


        }



        return answer;
    }
}