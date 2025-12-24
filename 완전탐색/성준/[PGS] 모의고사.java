package studycodingtest.Brute_ForceSerch;

import java.util.ArrayList;

/*
   1번 수포자 [1,2,3,4,5] 반복
   2번 수포자 [2,1,2,3,2,4,2,5] 반복
   3번 수포자 [3,3,1,1,2,2,4,4,5,5] 반복

   if 문으로
   배열 넣어주고 반복 하는데 맞으면 cnt ++ 해주고 비교 하면 되는거 아닌가?
 */
public class PGS_MockExam {
    public int[] solution(int[] answers) {
        int[] p1 = {1,2,3,4,5};
        int[] p2 = {2,1,2,3,2,4,2,5};
        int[] p3 = {3,3,1,1,2,2,4,4,5,5};

        int[] score = new int[3];

        // 1️ 점수 세기
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == p1[i % p1.length]) score[0]++;
            if (answers[i] == p2[i % p2.length]) score[1]++;
            if (answers[i] == p3[i % p3.length]) score[2]++;
        }

        // 2 최댓값 구하기
        int max = score[0];
        for (int i = 1; i < score.length; i++) {
            if (score[i] > max) {
                max = score[i];
            }
        }

        // 3 최댓값인 사람 찾기
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < score.length; i++) {
            if (score[i] == max) {
                list.add(i + 1);
            }
        }

        // 4 배열로 변환
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }

}
