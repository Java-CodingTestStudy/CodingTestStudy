import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer= new int[commands.length]; //commands 개수만큼 나와야함 (틀린이유1)
        for(int i=0; i<commands.length;i++){
             int[] s = Arrays.copyOfRange(array,commands[i][0] - 1, commands[i][1]);
            Arrays.sort(s);
            
             answer[i]= s[commands[i][2]-1]; 
           
          //배열 복사하는 방법 (https://eco-dev.tistory.com/entry/Java-%EC%9E%90%EB%B0%94%EC%97%90%EC%84%9C%EC%9D%98-%EB%B0%B0%EC%97%B4-%EB%B3%B5%EC%82%AC-%EB%B0%A9%EB%B2%95-arraycopy-copyOfRange-copyOf)
            
            
          // Arrays.copyOf(배열이름, 복사할 크기), 
        //System.arraycopy(복사할 배열,index ,복사받을 배열,index, 복사받을 길이 ),
            //[배열이름].copyOfRange(배열이름, 인덱스1, 인덱스 2);
            //그중에서도 원본 배열에서 부분 추출은 copyOfRange()사용해야함 
        }
       
        return answer;
    }
}