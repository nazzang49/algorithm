package test_181122;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//좌표로 활용할 클래스
class Pos {
	
	int x,y;
	public Pos(int x, int y) {
		this.x=x;
		this.y=y;
	}
}

//체스판의 나이트가 이동할 수 있는 경로가 주어질 때 현재 위치에서 목적지까지 이동하는 전체 칸수 구하기(BFS 탐색)
public class B_7562 {

	static int n;
	static ArrayList<Integer> answer = new ArrayList<>();
	static boolean [][] visited;
	static int [][] dp;
	//이동할 수 있는 범위는 8칸
	static int [][] move = 
		{{2,1},{2,-1},{-2,1},{-2,-1},{1,2},{1,-2},{-1,2},{-1,-2}};
	static int x_des;
	static int y_des;
	
	//인접 지역 탐색 FROM 현재 위치
	public static void bfs(int x, int y) {
		Queue<Pos> q = new LinkedList<>();
		q.add(new Pos(x, y));
		
		while(!q.isEmpty()) {
			Pos p = q.poll();
			
			if(p.x==x_des&&p.y==y_des) {
				answer.add(dp[p.x][p.y]);
				break;
			}
			
			for(int i=0;i<8;i++) {
				int nextx = p.x+move[i][0];
				int nexty = p.y+move[i][1];
				
				//다음 지점이 체스판을 벗어나는 지점일 경우
				if(nextx<0||nexty<0||nextx>=n||nexty>=n) {
					continue;
				}
				//다음 지점이 방문하지 않은 지점인 경우
				if(!visited[nextx][nexty]) {
					visited[nextx][nexty]=true;
					dp[nextx][nexty]=dp[p.x][p.y]+1;
					q.add(new Pos(nextx, nexty));
				}
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		//테스트 케이스 횟수
		int t = sc.nextInt();
		
		for(int i=0;i<t;i++) {
			n = sc.nextInt();
			if(4<=n&&n<=300) {
				visited = new boolean [n][n];
				dp = new int [n][n];
				//현재 위치
				int x1 = sc.nextInt();
				int y1 = sc.nextInt();
				//목적지
				x_des = sc.nextInt();
				y_des = sc.nextInt();
				bfs(x1,y1);
			}
		}
		for(int i=0;i<answer.size();i++) {
			System.out.println(answer.get(i));
		}
	}
}
