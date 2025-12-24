import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        //문젤ㄹ 왜 찍으십니까?
        int[] p1= {1,2,3,4,5};
        int[] p2={2,1,2,3,2,4,2,5};
        int[] p3= {3,3,1,1,2,2,4,4,5,5};
        int[] t= new int[3];
      
        
        for(int i=0; i<answers.length; i++){
            //p1인경우 
            int tmp;
            tmp=i%p1.length;
            if(answers[i]==p1[tmp]) {
                t[0]+=1;
            }
            //p2
            tmp=i%p2.length;
            if(answers[i]==p2[tmp]) {
                t[1]+=1;
            }
            //p3
            tmp=i%p3.length;
            if(answers[i]==p3[tmp]) {
                t[2]+=1;
            }
        }
      
        int maxN= Math.max(t[0],Math.max(t[1],t[2]));
        StringBuilder sb= new StringBuilder("");
        //int index=0;
        for(int i=0; i<t.length; i++){
            //어차피 3번으로 정해져있지만 
            if(t[i]==maxN){
                sb.append(i+1);
                          }
        }
     
        int[] answer= new int[sb.length()];
        for(int i=0; i<sb.length(); i++){
            answer[i] = Integer.parseInt(String.valueOf(sb.charAt(i)));
        }
        
        return answer;
    }
}