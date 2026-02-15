import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

class Solution {
    public int[] solution(String[] genres, int[] plays) {

        // 장르별 총 재생수
        HashMap<String, Integer> totalMap = new HashMap<>();

        // 장르별 노래 목록
        HashMap<String, List<int[]>> songMap = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {

            // 총 재생수 누적
            totalMap.put(genres[i],
                    totalMap.getOrDefault(genres[i], 0) + plays[i]);

            // 노래 저장 (재생수, 고유번호)
            if (!songMap.containsKey(genres[i])) {
                songMap.put(genres[i], new ArrayList<int[]>());
            }
            songMap.get(genres[i]).add(new int[]{plays[i], i});
        }

        // 장르 정렬 리스트
        List<String> genreList = new ArrayList<>(totalMap.keySet());

        Collections.sort(genreList, (a, b) ->
                totalMap.get(b) - totalMap.get(a)
        );

        List<Integer> result = new ArrayList<>();

        for (String genre : genreList) {

            List<int[]> songs = songMap.get(genre);

            // 장르 내 노래 정렬
            Collections.sort(songs, (a, b) -> {
                if (b[0] == a[0]) {
                    return a[1] - b[1];
                }
                return b[0] - a[0];
            });

            // 최대 두 곡 선택
            result.add(songs.get(0)[1]);
            if (songs.size() > 1) {
                result.add(songs.get(1)[1]);
            }
        }

        // 결과 배열 변환
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
}