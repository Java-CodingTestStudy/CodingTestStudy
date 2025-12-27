import java.util.*;
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        //(h-2)*(w-2)=yellow의 yh* yellow의 yw
        //(전체 세로=h)/ (전체 가로==w)
        for(int i=1; i<=Math.sqrt(yellow);i++){
            if(yellow%i==0){
                int tmpW= (yellow/i)+2;
                int tmpH=i+2;
                if(brown==(tmpW*tmpH)-yellow) {
                    answer[0]=tmpW;
                    answer[1]=tmpH;
                }
            }
        }
        return answer;
    }
}