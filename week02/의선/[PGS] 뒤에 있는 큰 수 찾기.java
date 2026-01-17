package week2;

import java.util.*;


public class Week2_2 {
	public int[] solution(int[] numbers) {
		
		int[] answer = {};
		
		
	
		
		//시간초과
		
//		answer = new int[numbers.length];
//
//		for (int i = 0; i < numbers.length; i++) {
//			int temp = numbers[i];
//			int flag = -1;
//			for (int j = i + 1; j < numbers.length; j++) {
//				int back = numbers[j];
//				if (temp < back) {
//					flag = back;
//					break;
//				}
//			}
//
//			answer[i] = flag;
//
//		}

		int n = numbers.length;
        answer = new int[n];
        Arrays.fill(answer, -1);

        Deque<Integer> stack = new ArrayDeque<>(); // 인덱스 저장

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                int idx = stack.pop();
                answer[idx] = numbers[i];
            }
            stack.push(i);
        }
		
		
		
		
		
		
		
		
		
		
		return answer;
	}
}
