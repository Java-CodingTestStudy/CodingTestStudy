package 배열;

import java.util.*;
class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum=0;
        String num = sc.next();
        for(int i=0;i<n;i++){
            sum +=num.charAt(i)-'0';
        }
        System.out.println(sum);
    } 
}
