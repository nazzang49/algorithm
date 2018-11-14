package test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//미로 탐색 문제(BFS 탐색)
public class B_2206 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		int m = Integer.parseInt(sc.next());
		
		//방문여부
		boolean [][] visited = new boolean [n+1][m+1];
		//이동횟수
		int dist [][] = new int [n+1][m+1];
		//숫자맵
		int map [][] = new int[n+1][m+1];
		
		for(int i=1;i<map.length;i++) {
			for(int j=1;j<map[i].length;j++) {
				//0과 1 중 랜덤하게 숫자맵 형성
				map[i][j] = (int)Math.random()*2;
			}
		}
		
		//시작과 끝 값은 항상 0
		map[1][1] = map[n+1][m+1] = 0;
		
		if((1<=n&&n<=1000)&&(1<=m&&m<=1000)) {
			Queue<Integer> q = new LinkedList<>();
			
			while(!q.isEmpty()) {
				
			}
		}
	}
}
