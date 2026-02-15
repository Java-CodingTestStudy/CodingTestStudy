/*
    정렬을 해서 중간 값을 뽑으면 되는거 같은데간 값을 뽑으면 되는거 같은데
*/
import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        // System.out.println(Arrays.toString(citations));
        // int answer = citations[citations.length / 2];
        // System.out.println(answer);
        int count = citations.length; // 논문 총 개수
        int CassHighlight = 0; // h 최대값
        
         for (int i = 0; i < count; i++) {
            int papers = count - i; // citations[i] 이상 인용된 논문 수
            CassHighlight = Math.max(CassHighlight, Math.min(citations[i], papers));
        }
        return CassHighlight;
    }
}


