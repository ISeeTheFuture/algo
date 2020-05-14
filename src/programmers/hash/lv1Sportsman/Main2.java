package programmers.hash.lv1Sportsman;

import java.util.Arrays;

public class Main2 {

	public static void main(String[] args){
		String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
		String[] completion = {"josipa", "filipa", "marina", "nikola"};
		System.out.println(solution(participant, completion));
	}
	public static String solution(String[] participant, String[] completion) {
		
		Arrays.sort(participant);
		Arrays.sort(completion);
		
		String ans = "";
		for(int i = 0; i < participant.length; i++) {
			if(i == participant.length - 1) {
				ans = participant[i];
				break;  
			}
			else if(!participant[i].equals(completion[i])) {
				ans = participant[i];
				break;
			}
		}
				
		return ans;
	}

}