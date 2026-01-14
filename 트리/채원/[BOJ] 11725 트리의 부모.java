
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static int[] parent;
	static boolean[] visited; //Cannot store to byte/boolean array because "practice.p11725.visited" is null
	public static int rootElement(ArrayList<ArrayList<Integer>> m,int element) {
		visited[element]=true; 
		for(int next: m.get(element)) {//element 현재 위치 
			if(!visited[next]) {
				parent[next]= element;
				rootElement(m,next);//next: 한칸 이동할 수 있는 노드 
			}
		}
		return element;
		
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		/*
		 * 루트 없는 트리가 주어짐 ( 트리의 루트 =  1)
		 * 각 노드의 부모를 구하는 프로그램
		 * 2<=N<=100000
		 * 둘 째줄부터 n-1개의 줄에 트리상에 연결된 두 정점이 주어짐
		 * 
		 * */
		
		ArrayList<ArrayList<Integer>> t= new ArrayList<>();
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		int n= Integer.valueOf(st.nextToken());
		for(int i=1; i<=n+1; i++) {
			t.add(new ArrayList<Integer>());
		}
		  parent = new int[n + 1];
		    visited = new boolean[n + 1];

		for(int i=0; i<n-1; i++) {
			st= new StringTokenizer(br.readLine());
			int a= Integer.valueOf(st.nextToken());
			int b= Integer.valueOf(st.nextToken());
			//System.out.println(a+"/"+b);
			
			t.get(a).add(b);
			t.get(b).add(a);
		}
		rootElement(t, 1);
		for(int i=2; i<=n; i++) {
			/*순서대로 출력
			 * 
			 */
			System.out.println(parent[i]);
			
		}
		
	}

}
