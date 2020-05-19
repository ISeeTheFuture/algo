package programmers.sort.lv2HIndex;

import java.util.Arrays;

public class Main {

	public static void main(String[] args){
//		int[] citations = {3, 0, 6, 1, 5}; //  0 1 3 5 6 // 3 
		int[] citations = {0, 1, 1, 1, 1, 3, 3, 4}; // 3 맞엉...
//		int[] citations = {5, 5, 5, 5}; // 4
		System.out.println(solution(citations));
	}
	
	public static int solution(int[] citations) {
		Arrays.sort(citations); // 0 1 3 5 6
								// 0 이상 : 0의 index가 0이므로, 길이 5 = 5 => H-idx = 0
								// 1이상 : 1의 index가 1이므로, 길이5 - 1 = 4 => H-idx = 1
								// 2이상 : 2의 index가 2이므로, 길이5 - 2 = 3 => H-idx = 2 
								// 3이상 : 3의 index가 2이므로, 길이5 - 2 = 3 => H-idx = 3
								// 4이상 : 4의 index가 3이므로, 길이5 - 3 = 2(2<4) => H-idx != 4 
		
		int ans = 0;
		int lastNo = citations[citations.length-1];
		
		for(int i = 0; i < citations.length; i++) {
			for(int j = 0; j  < lastNo; j++) {
				if(j <= citations[i]&&j <= citations.length-i) ans = Math.max(j, ans);
			}			
		}
		
		return ans;
	}
}