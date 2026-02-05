import java.util.Arrays;

class Solution {
    public String[] solution(String[] strings, int n) {
        // n번째 문자 기준으로 정렬, 같으면 사전순 정렬
        Arrays.sort(strings, (s1, s2) -> {
            if (s1.charAt(n) != s2.charAt(n)) {
                return s1.charAt(n) - s2.charAt(n); // n번째 문자 기준
            }
            return s1.compareTo(s2); // n번째 문자가 같으면 사전순
        });
        return strings;
    }
}