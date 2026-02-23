class Solution {
     public String solution(String p) {
        String answer = step1(p);
     
         //2.  문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리
        // u는 "균형잡힌 괄호 문자열"로 더 이상 분리할 수 없어야 하며, v는 빈 문자열이 될 수 있습니다. 
      
        
        //3.문자열 u가 "올바른 괄호 문자열" 이라면 문자열 v에 대해 1단계부터 다시 수행합니다.
        // 3-1. 수행한 결과 문자열을 u에 이어 붙인 후 반환합니다. 
        
    
        /*
        4. 문자열 u가 "올바른 괄호 문자열"이 아니라면 아래 과정을 수행합니다. 
         4-1. 빈 문자열에 첫 번째 문자로 '('를 붙입니다. 
         4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다. 
         4-3. ')'를 다시 붙입니다. 
         4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다. 
         4-5. 생성된 문자열을 반환합니다.
        */
            
        
        
        return answer;
    }

//**************************************************************************************************1
    public String step1(String p){
        //1.입력이 비어있는 문자열일 경우 빈 문자열을 반환한다.
          if("".equals(p)) return p;
        //2단계
      return step3(step2(p));   
    }
//***************************************************************************************************2    
    public String[] step2(String p){
        //2.  문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리
        return sp(p);     
    }
    
    public static String[] sp(String r){
        // u는 "균형잡힌 괄호 문자열"로 더 이상 분리할 수 없어야 하며, v는 빈 문자열이 될 수 있습니다. 


    int index=0;
    int c= 0;
    for(int i=0; i<r.length(); i++){

        if(r.charAt(i) == '(') c++;
        else c--; // )이면  -- 0이 되면 균형이 맞다

        if(c==0){
            index=i+1;
            break;
        }
    }

        String u= r.substring(0,index);
        String v= r.substring(index);

        return new String[]{u,v};

}  
///**************************************************************************************************3.
     public String step3(String[] p){
      //3.문자열 u가 "올바른 괄호 문자열" 이라면 문자열 v에 대해 1단계부터 다시 수행합니다.
        String u= p[0];
        String v= p[1];
         
         boolean status=false; // 확인용
         boolean result=false;
         
        for(int i=0; i<u.length(); i++){
            if(u.charAt(i)=='(') status= true;
            //(이 안나온 상태에서 )이 나오면 올바르지 않기 때문에 돌아가야한다. 
            else if(status==false &&u.charAt(i)== ')'){
                result=true;
                break;
            } 
            else result=false;
        }
         // 3-1. 수행한 결과 문자열을 u에 이어 붙인 후 반환합니다.  "이어 붙인다고???"
         if(result==false) return u+step1(v);
        else return step4(u,v);
        
         
     }
///**************************************************************************************************4
        public String step4(String u,String v){
            
        /*
        4. 문자열 u가 "올바른 괄호 문자열"이 아니라면 아래 과정을 수행합니다. 
         4-1. 빈 문자열에 첫 번째 문자로 '('를 붙입니다. 
         4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다. 
         4-3. ')'를 다시 붙입니다. 
         4-4.   1) u의 첫 번째와 마지막 문자를 제거하고, 
                2)나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다. 
         4-5. 생성된 문자열을 반환합니다.
        */
            
             StringBuilder sb= new StringBuilder();
            //4-1
            sb.append("(");
            //4-2
            sb.append(step1(v));
            //4-3
            sb.append(")");
            //4-4 1)
            String t=u.substring(1,u.length()-1);
            
            //4-4 2)
         for(int i=0; i<t.length(); i++){
             if(t.charAt(i) == '(') sb.append(")");
             else sb.append("(");
         }
            
            return sb.toString();
        }
   
}