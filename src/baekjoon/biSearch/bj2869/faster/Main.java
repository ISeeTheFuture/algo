package baekjoon.biSearch.bj2869.faster;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BufferedReader와 Token 쓰면 106ms => 76ms 로 빨라짐 
public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		double a = Double.parseDouble(st.nextToken());
		double b = Double.parseDouble(st.nextToken());
		double v = Double.parseDouble(st.nextToken());
		
		int ans = (int) Math.ceil((v-b)/(a-b));
		
		System.out.println(ans);
	}
}
