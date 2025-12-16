import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)) ;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)) ;
        
        int n = Integer.parseInt(br.readLine());
        
        long result = fac(n);
        
        bw.write(result + "");
        
        bw.close();
        
        
    }
    public static long fac(int n){
        if(n == 0){
            return 1;
        }else{
            return n*fac(n-1);
        }
    }
}
