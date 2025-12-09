package StudyCodingTest.List.hash;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/*
    개수가 많은거를 무조건 선택하라는거잖아.
    for(종류별 개수 count// int t : tangerine)
    내림차순 정리하면 되는거 Collection.sort
    k 이상이면 끝내
*/
public class PGS_mandarin {
    class Solution {
        public int solution(int k, int[] tangerine) {
            int answer = 0;
            HashMap<Integer, Integer> map = new HashMap<>();

            // 종류별 개수 세기
            for (int t : tangerine) {
                map.put(t, map.getOrDefault(t, 0) + 1);
            }

            // 개수만 모아서 내림차순 정렬
            List<Integer> counts = new ArrayList<>(map.values());
            Collections.sort(counts, Collections.reverseOrder());

            int sum = 0;

            // 가장 많은 개수부터 더해서 k 이상이 되는 순간 stop
            for (int c : counts) {
                sum += c;
                answer++;
                if (sum >= k) {
                    break;
                }
            }

            return answer;
        }
    }
}
