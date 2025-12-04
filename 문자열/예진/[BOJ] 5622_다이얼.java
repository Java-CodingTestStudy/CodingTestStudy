import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int ans = 0;
        
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c >= 'W') ans += 10;
            else if(c >= 'T') ans += 9;
            else if(c >= 'P') ans += 8;
            else if(c >= 'M') ans += 7;
            else if(c >= 'J') ans += 6;
            else if(c >= 'G') ans += 5;
            else if(c >= 'D') ans += 4;
            else if(c >= 'A') ans += 3;
        }
        
        System.out.println(ans);
    }
}