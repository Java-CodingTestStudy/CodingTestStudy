import java.util.*;

class Solution {
    public String[] solution(String[] record) {

        // 1. 유저 ID -> 닉네임
        Map<String, String> nickMap = new HashMap<>();

        // 2. 행동 로그 저장 (uid + 행동)
        List<String> logs = new ArrayList<>();

        // 3. 기록 처리
        for (String r : record) {
            String[] parts = r.split(" ");
            String action = parts[0];
            String uid = parts[1];

            if (action.equals("Enter")) {
                String nickname = parts[2];
                nickMap.put(uid, nickname);
                logs.add(uid + " ENTER");
            }
            else if (action.equals("Leave")) {
                logs.add(uid + " LEAVE");
            }
            else { // Change
                String nickname = parts[2];
                nickMap.put(uid, nickname);
            }
        }

        // 4. 최종 메시지 생성
        String[] answer = new String[logs.size()];
        int idx = 0;

        for (String log : logs) {
            String[] parts = log.split(" ");
            String uid = parts[0];
            String action = parts[1];

            String nickname = nickMap.get(uid);

            if (action.equals("ENTER")) {
                answer[idx++] = nickname + "님이 들어왔습니다.";
            } else {
                answer[idx++] = nickname + "님이 나갔습니다.";
            }
        }

        return answer;
    }
}