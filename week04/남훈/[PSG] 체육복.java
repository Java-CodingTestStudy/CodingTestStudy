// 전체 학생 수 : n
// 도난 당한 학생 번호 배열: lost
// 여벌 체육복 학생들의 번호 배열 : reserve

// lost 배열 내 수의 +1, -1이 reserve에 있어야 return + 1
// 근데 또 겹치면 +-중 하나만 빌려주니까 +1
// lost가 있어야 reserve가 필요한거니까 중첩반복?
// 일단 answer는 n - 남은 lost 명 수

import java.util.Arrays;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;

        Arrays.sort(lost);
        Arrays.sort(reserve);

        answer = n - lost.length();

        for (i = 0; i < lost.length; i++){
            for (j = 0; j < reserve.length; j++){
                if (lost[i] - 1 == reserve[j] || lost[i] + 1 == reserve[j]){
                    answer++;
                    reserve.length - 1;
                    break;
                }
            }
            return answer;
        }
    }