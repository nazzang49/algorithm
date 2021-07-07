package test_181124;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//늑대와 양, 울타리가 주어질 때 마당에서 탈출할 수 있는 양의 수와 남아있는 늑대의 수 구하기
//같은 영역에서 양의 수 > 늑대의 수일 때, 양이 살아 남음

class Location {
	int x,y;
	
	public Location(int x, int y) {
		this.x=x;
		this.y=y;
	}
}

public class B_3184 {

	static int r;
	static int c;
	//영역별 생존한 양의 수
	static int cnt1;
	//영역별 생존한 늑대 수
	static int cnt2;
	static char [][] map;
	static int [][] move = {{1,0},{-1,0},{0,1},{0,-1}};
	static boolean [][] visited;
	static int answer1 = 0;
	static int answer2 = 0;
	
	public static void bfs(int x, int y) {
		Queue<Location> q = new LinkedList<>();
		q.add(new Location(x, y));
		
		while(!q.isEmpty()) {
			Location l = q.poll();
			for(int i=0;i<4;i++) {
				int nextx = l.x+move[i][0];
				int nexty = l.y+move[i][1];
				
				//마당 밖이면 탐색 불가
				if(nextx<0||nexty<0||nextx>=r||nexty>=c) {
					continue;
				}
				//다음 지점이 양이면
				if(!visited[nextx][nexty]&&map[nextx][nexty]=='o') {
					cnt1++;
				}
				//다음 지점이 늑대면
				if(!visited[nextx][nexty]&&map[nextx][nexty]=='v') {
					cnt2++;
				}
				//다음 지점이 방문 안한 곳이면
				if(!visited[nextx][nexty]) {
					visited[nextx][nexty]=true;
					q.add(new Location(nextx, nexty));	
				}
			}
			//더 이상 탐색할 지점이 없으면 = 하나의 영역이 형성되면
			if(q.isEmpty()) {
				//해당 영역에서 양의 수가 늑대의 수보다 많으면(양 생존)
				if(cnt1>cnt2) {
					cnt2=0;
					answer1+=cnt1;
					cnt1=0;
				}
				//해당 영역에서 늑대의 수가 양의 수와 같거나 많으면(늑대 생존)
				else {
					cnt1=0;
					answer2+=cnt2;
					cnt2=0;
				}
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		r = sc.nextInt();
		c = sc.nextInt();
		
		if(3<=r&&r<=250&&3<=c&&c<=250) {
			map = new char [r][c];
			visited = new boolean [r][c];
			for(int i=0;i<map.length;i++) {
				String str = sc.next();
				for(int j=0;j<map[i].length;j++) {
					map[i][j]=str.charAt(j);
					//울타리로는 이동할 수 없도록 사전 조치
					if(str.charAt(j)=='#') {
						visited[i][j]=true;
					}
				}
			}
			for(int i=0;i<map.length;i++) {
				for(int j=0;j<map[i].length;j++) {
					//양이면
					if(!visited[i][j]&&map[i][j]=='o') {
						visited[i][j]=true;
						cnt1++;
						bfs(i,j);
					}
					//늑대면
					else if(!visited[i][j]&&map[i][j]=='v') {
						visited[i][j]=true;
						cnt2++;
						bfs(i,j);
					} 
				}
			}
			//양과 늑대의 남아 있는 마리 수
			System.out.println(answer1);
			System.out.println(answer2);
		}
	}
}
