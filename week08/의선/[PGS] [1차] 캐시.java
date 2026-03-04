import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {

        if (cacheSize == 0) return cities.length * 5;

        int answer = 0;

        Deque<String> queue = new LinkedList<>();

        for (int i = 0; i < cities.length; i++) {
            String city = cities[i].toLowerCase();


            if (queue.contains(city)) {
                queue.remove(city);
                queue.offer(city);
                answer += 1;
            }

            else {
                if (queue.size() >= cacheSize) {
                    queue.poll();
                }
                queue.offerLast(city);
                answer += 5;
            }
        }

        return answer;
    }
}