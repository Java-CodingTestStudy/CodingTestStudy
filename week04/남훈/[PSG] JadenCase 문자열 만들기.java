class Solution {
    public String solution(String s) {
        StringBuilder result = new StringBuilder(); // 최종 문자열을 담을 통
        boolean isNewWord = true; // 새로운 단어의 시작인지 체크

        // 문자열 하나씩 순서대로 확인
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == ' ') {
                // 공백이면 그대로 추가
                result.append(c);
                // 다음 글자는 새로운 단어의 시작
                isNewWord = true;
            } else {
                if (isNewWord) {
                    // 단어의 첫 글자이면 대문자로
                    result.append(Character.toUpperCase(c));
                    isNewWord = false; // 이제 단어 중간으로 표시
                } else {
                    // 단어 중간이면 소문자로
                    result.append(Character.toLowerCase(c));
                }
            }
        }

        return result.toString(); // 완성된 문자열 반환
    }
}