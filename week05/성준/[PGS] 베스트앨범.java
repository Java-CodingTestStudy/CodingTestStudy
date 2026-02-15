/*
    장르를 비교 -> 그 안에서 노래 비교 -> 최대 2곡만 뽑아
    장르내 많이 재생된 노래를 먼저 수록 -> 재생 횟수는 내림 차순으로 하라는거고  ( b-a )
    장르 내에서 재생 횟수가 같은 노래중에서는 고유 번호가 낮은 노래를 먼저 수록 -> 오름차순으로 정렬하라는거고 ( a - b)
*/
import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();

        // 장르별 총 재생 수
        Map<String, Integer> totalPlays = new HashMap<>();
        // 장르별 (노래 고유번호 -> 재생 수)
        Map<String, Map<Integer, Integer>> music = new HashMap<>();

        for (int i = 0; i < plays.length; i++) {
            String g = genres[i];

            totalPlays.put(g, totalPlays.getOrDefault(g, 0) + plays[i]);

            music.putIfAbsent(g, new HashMap<>());
            music.get(g).put(i, plays[i]);
        }

        // 장르를 총 재생 수 내림차순으로 정렬
        List<String> genreKeys = new ArrayList<>(totalPlays.keySet());
        Collections.sort(genreKeys, (a, b) -> totalPlays.get(b) - totalPlays.get(a));

        for (String g : genreKeys) {
            Map<Integer, Integer> map = music.get(g);
            List<Integer> songIds = new ArrayList<>(map.keySet());

            // 장르 내: 재생 수 내림차순, 같으면 고유번호 오름차순
            Collections.sort(songIds, (i1, i2) -> {
                int p1 = map.get(i1);
                int p2 = map.get(i2);
                if (p1 != p2) return p2 - p1;   // 재생 수 내림차순
                return i1 - i2;                 // 고유번호 오름차순
            });

            // 최대 2곡 수록
            answer.add(songIds.get(0));
            if (songIds.size() > 1) answer.add(songIds.get(1));
        }

        // List<Integer> -> int[]
        return answer.stream().mapToInt(x -> x).toArray();
    }
}
