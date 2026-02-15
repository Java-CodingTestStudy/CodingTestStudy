import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {

        // 장르별 노래 저장
        HashMap<String, ArrayList<int[]>> map = new HashMap<>();
        
        // 장르별 총 재생수 저장
        HashMap<String, Integer> total = new HashMap<>();

        for (int i = 0; i < plays.length; i++) {

            map.putIfAbsent(genres[i], new ArrayList<>());
            map.get(genres[i]).add(new int[]{plays[i], i});

            total.put(genres[i],
                    total.getOrDefault(genres[i], 0) + plays[i]);
        }

        // 장르 정렬 (총 재생수 기준 내림차순)
        ArrayList<String> genreList = new ArrayList<>(map.keySet());
        genreList.sort((a, b) -> total.get(b) - total.get(a));

        // 결과 저장용 리스트
        ArrayList<Integer> result = new ArrayList<>();

        // 각 장르 안에서 노래 정렬
        for (String genre : genreList) {

            ArrayList<int[]> songs = map.get(genre);

            songs.sort((a, b) -> {
                if (a[0] == b[0])
                    return a[1] - b[1];  // 인덱스 오름차순
                return b[0] - a[0];      // 재생수 내림차순
            });

            // 최대 2개까지 추가
            for (int i = 0; i < Math.min(2, songs.size()); i++) {
                result.add(songs.get(i)[1]);
            }
        }

        // 배열로 변환
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
}
