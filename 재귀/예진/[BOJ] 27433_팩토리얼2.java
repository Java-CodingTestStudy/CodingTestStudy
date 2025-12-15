import java.util.Scanner;

public class Main{
    
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        
        System.out.println(factorial(N));

        sc.close();
    }
    
    private static long factorial(int num){ 
        if(num == 0) return 1;
        if(num == 1) return 1;
        return num * factorial(num-1);
    }
}