package java14501;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// DP
// 시간복잡도 O(N)
public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 전체 날짜 수
        int N = Integer.parseInt(st.nextToken());

        // income[i] : i번째 날 얻을 수 있는 최대 수익
        // 실제로 i일까지 고려했을 때의 최대 수익
        int[] income = new int[N + 2];

        // T[i] : i번째 날에 시작하는 상담의 소요 기간
        // P[i] : i번째 날에 시작하는 상담의 수익
        int[] T = new int[N + 1];
        int[] P = new int[N + 1];

        // 상담 정보 입력받기
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            int pay = Integer.parseInt(st.nextToken());
            T[i] = time;
            P[i] = pay;
        }

        // 1일부터 N일까지 순차적으로 DP 진행
        for (int i = 1; i <= N; i++) {

            // i번째 날 상담 가능한 경우 - 퇴사일 전이어야함
            if (i + T[i] - 1 <= N) {
                // 상담이 끝난 다음날 수익 갱신
                income[i + T[i]] = Math.max(income[i + T[i]], income[i] + P[i]);
            }

            // i번째 날 상담을 선택하지 않는 경우, 다음 날로 현재 수익을 그대로 넘김
            income[i + 1] = Math.max(income[i + 1], income[i]);
        }

        System.out.println(income[N + 1]);

    }

}
