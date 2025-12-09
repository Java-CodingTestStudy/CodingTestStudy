package StudyCodingTest.List.hash;

import java.util.HashMap;

public class PGS_RunnerNotfinish {

    public static void main(String[] args) {

        Solution s = new Solution();

        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};

        String result = s.solution(participant, completion);
        System.out.println(result);  // mislav
    }
    /*
        participant for 문써서 전부 등록하고
        completion 도 for 문써서 완주자 제거 해주면 => remove 했는데 하나 runtime error 뜸 이거 좋은 방식이 아닌가봄
        return 나오지 않음?
    */
    // static 내부 클래스
    static class Solution {
        public String solution(String[] participant, String[] completion) {

            HashMap<String, Integer> map = new HashMap<>();

            // participant(참자가) map에 넣어줘
            for(int i = 0; i< participant.length; i++){
                String name = participant[i];
                //key 존재하면 해당 값 반환 +1, 없으면 0
                map.put(name, map.getOrDefault(name, 0)+1);
            }
            // completion(완주자) 제거할게
            for (int i = 0;  i< completion.length; i++){
                String name = completion[i];
                // 이름 있어? 제거해버려
                map.put(name, map.get(name)-1);
            }
            // 야 완주 못했냐?ㅋ
            for(String name : map.keySet()){
                if(map.get(name) != 0){
                    return name;
                }
            }

            return "";
        }
    }
}
