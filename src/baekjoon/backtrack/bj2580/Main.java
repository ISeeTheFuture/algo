package baekjoon.backtrack.bj2580;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
    static int[][] map;
    static LinkedList<int[]> list;

    public static void main(String[] args) {
    	// 입력부
        map = new int[9][9];
        list = new LinkedList<>();
        
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 0) {
                    list.add(new int[] {i, j}); // 0인 좌표 저장
                }
            }
        }
        sudoku(0);
    }

    private static void sudoku(int level) {
        if (level == list.size()) { // 0 전부 채웠다면
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(map[i][j]).append(" ");
                }
                sb.append("\n");
            }
            sb.append("\n");

            System.out.println(sb);
            System.exit(0); // Main 종료. 답 맞으면 바로 종료하라고 했으니께
        }

        int x = list.get(level)[0];
        int y = list.get(level)[1];

        for (int i = 1; i <= 9; i++) {
            if (chk(x, y, i)) {
                map[x][y] = i; // 일단 0을 i로 바꾸고
                sudoku(level + 1); // 다음 레벨로
                map[x][y] = 0; // 동일 레벨에서는 0으로 써먹어야됨, 조건 초기화
            }
        }

    }

    private static boolean chk(int x, int y, int num) {
        if (map[x][y] != 0) return false; // 0이 아니면 채워야할 맵이 아니므로 바로 false

        for (int i = 0; i < 9; i++) { // 가로 세로 체크
            if (map[i][y] == num || map[x][i] == num) return false;
        }
        
        int sx = (x/3)*3;
        int sy = (y/3)*3;
        
        for (int i = sx; i < sx + 3; i++) {
            for (int j = sy; j < sy + 3; j++) { // 3*3 박스 체크
                if (map[i][j] == num) return false;
            }
        }

        return true;
    }

}