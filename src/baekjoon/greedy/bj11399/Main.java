package baekjoon.greedy.bj11399;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		// 변수부
		int n = sc.nextInt(); // 인원 수 입력 받음.
		int[] p = new int[n]; 
		int tmpSum = 0; // 임시 합.
		int sum = 0; // 시간 총합.
		
		// 입력부
		for(int i = 0; i < n; i++) {
			p[i] = sc.nextInt(); // 각 사람당 소요 시간 입력 받음.
		}
		
		// 입력받은 소요시간을 정렬
		Arrays.sort(p);
		
		//연산부
		for(int i = 0; i < p.length; i++) {
			tmpSum += p[i]; // 임시 합. 첫번째 사람은 자기 자신만. 두번째 사람은 첫번째 사람 시간을 포함한 시간까지. 세번쨰는...
			sum += tmpSum; // tmpSum 을 더한 총합.
		}
		System.out.println(sum); // 제출할 답안.
	}

}
