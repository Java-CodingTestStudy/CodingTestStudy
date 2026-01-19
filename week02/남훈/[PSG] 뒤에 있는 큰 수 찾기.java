import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int n = numbers.length; //numbers 배열 길이
        int[] answer = new int[n]; // 정답 저장할 배열
        Arrays.fill(answer, -1); //기본값은 뒤에 큰수가 없다는 의미로 -1

  		// 스택의 메소드인 Deque
  		// 숫자들의 인덱스를 저장할 스택
        Deque<Integer> stack = new ArrayDeque<>(); 

        for (int i = 0; i < n; i++) { // 배열 왼족부터 확인
            while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) { 
  			// 1. 스택이 비어있지 않고 
  			// 2. 스택 맨 위 인덱스의 값이
  			// 현재 값보다 작다면 스택에서 인덱스 하나 꺼냄
                int idx = stack.pop();
  			// idx 위치의 숫자는 현재 숫자가 뒤에 있는 큰수가 됨
                answer[idx] = numbers[i];
            }
  			// 현재 인덱스 i는 아직 뒤의 큰수 못찾았으니 스택에 저장
            stack.push(i);
        }

        return answer;
    }
}