package baekjoon.dynamic.bj1003.failed;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {

	static BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static Scanner sc = new Scanner(System.in);
	static int cnt0 = 0;
	static int cnt1 = 0;
	
	public static void main(String[] args) throws IOException {
		
		int n = sc.nextInt();
		String str = "";
		for(int i = 0; i < n; i++) {
			fibonacci(sc.nextInt());
			str += cnt0+" "+cnt1+"\n";
			cnt0 = 0;
			cnt1 = 0;
		}
		bf.write(str);
		bf.flush();
	}

	public static int fibonacci(int n) {
		if (n == 0) {
//			System.out.println("0");
			cnt0++;
			return 0;
		} else if(n == 1) {
//			System.out.println("1");
			cnt1++;
			return 1;
		} else {
			return fibonacci(n-1) + fibonacci(n-2);			
		}
	}
}
