package test_181129;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import javax.print.attribute.standard.PDLOverrideSupported;

class Pos {
	int x, y, w;
	//w는 방향이며 정수로 인식(동1서2남3북4)
	public Pos(int x, int y, int w) {
		this.x=x;
		this.y=y;
		this.w=w;
	}
}

//로봇의 이동에 대한 명령이 직선 이동, 방향 전환 두가지일 때 주어진 지도에서 목적지까지 이동하는 최소 명령 횟수 구하기
public class B_1726 {

	static int r;
	static int c;
	static int x_des;
	static int y_des;
	static int w_des;
	//같은 방향으로 몇칸째 이동 중인지 확인할 변수(첫 직선 이동 때만 dp +1)
	static int cnt;
	static boolean [][] visited;
	//이동 + 회전 명령 횟수 저장할 배열
	static int [][] dp;
	//동서남북
	static int [][] move = {{1,0},{-1,0},{0,1},{0,-1}};
	
	//다른 방향으로 궤도 변경 or 직선 이동 시작 시점에만 dp 증가
	public static void bfs(int x, int y, int w) {
		Queue<Pos> q = new LinkedList<>();
		//시작 지점과 바라 보는 방향 저장
		q.add(new Pos(x, y, w));
		
		while(!q.isEmpty()) {
			Pos p = q.poll();
			
			//현재 위치가 도착 지점 and 바라보는 방향 일치 시
			if(p.x==x_des-1&&p.y==y_des-1) {
				if(p.w==w_des) {
					System.out.println(dp[p.x][p.y]);
				}else if(Math.abs(move[p.w][0]-move[w_des][0])==1){
					System.out.println(dp[p.x][p.y]+1);
				}else if(Math.abs(move[p.w][0]-move[w_des][0])==2){
					System.out.println(dp[p.x][p.y]+2);
				}
				System.exit(0);
			}
			
			for(int i=0;i<4;i++) {
				int nextx = p.x+move[i][1];
				int nexty = p.y+move[i][0];
				int dir = p.w;
				//다음 지점이 영역 밖이면
				if(nextx<0||nexty<0||nextx>=r||nexty>=c) {
					continue;
				}
				//회전 횟수
				int tmp = 0;
				if(dir!=i) {
					//90도 회전
					if(Math.abs(move[dir][0]-move[i][0])==1) {
						tmp=1;
					}
					//180도 회전
					else {
						tmp=2;
					}
				}
				//다음 지점이 방문하지 않은 지점이면
				if(!visited[nextx][nexty]) {
					dp[p.x][p.y]+=tmp;
					if(tmp==0) {
						dp[nextx][nexty]=dp[p.x][p.y];
					}else {
						dp[nextx][nexty]=dp[p.x][p.y]+1;
					}
					visited[nextx][nexty]=true;
					q.add(new Pos(nextx, nexty, i));
				}
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		r = sc.nextInt();
		c = sc.nextInt();
		
		if(1<=r&&r<=100&&1<=c&&c<=100) {
			dp = new int[r][c];
			visited = new boolean[r][c];
			for(int i=0;i<r;i++) {
				for(int j=0;j<c;j++) {
					int tmp = sc.nextInt();
					//1이면 미리 방문한 것으로 간주(이동할 수 없는 지점)
					if(tmp==1) {
						visited[i][j]=true;
					}
				}
			}
			//최초 시작 지점과 바라보는 방향
			int x = sc.nextInt();
			int y = sc.nextInt();
			int w = sc.nextInt();
			x_des = sc.nextInt();
			y_des = sc.nextInt();
			w_des = sc.nextInt();
			visited[x-1][y-1]=true;
			bfs(x-1,y-1,w-1);
		}	
	}
}
