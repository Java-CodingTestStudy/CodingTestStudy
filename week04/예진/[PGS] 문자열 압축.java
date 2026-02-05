/*
문자열 길이만큼 단위를 반복하여 압축 문자열을 구하고 비교 -> Math.min()

? 처음 떠올린건 주먹구구식으로 처음부터 for로 비교 혹은 해시를 사용해 세련되게 둘 중 한 방법
? 구구식이 아닌 해시맵이나 셋을 사용해서 반복되는 문자열에 대해 개수만 따로 구해서 압축하려했으나,
연속적이어야하므로. 또한 중간부터 압축되는 경우가 없고 무조건 앞의 문자부터 시작.
또한 반복분 두 번을 돌아 N^2이어도 1000 * 1000이므로 런타임 안전해서 그냥 for 두 번 돌림


문자열을 unit 단위로 압축하는 방법
- 문자열 길이 - unit 까지만 반복(bound 예외 피하기 위함)
- unit 길이만큼 substring 해서 문자열을 비교
- 같으면 cnt++
- 다른 경우 cnt > 1 이면 앞서 반복된 문자열 append
- 다른 경우 cnt == 1 이면 앞선 문자열 append

- 반복문 빠져나와서 남은 문자열 처리
- 반복된 문자열이 남아있는 경우 -> append
- endIdx로 추적 
*/

class Solution {
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;

        // 문자열 길이 절반 이상이 되면 어차피 압축 불가
        for (int i = 1; i <= s.length() / 2; i++) {
            answer = Math.min(answer, compress(s, i).length());
        }
        return answer;
    }

    // 문자열 압축
    // str: 문자열, unit: 단위
    public String compress(String str, int unit) {
        StringBuilder sb = new StringBuilder();
        int repeatCnt = 1;
        int endIdx = 0;

        // 맨 처음은 따로 떼어 준비 (뒷부분부터 비교)
        String atom = str.substring(0, unit); // (참고) substring의 lastidx는 length까지만 허용

        for (int i = unit; i <= str.length() - unit; i += unit) {
            // 비교할 뒷 unit 길이만큼의 문자열
            String comp = str.substring(i, i + unit);

            // 같으면 cnt++
            if (atom.equals(comp)) {
                repeatCnt += 1;
            }
            // 다른경우
            else {
                // 반복된 문자열인 경우
                if (repeatCnt > 1) {
                    sb.append(String.valueOf(repeatCnt) + atom);
                    repeatCnt = 1;
                    atom = comp;
                }
                // 반복없는 문자열인 경우
                else {
                    sb.append(atom);
                    atom = comp;
                }
            }
            // 처리된 문자열 끝 점 추적
            endIdx = i;
        }

        // 남은 문자열 처리
        if (repeatCnt > 1) {
            sb.append(String.valueOf(repeatCnt) + atom);
            endIdx += unit;
        }
        sb.append(str.substring(endIdx));

        return sb.toString().isBlank() ? str : sb.toString();
    }
}