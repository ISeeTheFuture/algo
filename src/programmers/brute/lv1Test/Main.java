package programmers.brute.lv1Test;

public class Main {

	public static void main(String[] args){
		int[] answers = {1,2,3,4,5}; 
//		int[] answers = {1,3,2,4,2}; 

		System.out.println(solution(answers));
	}
	
	public static int[] solution(int[] answers) {
		// 1번 : 1 2 3 4 5 1 2 3...
		int[] no1 = {1,2,3,4,5}; // 길이 5
		int no1Cnt = 0;
		// 2번 : 2 1 2 3 2 4 2 5 2 1...
		int[] no2 = {2,1,2,3,2,4,2,5}; // 길이 8
		int no2Cnt = 0;
		// 3번 : 3 3 1 1 2 2 4 4 5 5 3 3 1 1...
		int[] no3 = {3,3,1,1,2,2,4,4,5,5}; // 길이 10
		int no3Cnt = 0;
		
		for(int i = 0; i < answers.length; i++) {
			
			if(answers[i]==no1[i%no1.length]) no1Cnt++;
			if(answers[i]==no2[i%no2.length]) no2Cnt++;
			if(answers[i]==no3[i%no3.length]) no3Cnt++;
		}
//		System.out.println(no1Cnt);
//		System.out.println(no2Cnt);
//		System.out.println(no3Cnt);
		
		// 출력부, 아니 왜 이게 더 어려워ㅡㅡ
		
		if(no1Cnt>no2Cnt&&no1Cnt>no3Cnt) {
			int[] ans = {1};
			return ans;
		} else if(no2Cnt>no1Cnt&&no2Cnt>no3Cnt) {
			int ans[] = {2};
			return ans;
		} else if(no3Cnt>no1Cnt&&no3Cnt>no2Cnt) {
			int ans[] = {3};
			return ans;
		} else if(no1Cnt==no2Cnt&&no1Cnt>no3Cnt) {
			int ans[] = {1,2};
			return ans;
		} else if(no1Cnt==no3Cnt&&no1Cnt>no2Cnt) {
			int ans[] = {1,3};
			return ans;
		} else if(no2Cnt==no3Cnt&&no2Cnt>no1Cnt) {
			int ans[] = {2,3};
			return ans;
		} else {
			int ans[] = {1,2,3};
			return ans;
		}
	}
}