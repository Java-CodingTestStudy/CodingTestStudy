class Solution {
    public int solution(String s) {

        // 문자열 길이가 1이면
        // 압축할 수 있는 방법이 없으므로 그대로 길이 1 반환
        if (s.length() == 1) return 1;

        // answer는 가장 짧은 압축 길이를 저장
        // 초기값은 "압축을 아예 안 했을 때 길이"
        int answer = s.length();

        // 압축 단위를 1부터 문자열 길이의 절반까지 시도
        // 절반을 넘으면 반복 자체가 불가능하기 때문
        for (int unit = 1; unit <= s.length() / 2; unit++) {

            // 현재 단위에서 만들어질 압축 문자열
            StringBuilder compressed = new StringBuilder();

            // 이전에 비교할 문자열 (처음에는 맨 앞 unit만큼)
            String prev = s.substring(0, unit);

            // prev가 몇 번 연속으로 반복되었는지 세는 변수
            int count = 1;

            // 문자열을 unit 단위로 잘라가며 비교
            // i는 unit씩 증가 (0은 이미 prev로 사용)
            for (int i = unit; i < s.length(); i += unit) {

                String current;

                // 마지막에 unit만큼 자를 수 있는 경우
                if (i + unit <= s.length()) {
                    current = s.substring(i, i + unit);
                }
                // 마지막에 남는 문자열이 unit보다 짧은 경우
                else {
                    current = s.substring(i);
                }

                // 이전 문자열(prev)과 현재 문자열(current)이 같다면
                if (current.equals(prev)) {
                    // 반복 횟수 증가
                    count++;
                }
                // 다르다면
                else {
                    // 반복된 횟수가 2 이상이면 숫자를 먼저 붙임
                    if (count > 1) {
                        compressed.append(count);
                    }

                    // 이전 문자열을 압축 결과에 추가
                    compressed.append(prev);

                    // 현재 문자열을 새로운 기준(prev)으로 변경
                    prev = current;

                    // 반복 횟수 초기화
                    count = 1;
                }
            }

            // 반복문이 끝난 후
            // 마지막 문자열(prev)은 아직 압축 결과에 안 들어갔으므로 처리 필요

            // 반복 횟수가 2 이상이면 숫자 추가
            if (count > 1) {
                compressed.append(count);
            }

            // 마지막 문자열 추가
            compressed.append(prev);

            // 현재 단위에서 만든 압축 문자열 길이와
            // 기존 answer 중 더 작은 값을 저장
            answer = Math.min(answer, compressed.length());
        }

        // 모든 단위를 다 시도한 후
        // 가장 짧았던 압축 길이 반환
        return answer;
    }
}