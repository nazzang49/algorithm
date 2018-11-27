package test_181127;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Position {
	int x, y;
	
	public Position(int x, int y) {
		this.x=x;
		this.y=y;
	}
}

//1로 형성된 영역별 단지 개수와 단지 내 가구 수 구하기
public class B_2667 {
	
	static int n;
	static char [][] map;
	static boolean [][] visited;
	//상하좌우 이동 가능
	static int [][] move = {{1,0},{-1,0},{0,1},{0,-1}};
	//단지 수
	static int cnt;
	//단지별 가구 수
	static int area;
	static ArrayList<Integer> answer = new ArrayList<>();

	public static void bfs(int x, int y) {
		Queue<Position> q = new LinkedList<>();
		q.add(new Position(x, y));
		
		while(!q.isEmpty()) {
			Position p = q.poll();
			
			for(int i=0;i<4;i++) {
				int nextx = p.x+move[i][0];
				int nexty = p.y+move[i][1];
				//다음 지점이 영역 밖이면
				if(nextx<0||nexty<0||nextx>=n||nexty>=n) continue;
				//다음 지점이 방문하지 않은 가구라면
				if(map[nextx][nexty]=='1'&&!visited[nextx][nexty]) {
					visited[nextx][nexty]=true;
					q.add(new Position(nextx, nexty));
					area++;
				}
			}
			//하나의 단지가 형성되면
			if(q.isEmpty()) {
				answer.add(area);
				area=0;
				cnt++;
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		if(5<=n&&n<=25) {
			visited = new boolean[n][n];
			map = new char[n][n];
			for(int i=0;i<map.length;i++) {
				String str = sc.next();
				for(int j=0;j<map[i].length;j++) {
					//0은 비가구, 1은 가구
					map[i][j]=str.charAt(j);
				}
			}
			for(int i=0;i<map.length;i++) {
				for(int j=0;j<map[i].length;j++) {
					if(!visited[i][j]&&map[i][j]=='1') {
						bfs(i,j);
					}
				}
			}
			//단지 수 출력
			System.out.println(cnt);
			//단지 별 가구 수 오름차순 정렬 후 출력
			for(int i=0;i<answer.size()-1;i++) {
				for(int j=i+1;j<answer.size();j++) {
					if(answer.get(i)>answer.get(j)) {
						int tmp = answer.get(i);
						answer.set(i, answer.get(j));
						answer.set(j, tmp);
					}
				}
			}
			//최종 단지별 가구 수 출력
			for(int i=0;i<answer.size();i++) {
				System.out.println(answer.get(i));
			}
		}
	}
}
