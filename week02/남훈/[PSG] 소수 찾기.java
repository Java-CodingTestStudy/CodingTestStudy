import java.util.HashSet;
import java.util.Set;

class Solution {

    // 만들어진 숫자를 중복 없이 저장하기 위한 Set
    Set<Integer> numbersSet = new HashSet<>();

    // 방문 여부 체크 배열 (숫자 조각을 사용했는지)
    boolean[] visited;

    public int solution(String numbers) {

        // 방문 배열 초기화
        visited = new boolean[numbers.length()];

        // DFS를 이용해 모든 숫자 조합 만들기
        dfs("", numbers);

        int count = 0;

        // 만들어진 숫자들 중 소수만 세기
        for (int num : numbersSet) {
            if (isPrime(num)) {
                count++;
            }
        }

        return count;
    }

    /**
     * DFS를 이용해 숫자 조합을 만드는 함수
     *
     * @param current 지금까지 만든 숫자 문자열
     * @param numbers 원본 숫자 문자열
     */
    private void dfs(String current, String numbers) {

        // 현재 문자열이 비어있지 않으면 숫자로 변환해서 Set에 저장
        if (!current.equals("")) {
            numbersSet.add(Integer.parseInt(current));
        }

        // 모든 숫자 조각을 하나씩 선택해본다
        for (int i = 0; i < numbers.length(); i++) {

            // 이미 사용한 숫자라면 건너뛴다
            if (visited[i]) continue;

            // 숫자 조각 사용 표시
            visited[i] = true;

            // 현재 숫자 뒤에 numbers.charAt(i)를 붙여서 다음 단계로 이동
            dfs(current + numbers.charAt(i), numbers);

            // 사용했던 숫자 조각을 다시 사용 가능하도록 되돌림 (백트래킹)
            visited[i] = false;
        }
    }

    /**
     * 소수 판별 함수
     *
     * @param n 검사할 숫자
     * @return 소수면 true, 아니면 false
     */
    private boolean isPrime(int n) {

        // 0과 1은 소수가 아님
        if (n < 2) return false;

        // 2부터 n의 제곱근까지 나눠서 검사
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false; // 나누어 떨어지면 소수 아님
            }
        }

        return true; // 끝까지 나누어 떨어지지 않으면 소수
    }
}