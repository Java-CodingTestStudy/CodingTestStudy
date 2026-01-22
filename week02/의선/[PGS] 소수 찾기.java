package week2;

import java.util.*;

class Solution {
	
	
	
	
//	public int solution(String numbers) {
//		int answer = 0;
//
//		
//		int len = numbers.length();
//		
//		char[]box = numbers.toCharArray();
//		HashSet<Integer> set = new HashSet<>();
//		 
//		for(int i=0;i<len;i++) {
//			
//			String temp = "";
//			
//			for(int j=0;j<len;j++) {
//				temp +=box[i];
//				if(i!=j) {
//					temp+=box[j];
//				}
//				set.add(Integer.parseInt(temp));
//				
//				temp="";
//			}
//		}
//		for (Integer s : set) {
//            System.out.println(s);
//			if(check(s)) {
//				answer++;
//			}
//		}
//		
//		
//		
//		
//		return answer;
//	}
//	
//	
//	public boolean check(int n) {
//		
//		if(n<=1) {
//			return false;
//		}
//		else if(n==2) {
//			return true;
//		}
//		else if(n%2==0) {
//			return false;
//		}
//		for(int i=3;i<Math.sqrt(n);i+=2) {
//			if(n%i==0) return false;
//		}
//		return true;
//	}
	
	
	
	
	
	
	
    Set<Integer> set = new HashSet<>();
    boolean[] visited;

    public int solution(String numbers) {
        visited = new boolean[numbers.length()];
        dfs(numbers, "", 0);

        int answer = 0;
        for (int n : set) {
            if (isPrime(n)) answer++;
        }
        return answer;
    }

    // 숫자 조합 생성
    void dfs(String numbers, String cur, int depth) {
        if (!cur.equals("")) {
            set.add(Integer.parseInt(cur));
        }

        if (depth == numbers.length()) return;

        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(numbers, cur + numbers.charAt(i), depth + 1);
                visited[i] = false;
            }
        }
    }

    // 소수 판별
    boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;

        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }
}

