package test_181123;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Loc {
	
	int x, y, w;
	
	public Loc(int x, int y, int w) {
		this.x=x;
		this.y=y;
		this.w=w;
	}
}

//매분마다 영역별로 물이 차오르고 바위가 존재할 때 고슴도치가 친구인 비버의 소굴로  탈출하는데 걸리는 시간 구하기(BFS 탐색)
public class B_3055 {

	static char [][] map;
	//상하좌우 이동 가능(고슴도치 및 물)
	static int [][] move = {{1,0},{-1,0},{0,1},{0,-1},
			{1,-1},{1,1},{-1,-1},{-1,1}};
	static boolean [][] visited;
	static int [][] dp;
	//비버의 소굴로 이동하는데 걸리는 시간(한칸 이동에 +1)
	static int cnt;
	//도착 지점
	static int x_des;
	static int y_des;
	//고슴도치와 물의 시작 지점을 담고 있는 배열
	static ArrayList<Loc> pos = new ArrayList<>();
	static int r;
	static int c;
	
	public static void bfs(ArrayList pos) {
		Queue<Loc> q = new LinkedList<>();
		for(int i=0;i<pos.size();i++) {
			q.add((Loc)pos.get(i));
		}
		
		while(!q.isEmpty()) {
			Loc l = q.poll();
			
			//고슴도치의 이동이면
			boolean flag = false;
			if(l.w==0) {
				flag = true;
			}
			
			for(int i=0;i<4;i++) {
				int nextx = l.x+move[i][0];
				int nexty = l.y+move[i][1];
				int w = l.w;
				
				//인접 지점이 영역 밖일 경우
				if(nextx<0||nexty<0||nextx>=r||nexty>=c) {
					continue;
				}
				//고슴도치의 이동경로인 경우
				if(w==0) {
					//물이 차지 않았고, 바위가 아니고, 방문한 지점이 아닐 경우
					//이동 칸수 증가+1
					if(!visited[nextx][nexty]) {
						System.out.println(nextx+","+nexty);
						q.add(new Loc(nextx, nexty, w));
						visited[nextx][nexty]=true;
						dp[nextx][nexty]=dp[l.x][l.y]+1;
						flag = false;
						if(nextx==x_des&&nexty==y_des) {
							System.out.println(dp[nextx][nexty]);
							System.exit(0);
						}
					}
				}
				//물의 이동경로인 경우
				else {
					if(!visited[nextx][nexty]&&map[nextx][nexty]!='D') {
						q.add(new Loc(nextx, nexty, w));
						visited[nextx][nexty]=true;
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		r = sc.nextInt();
		c = sc.nextInt();

		if(1<=r&&r<=50&&1<=c&&c<=50) {
			map = new char[r][c];
			visited = new boolean [r][c];
			dp = new int [r][c];
			int tmp1 = 0;
			int tmp2 = 0;
			//물이 찬 지점, 돌이 있는 지점, 출발지, 도착지 입력
			for(int i=0;i<r;i++) {
				String str = sc.next();
				for(int j=0;j<c;j++) {
					map[i][j]=str.charAt(j);
					if(str.charAt(j)=='S') {
						//고슴도치의 시작 지점
						tmp1 = i;
						tmp2 = j;
						visited[i][j]=true;
					}
					if(str.charAt(j)=='*') {
						//물의 시작 지점
						visited[i][j]=true;
						pos.add(new Loc(i, j, 1));
					}
					if(str.charAt(j)=='X') {
						//바위이면 탐색 불가
						visited[i][j]=true;
					}
					if(str.charAt(j)=='D') {
						//최종 도착 지점
						x_des = i;
						y_des = j;
					}
				}
			}
			//시작 지점은 제일 마지막 탐색 지점으로 저장
			pos.add(new Loc(tmp1, tmp2, 0));
			//탐색 시작
			bfs(pos);
			System.out.println("KAKTUS");
		}
	}
}
