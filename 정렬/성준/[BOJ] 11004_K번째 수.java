package studycodingtest.Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
진짜 Arrays.sort() 하고서
index 만 뽑으면 끝아닌가????
개꿀!
 */
public class BOJ_KCount {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 공백 기준 쪼개기
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N개, K번째
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        // 문자열 받고 -> 그거 수로 배열로 담고
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // 오름차순
        Arrays.sort(arr);
        System.out.println(arr[K-1]);
    }



    // ㄹㅇ 다시는 안쓴다. 뭔데 시간 초과가 나냐?
    // 허허 500만개 숫자 입력은 힘들다구요? ㅇㅋ 앞으로 안씀
/*    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        System.out.println(arr[K - 1]);
    }*/
}
