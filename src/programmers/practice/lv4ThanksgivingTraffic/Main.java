package programmers.practice.lv4ThanksgivingTraffic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

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

	public static int solution(String[] lines) throws NumberFormatException, ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		long [][] arr = new long[lines.length][2];
		
		for(int i = 0; i < lines.length; i++) {
			String tmp = lines[i].substring(0, 23);
			String tmpSec = lines[i].substring(24).replace("s","").replace(".", "");
			
			if(tmpSec.length()==1) tmpSec += "000";
			else if(tmpSec.length()==2) tmpSec += "00";
			else if(tmpSec.length()==3) tmpSec += "0";
			
			int tmp2 = Integer.parseInt(tmpSec);
			arr[i][1] = sdf.parse(tmp).getTime();
			arr[i][0] = arr[i][1]-tmp2+1;
//			System.out.println(i);
//			System.out.println(arr[i][0]);			
//			System.out.println(sdf.format(new Date(arr[i][0])));			
//			System.out.println(arr[i][1]);
//			System.out.println(sdf.format(new Date(arr[i][1])));
//			System.out.println(tmp2);
		}
		int ans = 0;
		for(int i = 0; i < arr.length; i++) {
			int cnt = 0;
			long refStTime = arr[i][1];
			long refEdTime = arr[i][1]+999;
			
//			System.out.println("회차 : "+i);
//			System.out.println(sdf.format(new Date(arr[i][0])));
//			System.out.println(sdf.format(new Date(arr[i][1])));
//			System.out.println(sdf.format(new Date(arr[i][1]+999)));
			
			for(int j = 0; j < arr.length; j++) {
				long StTime = arr[j][0];
				long EdTime = arr[j][1];
				
				if(StTime>=refStTime&&StTime<=refEdTime) { // 기준시각 <= 시작시작 <= 기준시각+1
//					System.out.println("1형 : "+j);
//					System.out.println(sdf.format(new Date(StTime)));
					cnt++;
				} else if(EdTime>=refStTime&&EdTime<=refEdTime) { // 기준시각 <= 종료시각 <= 기준시각+1
//					System.out.println("2형 : "+j);
//					System.out.println(sdf.format(new Date(EdTime)));
					cnt++;
				} else if(StTime>=refStTime&&EdTime<=refEdTime) { // 기준시각 <= 시작시각 <= 종료시간 <= 기준시각+1
//					System.out.println("3형 : "+j);
//					System.out.println(sdf.format(new Date(StTime)));
//					System.out.println(sdf.format(new Date(EdTime)));
					cnt++;
				} else if(StTime<=refStTime&&EdTime>=refEdTime) { // 시작시각 <= 기준시각 <= 기준시각+1 <= 종료시각
//					System.out.println("4형 : "+j);
//					System.out.println(sdf.format(new Date(StTime)));
//					System.out.println(sdf.format(new Date(EdTime)));
					cnt++;
				}
			}

//			System.out.println(cnt);
//			System.out.println();
			ans = Math.max(ans, cnt);
		}
		
		return ans;
	}
}