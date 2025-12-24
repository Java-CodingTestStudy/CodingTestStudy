import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
// 이때 StringTokenizer를 쓰기
		// 이게 브론즈 ..? 난 브론즈보다 못한 존재 ?
		BufferedReader sb = new BufferedReader(new InputStreamReader(System.in));

		// 작아도 세개로 나누어지는 가장 작은 자연수 : 최소 공배수...?

		StringTokenizer st = new StringTokenizer(sb.readLine());
		// sb.readLine: 한줄 입력
		// sb.nextToken => 토큰 하나씩 소모
		int[] arr = new int[5];
		for (int i = 0; i < 5; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int answer = 1;
		int cnt;
		while (true) {
			cnt = 0;
			for (int i = 0; i < 5; i++) {// 다섯개의 숫자
				// int a= Integer.parseInt(st.nextToken());
				if (answer % arr[i] == 0)
					cnt += 1; // 나누어지면 cnt ++
			}

			if (cnt >= 3) {// 적어도 3개로 나누어지면
				System.out.println(answer);
				break;
			}

			answer += 1; // 늘리기
		}
	}
}