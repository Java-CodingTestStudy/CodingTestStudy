import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        String n;
        char c;
        s = s.toLowerCase();
        String[] tmp = s.split(" ");
        for(int i = 0; i < tmp.length ; i++){
            n = tmp[i];
            c = tmp[i].charAt(0);
            if(c <'0' || c>'9'){  // c>'9' 이기만 하면 됨  특수문자가 없으니깐
                String a = c + ""; // StringBuilder 
                a= a.toUpperCase(); // 첫 글자 대문자
                n = a + n.substring(1); // 누적해서 합치기
            }
            answer = answer + " " + n;
        }
        answer = answer.substring(1); // 첫 문자 공백 제거하기
        return answer;
    }
}