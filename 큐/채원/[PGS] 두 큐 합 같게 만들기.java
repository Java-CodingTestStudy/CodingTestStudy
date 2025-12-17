import java.util.*;

//문제 이해 못해서 chatgpt에게 도움을 받았습니다.
/**
 * 문제: 두 큐의 합을 같게 만들기 위해 최소 작업 횟수를 구하는 문제
 *      - 작업 1회 = pop + insert
 *      - 어떤 방법으로도 합을 맞출 수 없으면 -1 반환
 * 
 * 시간복잡도: O(N)
 *      - 각 큐의 원소는 최대 2번씩 이동 가능
 *      - N = queue1.length
 *      - 따라서 최대 이동 횟수는 2 * N
 */
class Solution {
    public int solution(int[] queue1Arr, int[] queue2Arr) {
        // 큐를 실제로 구현 (FIFO 구조)
        Queue<Long> queue1 = new LinkedList<>();
        Queue<Long> queue2 = new LinkedList<>();

        long sum1 = 0; // queue1의 현재 합
        long sum2 = 0; // queue2의 현재 합

        // 배열을 큐에 넣고 각 큐의 합 계산
        for (int i = 0; i < queue1Arr.length; i++) {
            long val1 = queue1Arr[i];
            long val2 = queue2Arr[i];
            queue1.offer(val1); // queue1 끝에 추가
            queue2.offer(val2); // queue2 끝에 추가
            sum1 += val1;       // queue1 합 업데이트
            sum2 += val2;       // queue2 합 업데이트
        }

        long totalSum = sum1 + sum2; // 두 큐 전체 합
        if (totalSum % 2 != 0) return -1; // 전체 합이 홀수면 불가능

        long target = totalSum / 2; // 각 큐가 목표로 해야 하는 합
        int count = 0;              // 작업 횟수 카운트

        // 반복: 큐가 비어있지 않은 동안 수행
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            // 현재 queue1 합이 목표와 같으면 작업 종료
            if (sum1 == target) return count;

            if (sum1 < target) {
                // queue1 합이 부족 → queue2에서 원소를 가져와야 함
                if (queue2.isEmpty()) break; // 이동할 원소가 없으면 종료
                long val = queue2.poll();    // queue2 맨 앞 원소 제거 (pop)
                queue1.offer(val);           // queue1 끝에 추가 (insert)
                sum1 += val;                 // queue1 합 업데이트
                sum2 -= val;                 // queue2 합 업데이트
            } else {
                // queue1 합이 초과 → queue1에서 원소를 제거하여 queue2에 넣음
                if (queue1.isEmpty()) break; // 이동할 원소가 없으면 종료
                long val = queue1.poll();    // queue1 맨 앞 원소 제거 (pop)
                queue2.offer(val);           // queue2 끝에 추가 (insert)
                sum1 -= val;                 // queue1 합 업데이트
                sum2 += val;                 // queue2 합 업데이트
            }

            count++; // pop + insert = 1 작업
        }

        // 반복 종료 후에도 합이 목표와 다르면 불가능
        return sum1 == target ? count : -1;
    }
}
