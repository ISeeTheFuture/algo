package baekjoon.greedy.bj2875.mh;

import java.util.*;

public class Main {
  static int n;
  static int m;
  static int k;
	
	
	public static void main(String[] args)   {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
	    k = sc.nextInt();
	
	    //여학생의 수가 짝수가 아니면 의미가 없다. 홀수라면 한 명을 인턴 보내기
	    if(n % 2 == 1){ 
	      n -= 1;
	      k--;
	    }
	    
	    //잉여 남학생이 있어 짝이 맞지 않으면 짝이 맞을 때까지 남학생 인턴 보내기
	    while(m*2 > n && k > 0){
	      m -= 1;
	      k--;
	    }
	    
	    //잉여 여학생이 있어 짝이 맞지 않으면 짝이 맞을 때까지 여학생 인턴 보내기
	    while(m*2 < n && k > 0){
	      n -= 1;
	      k--;
	    }
	   
	    //남은 인턴자 수에서 3을 나눈 몫만큼 대회에 나갈 팀이 줄어든다.
	    m -= k / 3;
	    
	    //3을 나눈 나머지만큼 여학생을 인턴보낸다.
	    if(k%3 > 0) m--;
	
		while(true) { // k를 전부 감했음에도 남자 인원이 남는다면, 여자 인원에 맞춰 남자 인원을 감해준다.
			if(n>=m *2) break;
			else m -= 1;
		}
	    
	    System.out.println(m);
    
		
	}
	
}