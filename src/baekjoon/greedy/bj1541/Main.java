package baekjoon.greedy.bj1541;

import java.util.Scanner;

public class Main {

	// 무조건 - 직후에 "("
		// 그 다음 - 앞에 ")"로 닫고 다시 - 직후 "("
		// 만일 더이상 -가 없다면 마지막에 ")"
	// 방법
		// "-"를 기준으로 스트링을 split
			// 쪼개진 작은 수식들을 합연산 해주고,
			// 이 합연된 된 수식을 모아 빼준다.
	
	
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		String ipt = sc.next(); // 최초 공식 입력
		String[] list = ipt.split("-"); // "-" 를 기준으로 split한 수식 String
		int[] listTmp = new int[list.length]; // "-" 기준으로 split한 String에 임시합으로 사용할 숫자 변수
		int opt = 0; // 답으로 쓸 변수
		
		if(list.length > 1) { // 혹시나 "-" 없이 문제가 나올 수도 있으므로
			for(int i = 0; i < list.length; i++) {
				String[] tmp = list[i].split("\\+"); // "+"를 기준으로 split한 수식 String
				for(int j = 0; j <tmp.length; j++) {
					listTmp[i] += Integer.parseInt(tmp[j]);
				}
			}
			opt = listTmp[0];
			for(int i = 1; i < list.length; i++) {
				opt = opt - listTmp[i];
			}
		}
		else {// 혹시 "-" 가 아예 없을 경우
			String[] tmp = list[0].split("\\+");
			for(int i = 0; i < tmp.length; i++) {
				opt += Integer.parseInt(tmp[i]);
			}
		}
		
		System.out.println(opt);
		
	}

}
