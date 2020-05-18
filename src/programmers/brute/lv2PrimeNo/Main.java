package programmers.brute.lv2PrimeNo;

import java.util.Map;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args){
//		String numbers = "17";
//		String numbers = "011";
		String numbers = "7843";
		System.out.println(solution(numbers));
	}
	
	static Map map = new TreeMap<Integer, Integer>();
	static boolean[] visited;
	
	public static int solution(String numbers) {
		char[] nos = new char[numbers.length()];
		visited = new boolean[numbers.length()];
		
		for(int i = 0; i < numbers.length(); i++) {
			nos[i] = numbers.charAt(i);
		}
		
		for(int i = 1; i <= numbers.length(); i++) {
			brute(nos, i, "");
//			System.out.println("몇번?"+i);
		}
		
		return map.size();
	}
	public static void brute(char[] nos, int k, String str) {
		if(str.length()==k) {
			int tmp = Integer.parseInt(str);
			boolean isPrime = true;
			for(int i = 2; i < tmp; i++) { // 소수찾기 알고리즘
				if(tmp % i == 0) {
					isPrime = false;
					break;
				}
			}
			if(isPrime&&tmp!=1&&tmp!=0) {
				map.put(Integer.parseInt(str), 0);	
//				System.out.println("뭘 넣나 확인"+tmp);
			}
			return;
		}
		for(int i = 0; i < nos.length; i++) {
			if(visited[i]==false) {
				visited[i] = true;
				String tmp = str;
				str+=nos[i];
				brute(nos, k, str);
				visited[i] = false;
				str = tmp;
			}
		}
	}
}