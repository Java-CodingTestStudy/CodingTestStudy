import java.util.*;
public class Main {
		public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		int n= sc.nextInt();
		Queue<Integer> q= new LinkedList<>();
		for(int i=1; i<=n; i++) {
			q.offer(i);
		}
		
		while(!q.isEmpty()) {
			if(q.size()==1) System.out.println(q.peek());
				q.poll();
				q.offer(q.peek());
				q.poll();
        }
		}
}