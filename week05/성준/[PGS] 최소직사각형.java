/*
    가장 작은 지갑
    가로는 제일 긴거 세로는 제일 짧은거로 하면 작은거 나옴 => 전부 다 수납 가능
    
*/
class Solution {
    public int solution(int[][] sizes) {
        int a = 0;
        int b = 0;
        for (int i = 0; i < sizes.length; i++) {
            int A = Math.max(sizes[i][0], sizes[i][1]);
            int B = Math.min(sizes[i][0], sizes[i][1]);
            a = Math.max(a, A);
            b = Math.max(b, B);
        }
        int answer = a * b;
        return answer;
    }
}