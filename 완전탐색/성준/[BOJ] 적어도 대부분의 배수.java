package studycodingtest.Brute_ForceSerch;

import java.util.Scanner;

/*
    첫째 줄 다섯 개의 자연수

    대부분의 배수가 뭐지?? => 주어진 5개 수 중에서 최소 3개의 공배수인 수 중 가장 작은거를 말함(구글링)

    자연수 받고
    공배수 체크해서 3개 이상이면 그 수 답으로 넣으면 되는건가?
 */
public class BOJ_AlmostAllMultiples {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a = new int[5];
        // 5개 자연수를 받아.
        for(int i = 0; i < 5; i++){
            a[i] = sc.nextInt();
        }

        int x = 1;
        // 반복해서 나누면 0 이 되는지 체크
        while(true){
            int cnt = 0;
            for(int i =0; i < 5; i++){
                if(x % a[i] == 0){
                    cnt++;
                }
            }
            // 3개만 넘으면 멈춰
            if (cnt >= 3){
                System.out.println(x);
                break;
            }
            x++;
        }
    }
}
