package programmers.greedy.lv2BiggestNo.fail;


public class Main {

	public static void main(String[] args){
		String number = "4177252841";
		int k = 4; // 10 - 4 = 6개는 무조건 남겨야
//		String number = "7090919098";
//		int k = 9; // 10 - 4 = 6개는 무조건 남겨야

		
		System.out.println(solution(number, k));
	}
	// 지정한 범위에서 최대값을 찾아 한 자리 한 자리 숫자를 만들어 내는 문제.
	public static String solution(String number, int k) {
		StringBuilder ans = new StringBuilder();
		
		// 일단 풀기 쉽게 int[] 로 만들자.
		// 입력부
		int[] nums = new int[number.length()];
		for(int i = 0; i < nums.length; i++) {
			nums[i] = Integer.parseInt(number.charAt(i)+"");
		}
		
		// 연산부
		int maxSt = 0;
		while(ans.length() < number.length()-k) {//ans가 number.length()-k 와 같아지면 탈출
			int maxNo = 0; // 
			int tmpNo = 0; // 
			int tmpSt = 0; // 
			for(int i = maxSt; i <= k+ans.length(); i++) {
				tmpNo = nums[i];
				if(tmpNo>maxNo) { // 최대값 구하는 건데, Math.max 못쓴 이유
					maxNo = tmpNo;
					tmpSt = i; // 얘때메
				}
				if(tmpSt==9) break;
			}
			maxSt = tmpSt+1;
			ans.append(maxNo);

		}
		
		return ans.toString();
	}
	
}