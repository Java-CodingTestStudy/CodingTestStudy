import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {

            // 시작, 끝, k 인덱스 보정 (1 → 0 기준)
            int start = commands[i][0] - 1;
            int end = commands[i][1];
            int k = commands[i][2] - 1;

            // 부분 배열 복사
            int[] temp = Arrays.copyOfRange(array, start, end);

            // 정렬
            Arrays.sort(temp);

            // k번째 값 저장
            answer[i] = temp[k];
        }

        return answer;
    }
}