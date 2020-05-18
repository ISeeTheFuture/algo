package programmers.sort.lv1KNumber;

import java.util.Arrays;

public class Main {

	public static void main(String[] args){
		int[] array= {1,5,2,6,3,7,4};
		int[][] commands= {{2,5,3},{4,4,1},{1,7,3}};
		
		System.out.println(solution(array, commands));
	}
	
	public static int[] solution(int[] array, int[][] commands) {
		int[] ans = new int[commands.length];
		
		for(int a = 0; a < commands.length; a++) {
			int i = commands[a][0];
			int j = commands[a][1];
			int k = commands[a][2];
			int[] tmp = new int[j-i+1];
			int tmpIdx = 0;
			for(int b = i-1; b < j; b++) {
				tmp[tmpIdx++] = array[b];
			}
			Arrays.sort(tmp);
			ans[a] = tmp[k-1];
		}
		
		return ans;
	}
}