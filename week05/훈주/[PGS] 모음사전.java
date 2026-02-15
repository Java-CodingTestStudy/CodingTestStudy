class Solution {
    public int solution(String word) {

        // 자리별 가중치
        int[] weight = {781, 156, 31, 6, 1};
        String vowels = "AEIOU";

        int answer = word.length();

        for (int i = 0; i < word.length(); i++) {

            char c = word.charAt(i);

            // 현재 문자의 인덱스
            int index = vowels.indexOf(c);

            answer += index * weight[i];
        }

        return answer;
    }
}