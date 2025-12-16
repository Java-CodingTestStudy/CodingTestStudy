
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int num = fibo(n);
        bw.write(num+"");
        bw.close();
        
}  
    public static int fibo(int n){
        if(n == 0){
            return 0;
        }else if(n == 1){
            return 1;
        }
        else{
            return fibo(n-1)+fibo(n-2);
        }
    }
}
