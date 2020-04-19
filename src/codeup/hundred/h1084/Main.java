package codeup.hundred.h1084;


import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;
	
	// println 함수의 처리 속도가 너무 느려서 시간초과가 나옴.
	// BufferedWriter 활용해서 연산 속도를 늘렸음.
	// 두번째 for문에서 출력시킨 이유는, bf.flush 생략 시 세번째 for문에서 출력이 버퍼가 다 안차서 출력이 안되고,
	// bf.flush를 넣으면 역시 시간초과..
	// 그래서 둘 모두 해결하기 위해 타협.
	public class Main {
	
		public static void main(String[] args) throws IOException {
			Scanner sc = new Scanner(System.in);
			int r = sc.nextInt();				
			int g = sc.nextInt();				
			int b = sc.nextInt();				
			
			BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(System.out));
			for(int i=0; i<r; i++) {
				for(int j=0; j<g; j++) {
					String str="";
					for(int k=0; k<b;k++) {
						str += i+" "+j+" "+k+"\n";						
					}
					bf.write(str);
					bf.flush();
				}
			}
			System.out.println(r*g*b);
		}
}
