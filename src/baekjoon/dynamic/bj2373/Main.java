package baekjoon.dynamic.bj2373;

import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int result = 0;
		int[] fibo = new int[30];
		int cnt = 2;

		int n = sc.nextInt();
		int temp = n;

		fibo[0] = 1;
		fibo[1] = 2;
		for (int i = 2; i < 30; i++) {
			fibo[i] = fibo[i - 1] + fibo[i - 2];
//			 System.out.println("fibo"+i+" "+fibo[i]);
			cnt++;
//		    System.out.println(cnt);
			if (fibo[i - 1] + fibo[i - 2] > n) {
				break;
			}
		}
		for (int i = 0; i < cnt; i++) {
//			System.out.println("n = "+n);
//			System.out.println("fibo"+i+" "+fibo[i]);
			if (fibo[i] == n) {
				result = -1;
				break;
			} else {
				if (fibo[i] > temp) {
					if (i == 0)
						temp -= fibo[i];
					else
						temp -= fibo[i - 1];

					if (temp == 0) {
						if (i == 0)
							result = fibo[i];
						else
							result = fibo[i - 1];
						break;
					}
					i = -1;
				}
			}
		}
		System.out.println(result);
	}
}
