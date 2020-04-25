package baekjoon.dynamic.bj1003;


import java.util.Scanner;

public class Main {
	
	static Scanner sc = new Scanner(System.in);
	static int[] ipt;
	static int[] arr = new int[41];// 0~40 까지 길이 41;
	
	
	public static void main(String[] args) {
		
		int n = sc.nextInt();
		ipt = new int[n];
	// 입력부
		for(int i = 0; i < n; i++) {
			ipt[i] = sc.nextInt();
		}
		
		// dp 테스트케이스
		arr[0] = 0;
		arr[1] = 1;
		arr[2] = 1;
		arr[3] = 2;
		for(int i = 4; i < arr.length; i++) {
			arr[i] = arr[i-1] + arr[i-2];
		}
		
		
	// 출력부
		for(int i = 0; i < ipt.length; i++) {
			if(ipt[i]==0) { // dp로 해결안되는 예외적인 상황
				System.out.println(1+" "+arr[ipt[i]]);
			}
			else{
				System.out.println(arr[ipt[i]-1]+" "+arr[ipt[i]]);
			}
		}
	}
}
