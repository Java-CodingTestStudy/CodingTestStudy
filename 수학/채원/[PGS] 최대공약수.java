import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    	public static long minValueMath(long a, long b) {
		if(b==0) return a;
		else return minValueMath(b, a%b);
	}
    public static void main(String[] args) throws IOException{
        //최대 공약수 문제
		//길이가 3 (3- 111)
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		long a= Long.parseLong(st.nextToken());		
		long b= Long.parseLong(st.nextToken());
		
		//System.out.println(minValueMath(a,b));
	int tmp= Integer.valueOf(Long.toString(minValueMath(a,b)));
		StringBuilder r= new StringBuilder();
		//omg 시간초과났어요~ String x StringBuilder O
		for(int i=0; i<tmp; i++) {
			r.append("1");
		}
		System.out.println(r);
    }
}