package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

/*
    2^63 이면 무조건 br 쓰고 st 쓰라는거고
    나머지는 그냥 gcd 쓰라는건데??
    아니 왜 백준은 전부다 문제설명이 짧냐 화가 나네
    하 ㄹㅇ 간단한거처럼 보이고 의선이가 말해준 gcd 말고 감이 안오는데
    111 1111 => 1
    111 111111 => 111

    허허 메모리 초과는 진짜 처음 보는건데 => 스택 오버플로우인데
    1. 너무 많은 변수들을 배열에 저장할 경우
    2. DFS 등에서 재귀적 호출을 통해 너무 많은 함수들을 호출한 경우
    일단 둘 둥 나는 뭐해 해당하는지 모르겟음.....ㅠ
 */
public class BOJ_GreatestCmmonDivisor  {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 일단 수를 받고
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        // a 1로 채워
        StringBuilder sbA = new StringBuilder();
        for (int i = 0; i < a; i++) {
            sbA.append('1');
        }

        // b 1로 채워
        StringBuilder sbB = new StringBuilder();
        for (int i = 0; i < b; i++) {
            sbB.append('1');
        }

        // 값을 받아주고
        BigInteger A = new BigInteger(sbA.toString());
        BigInteger B = new BigInteger(sbB.toString());

        // gcd 로 최대 공약수
        BigInteger gcd = A.gcd(B);
        System.out.println(gcd.toString());
    }
}
