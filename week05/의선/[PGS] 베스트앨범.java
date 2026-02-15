package week5;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution1 {
    public int[] solution(String[] genres, int[] plays) {
        int len = genres.length;


        HashMap<String, Integer> cntBox = new HashMap<>();
        for (int i = 0; i < len; i++) {
            cntBox.put(genres[i], cntBox.getOrDefault(genres[i], 0) + plays[i]);
        }


        List<String> rank = new ArrayList<>(cntBox.keySet());
        rank.sort((o1, o2) -> cntBox.get(o2) - cntBox.get(o1));


        List<Integer> resultList = new ArrayList<>();

        for (String s : rank) {
            int max1 = -1, maxIdx1 = -1;
            int max2 = -1, maxIdx2 = -1;

            for (int i = 0; i < len; i++) {
                if (genres[i].equals(s)) {
                    int p = plays[i];


                    if (p > max1) {
                        max2 = max1;
                        maxIdx2 = maxIdx1;
                        max1 = p;
                        maxIdx1 = i;
                    }

                    else if (p > max2) {
                        max2 = p;
                        maxIdx2 = i;
                    }
                }
            }


            if (maxIdx1 != -1) resultList.add(maxIdx1);
            if (maxIdx2 != -1) resultList.add(maxIdx2);
        }


        int[] answer = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            answer[i] = resultList.get(i);
        }

        return answer;
    }
}