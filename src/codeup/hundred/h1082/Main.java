package codeup.hundred.h1082;


	import java.util.Scanner;
	
	public class Main {
	
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			String n = sc.next();				
			

			for(int i = 1; i < 16; i++) {
				String j = Integer.toHexString(i);
				String k = Integer.toHexString(Integer.valueOf(n, 16)*i);
				System.out.printf("%S*%S=%S%n",n, j,k);
			}
		}
}
