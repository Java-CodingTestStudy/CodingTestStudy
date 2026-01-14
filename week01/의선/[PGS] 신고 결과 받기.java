

import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = {};
        
        Set<String> unique = new HashSet<>();

        for (String r : report) {
            unique.add(r);
        } 
        
        Map<String, Integer> idx = new HashMap<>();
        for (int i = 0; i < id_list.length; i++) {  
        idx.put(id_list[i], i);
        }
        
        int n = id_list.length;
        int[] reportedCount = new int[n];

        for (String r : unique) {
            String[] parts = r.split(" ");
            String from = parts[0]; // 신고자
            String to = parts[1];   // 피신고자

            reportedCount[idx.get(to)]++;
        }
        boolean[] banned = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (reportedCount[i] >= k) banned[i] = true;
        }
        answer = new int[n];

        for (String r : unique) {
            String[] parts = r.split(" ");
            String from = parts[0];
            String to = parts[1];

            if (banned[idx.get(to)]) {  
            answer[idx.get(from)]++;
            }
        }

        

        return answer;
    }
}
