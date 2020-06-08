package baekjoon.biSearch.bj10815;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		// 입력부
		int arrLength = sc.nextInt();
		int[] arr = new int[arrLength];
		
		for(int i = 0; i < arrLength; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		int lV = 0;
		int rV = arr.length-1;
		int mid = (lV+rV)/2;
		
		
		int trying = sc.nextInt(); 
		int[] ans = new int[trying];
		
		// 연산부
		for(int i = 0; i < trying; i++) {
			int tmp = sc.nextInt();
			ans[i] = biSrch(tmp, lV, rV, mid, arr);
		}
		
		// 출력부
		for(int i = 0; i < ans.length; i++) {
			System.out.print(ans[i]+" ");
		}
		
	}

	public static int biSrch(int val, int lV, int rV, int mid, int[] arr) {
		
		while(lV <= rV) {
			if(val > arr[mid]) {
				lV = mid+1;
				mid = (lV+rV)/2;
			} else if(val < arr[mid]) {
				rV = mid-1;
				mid = (lV+rV)/2;
			} else if(val == arr[mid]) {
				return 1;
			}
		}
		return 0;
	}
}