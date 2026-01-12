package studycodingtest.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
    1일 상담 총 3일 돈 10
    5일 상담 총 2일 돈 15
    1일 상담 하면 2,3일  상담 X

    어짜피 6,7일 상담을 할 수가 없어

    가장 많은 돈을 버는 방법
    1,4,5일 => 45만원

    N+1 : 퇴사일
    N : 남은 일
    T[i] : 상담 시간
    P[i] : 상담 수익
    상담 종료 날 : i + T[i] -1

    조1
    상담 시간 < 퇴사일 => i + T[i] <= N + 1

    조2
        조 2-1
        오늘 상담 시작 X
        D[i] = D[i + 1]

        조 2-2
        오늘 상담시작해서 퇴사일 안에 종료
        D[i] = MAX(D[i+1], D[i+T[i]] + P[i])
        여기서 1일 짜리를 보고 비교를 해야 하나 생각 했는데 3일이 110 만원이고 45 합친게 100이라고 가정하면 전자를 고르는게 맞음. 이거때문에 에러가 났음


 */
public class BOJ_quit {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        // D[N+1] 접근해주기 위해서 N+2 사용
        int[] T = new int[N + 2];
        int[] P = new int[N + 2];
        int[] D = new int[N + 2];

        for(int i = 1; i < N + 1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }
        // 뒤에서부터 시작
        for(int i = N; i>= 1; i--){
            // 조1 - 1
            D[i] = D[i + 1];

            // 조2 - 2
            if (i + T[i] <= N + 1) {
                D[i] = Math.max(D[i], P[i] + D[i + T[i]]);
            }
        }
        System.out.println(D[1]);
    }
}
