class Solution {
    public int[] solution(String s) {
        int[] answer = {0,0};
        int zeroCnt = 0;        // 제거된 0개수
        int rep = 0;            // 반복 횟수
        
        // s 가 1이 될 때까지 while 반복
        while(!s.equals("1")){
            // 0 제거(replace) -> 0 개수 카운트(chars.filter)
            zeroCnt += s.chars().filter(c -> c == '0').count();
            int len = s.replace("0", "").length();
            
            // 제거 후 길이로 이진 변환
            String newS = convertToBi(len);
            
//          정수를 2진수 문자열로 변환하는 내장함수 toBinaryString
//          String newS = Integer.toBinaryString(len);
            s = newS;
            
            rep++;
        }
        
        answer[0] = rep;
        answer[1] = zeroCnt;
        
        return answer;
    }
    
    // 2진법 변환 함수
    private String convertToBi(int num){
        String res = "";
        
        while(num != 0){
            res = String.valueOf(num % 2) + res;
            num /= 2;
        }
        
        return res;
    }
}