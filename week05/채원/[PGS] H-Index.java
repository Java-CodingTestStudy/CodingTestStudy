import java.util.*;
class Solution {
    public int solution(int[] citations) {
        /*
        h-index: 과학자의 생산성과 영향력을 나타내는 지표
        h-index을 나타내는 값 =h
        
        논문 n편중 / h번 이상 인용된 논문이 h편 이상이고, 
        나머지(n-h) 논문이 h번 이하 인용 되었다면, h의 최댓값이 이 과학자의 h-index이다. 
        (어떤 과학자가 발표한) 논문의 인용 횟수를 담은 배열 citation
        h-index 리턴
        */
        Arrays.sort(citations); //내림차순
        int answer=0;
        for(int i=0; i<citations.length; i++){
            if(citations[i]>=(citations.length-i)){
                System.out.println(citations.length-i+"=="+citations[i]);
                answer=citations.length-i;
                break;
            }
        }
        
        
        return answer;
    }
}