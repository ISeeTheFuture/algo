package programmers.practice.lv4ThanksgivingTraffic;

import java.text.ParseException;

public class Main2 {

	public static void main(String[] args) throws NumberFormatException, ParseException{
		String[] lines = {"2016-09-15 20:59:57.421 0.351s",
				"2016-09-15 20:59:58.233 1.181s",
				"2016-09-15 20:59:58.299 0.8s",
				"2016-09-15 20:59:58.688 1.041s",
				"2016-09-15 20:59:59.591 1.412s",
				"2016-09-15 21:00:00.464 1.466s",
				"2016-09-15 21:00:00.741 1.581s",
				"2016-09-15 21:00:00.748 2.31s",
				"2016-09-15 21:00:00.966 0.381s",
				"2016-09-15 21:00:02.066 2.62s"}; // 이거 답 7
		
		System.out.println(solution(lines));
	}

	public static int solution(String[] lines) {
		int answer = 0;
		int[] startTimes = new int[lines.length];
		int[] endTimes = new int[lines.length];
		
		getTimes(lines, startTimes, endTimes);
		
		for(int i = 0 ; i < lines.length ; ++i) {
			int cnt = 0;
			int startOfParts = startTimes[i];
			int endOfParts = startOfParts + 1000;
			
			for(int j = 0 ; j < lines.length ; ++j) {
				if(startTimes[j] >= startOfParts && startTimes[j] < endOfParts) {
					cnt++;
				} else if(endTimes[j] >= startOfParts && endTimes[j] < endOfParts) {
					cnt++;
				} else if(startTimes[j] <= startOfParts && endTimes[j] >= endOfParts) {
					cnt++;
				}
			}

			answer = Math.max(answer, cnt);
		}
		
		for(int i = 0 ; i < lines.length ; ++i) {
			int cnt = 0;
			int startOfParts = endTimes[i];
			int endOfParts = startOfParts + 1000;
			
			for(int j = 0 ; j < lines.length ; ++j) {
				if(startTimes[j] >= startOfParts && startTimes[j] < endOfParts) {
					cnt++;
				} else if(endTimes[j] >= startOfParts && endTimes[j] < endOfParts) {
					cnt++;
				} else if(startTimes[j] <= startOfParts && endTimes[j] >= endOfParts) {
					cnt++;
				}
			}

			answer = Math.max(answer, cnt);
		}
		
		return answer;
	}
	
	public static void getTimes(String[] lines, int[] startTimes, int[] endTimes) {
		for(int i = 0 ; i < lines.length ; ++i) {
			String[] log = lines[i].split(" ");
			String[] responseTime = log[1].split(":");
			int processTime = (int)(Double.parseDouble(log[2].substring(0, log[2].length() - 1)) * 1000);
			int startTime = 0;
			int endTime = 0;
			
			endTime += Integer.parseInt(responseTime[0]) * 60 * 60 * 1000;
			endTime += Integer.parseInt(responseTime[1]) * 60 * 1000;
			endTime += (int)(Double.parseDouble(responseTime[2]) * 1000);
			startTime = endTime - processTime + 1;
			
			startTimes[i] = startTime;
			endTimes[i] = endTime;
		}
	}
}