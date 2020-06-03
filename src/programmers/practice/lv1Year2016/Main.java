package programmers.practice.lv1Year2016;

public class Main {

	public static void main(String[] args){
		int a = 5;
		int b = 24;
		
		System.out.println(solution(a, b));
	}
	public static String solution(int a, int b) {
		// 윤년 조건
			// 1. 4로 나누어짐 => 윤년
			// 2. 근데 100으로 나누어짐 => 윤년X // 2100년 -> 윤년 X
			// 3. 근데 400으로 나누어짐 => 윤년 // 2000년 -> 윤년 O
		// 월 날짜는
			// 01,02,03,04,05,06,07,08,09,10,11,12
			// 31,28,31,30,31,30,31,31,30,31,30,31 로 윤년 제외 고정.
			// 31로 시작하고 7,8월은 둘 다 31일이란 것만 기억하면 됨.
		int[] dates = {31,29,31,30,31,30,31,31,30,31,30,31}; // 문제 조건 상 2016년 고정이고, 이 해는 윤년으로 2월 29일
		String[] days = {"FRI","SAT","SUN","MON","TUE","WED","THU"};
		int date = b-1; // 시작일은 0이므로 1 빼줌.
		for(int i = 0; i < a-1; i++) {
			date += dates[i];
		}
		return days[date%7];
	}
}