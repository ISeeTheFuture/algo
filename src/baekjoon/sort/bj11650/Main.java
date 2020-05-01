package baekjoon.sort.bj11650;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);
	static int n;
	static List<Point> xy;
	
	public static void main(String[] args) {
		n = sc.nextInt();
		xy = new ArrayList<>();
		
		for(int i = 0; i < n; i ++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			xy.add(new Point(x,y));
		}
		
		PointSort ps = new PointSort(); // 클래스로 선언된 정렬 
		
		Collections.sort(xy, ps);
		
		
		for(int i = 0; i < xy.size(); i++) {
			System.out.print(xy.get(i).x+" "+xy.get(i).y);
			System.out.println();
		}
	}
 
}


// Comparable 과 Comparator
	//참고 : https://gmlwjd9405.github.io/2018/09/06/java-comparable-and-comparator.html
class PointSort implements Comparator<Point> {
	@Override
	public int compare(Point p1, Point p2) { // 
		if(p1.x > p2.x) { // 만약 p1.x가 p2.x보다 크다면
			return 1; // 1 => 자리 바꾼다
						// -1 => 자리 바꾸지 않는다.
		}
		// 1. x좌표를 기준으로 정렬
			// 1 2 1 => 1 1 2 
		else if(p1.x == p2.x) { // 만약 p1.x가 p2.x와 같다면
			if(p1.y > p2.y) { // y 비교
				return 1; // 바꿔
			}
			// 2. x좌표가 같을때는 y좌표를 기준으로 정렬
		}
		return -1; // 나머지 모든 경우 자리 바꾸지 않는다.
	}
	
	
}
