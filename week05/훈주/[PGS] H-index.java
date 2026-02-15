import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {

        // 오름차순 정렬
        Arrays.sort(citations);

        int n = citations.length;

        for (int i = 0; i < n; i++) {

            // 현재 위치에서 가능한 h 계산
            int h = n - i;

            // 조건 만족하면 반환
            if (citations[i] >= h) {
                return h;
            }
        }

        return 0;
    }
}