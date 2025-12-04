package 배열;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        int n1=arrayA[0],n2=arrayB[0];
        for(int i=1;i<arrayA.length;i++){
            n1 = gcd(n1,arrayA[i]);
            
            if(n1 == 1) break;
        }
        for(int i=1;i<arrayB.length;i++){
            n2 = gcd(n2,arrayB[i]);
            
            if(n2 == 1) break;
        }
        
        int flag1=0;
        for(int i=0;i<arrayB.length;i++){
            if(arrayB[i]%n1==0){
                flag1 = 1;
            }
        }
        int flag2=0;
        for(int i=0;i<arrayA.length;i++){
            if(arrayA[i]%n2==0){
                flag2 = 1;
            }
        }
        if(flag1==1&&flag2==1){
            return 0;    
        }else if(flag1==1&&flag2==0){
            return n2;
        }else if(flag1==0&&flag2==1){
            return n1;
        }
        
        else{
            return n1>n2?n1:n2;
        }
        
        
        
        
        
        
        
        
       
    }
    public int gcd(int a,int b){
        int n = 1;
        for(int i=1;i<=a;i++){
            if(a%i==0&&b%i==0){
                n = i;
            }
        }
        return n;
    }
    
}