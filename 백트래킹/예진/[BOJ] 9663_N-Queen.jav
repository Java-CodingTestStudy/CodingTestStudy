/**
 * 백트래킹: 완전탐색 하되, 더 이상 답이 될 수 없는 경우는 가지치기(되돌아감)
 * 
 * 동작
 * - 트리탐색
 * - 1. 하나 선택한다
 * - 2. 조건 검사한다
 * - 3. 조간 위반 시 즉시 되돌아간다
 * - 4. 가능하면 다음 단계로 진행한다
 * - 위 과정을 DFS로 반복한다
 * 
 * 기본 구조
 * void backtrack(상태) {
        if (종료 조건) {
            답 처리;
            return;
        }

        for (선택 가능한 경우) {
            선택;
            if (조건 만족) {
                backtrack(다음 상태);
            }
            선택 취소; // 되돌리기
        }
    }
 * 
 * 완전탐색인데 조건을 만족하는 경우의 수, 조합 순열 등은 백트래킹을 떠올린다
 * 
 */

package java9663;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = Integer.parseInt(sc.nextLine());
        int count = 0;
        int[] board = new int[N];

        int answer = backtrack(board, N, count);

        System.out.println(answer);
    }

    private static int backtrack(int[] board, int n, int row) {

        // 모두 둔 경우
        if (n == row) {
            return 1;
        }

        int count = 0;

        // 한 행에 퀸은 하나만 둔다 -> 열과 대각선만 검사
        for (int col = 0; col < n; col++) {
            board[row] = col;

            if (isAvailable(board, row)) {
                count += backtrack(board, n, row + 1);
            }
        }

        return count;

    }

    private static boolean isAvailable(int[] board, int row) {
        for (int i = 0; i < row; i++) {
            if (board[row] == board[i]) {
                return false;
            }

            if (Math.abs(board[row] - board[i]) == row - i) {
                return false;
            }
        }

        return true;
    }

}
