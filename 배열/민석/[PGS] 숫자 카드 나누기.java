import java.util.*;
class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        
        int bigA = arrayA[0];
        for(int i = 1 ; i<arrayA.length;i++){
            bigA = gongyaksoo(bigA,arrayA[i]);
            
        }
    
        int bigB = arrayB[0];
        for(int i = 1 ; i<arrayB.length;i++){
            bigB = gongyaksoo(bigB,arrayB[i]);
            
        }
        
        boolean checkBigA= true;
        boolean checkBigB= true;
        
        if(bigA== 1 && bigB== 1) return 0;
        
        if(bigA != 1){ //최대공약수가 있다면
            for(int i =0 ;i <arrayB.length;i++){
            if(arrayB[i]%bigA == 0){ //나눠진다면
                checkBigA = false;
            } //bigA는 만족하지 않음 
            }   
            
        }
        else checkBigA=false; //최대공약수가 없으면 
        
        if(bigB!=1){ //최대공약수가 있다면  
            for(int i =0 ;i <arrayA.length;i++){
            if(arrayA[i]%bigB ==0){ //나눠진다면 
                checkBigB = false;
                } //bigB는 만족하지 않음 
            }
            
        }else checkBigB=false;
        
        
         
        
        if(checkBigA && checkBigB){ //A와 B모두 만족한다면 더 큰거 반환
            return Math.max(bigA,bigB);
        }
        else if(checkBigA)return bigA; //A만 만족한다면 A반환
        else if(checkBigB)return bigB;
        else return 0;
        
    
    }
    
    
    public int gongyaksoo(int n,int m ){
        
        while(m!=0){
            int remain = n % m;
            n = m;
            m = remain;
            
        }
        return n;
        
        
        
        
        
        
    }
}