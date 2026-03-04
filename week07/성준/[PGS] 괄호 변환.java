/*

*/
class Solution {
    public String solution(String p) {
        
        // 입력이 빈 문자열
        if(p.equals("")) return p;
        
        // 2.문자열 w
        int splitIdx = 0;
        int count = 0;
        for(int i = 0; i<p.length(); i++){
            if(p.charAt(i) == '('){
                count++;
            }else{
                count--;
            }
            
            if(count == 0){
                splitIdx = i + 1;
                break; // ()() 이 경우 덮어씌워짐
            }
        }
        String u = p.substring(0,splitIdx);
        String v = p.substring(splitIdx);
        
        // 3. u가 올바른 괄호 문자열이라면
        if (isCorrect(u)) {
            return u + solution(v);
        }

        // 4. u가 올바르지 않은 경우
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        sb.append(solution(v));
        sb.append(")");

        // 4-4. u의 첫/마지막 제거 후 괄호 뒤집기
        for (int i = 1; i < u.length() - 1; i++) {
            sb.append(u.charAt(i) == '(' ? ')' : '(');
        }

        return sb.toString();
    }

    // 올바른 괄호 문자열인지 확인
    private boolean isCorrect(String u) {
        int count = 0;
        for (int i = 0; i < u.length(); i++) {
            count += u.charAt(i) == '(' ? 1 : -1;
            if (count < 0) return false;
        }
        return count == 0;
    }
}