package programmers.greedy.lv2BiggestNo;

public class Main {

	public static void main(String[] args) {
		String number = "4177252841";
		int k = 4; // 10 - 4 = 6개는 무조건 남겨야

		System.out.println(solution(number, k));
	}

	// 지정한 범위에서 최대값을 찾아 한 자리 한 자리 숫자를 만들어 내는 문제.
	public static String solution(String number, int k) {
		int idx = 0;
		char max;
		StringBuilder answer = new StringBuilder();
		for (int i = 0; i < number.length() - k; i++) {
			max = '0';
			for (int j = idx; j <= k + i; j++) {
				if (max < number.charAt(j)) {
					max = number.charAt(j);
					idx = j + 1;
				}
			}
			answer.append(max);
		}
		return answer.toString();
	}

}