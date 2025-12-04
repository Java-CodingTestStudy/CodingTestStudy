package 배열;

import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		double[] arr = new double[n];
		double m = 0;
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
			if (m < arr[i]) {
				m = arr[i];
			}
		}

		for (int i = 0; i < n; i++) {
			arr[i] = (arr[i] / m) * 100;
		}
		double avg = 0;
		for (int i = 0; i < n; i++) {
			avg += arr[i];
		}
		avg /= n;

		System.out.println(avg);

	}
}
