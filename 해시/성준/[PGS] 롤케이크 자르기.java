package StudyCodingTest.List.hash;

import java.util.HashMap;

/*
    제발 주는대로 먹어라
    topping 전체를 먼저 카운트 하고
    하나씩 옆으로 가면서 count 해서 서로 맞는지
    마지막에 if older.size == young.size 비교하라는거잖아.
*/
public class PGS_RollCakeCut {
    class Solution {
        public int solution(int[] topping) {

            // 형 동생
            HashMap<Integer, Integer> older = new HashMap<>();
            HashMap<Integer, Integer> young = new HashMap<>();

            // 1) 일단 형한테 전체 토핑을 줘봐
            for (int t : topping) {
                older.put(t, older.getOrDefault(t, 0) + 1);
            }

            int answer = 0;

            // 2) i 지점에서 하나씩 옮기면서 비교
            for (int i = 0; i < topping.length; i++) {

                int t = topping[i];

                // 형 -> 동생
                young.put(t, young.getOrDefault(t, 0) + 1);

                // 형 하나 빼
                older.put(t, older.get(t) - 1);
                if (older.get(t) == 0) {
                    older.remove(t); // 종류가 0개면 토핑 종류 제거
                }

                // 종류가 같으면 공평한 분할
                if (young.size() == older.size()) {
                    answer++;
                }
            }

            return answer;
        }
    }



}
