package solution;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//2차원 배열의 각 위치를 표시할 클래스
class Loc {
	int x, y;
	
	public Loc(int x, int y) {
		this.x=x;
		this.y=y;
	}
}

//방사능 오염 물질을 특정 지점에 퍼트릴 때, 저글링들이 죽는 시간과 죽지 않고 남아 있는 저글링들의 수 구하기
public class Q66 {

	static int r;
	static int c;
	static int [][] map;
	//저글링이 감염되는 속도
	static int [][] dp;
	static int max = Integer.MIN_VALUE;
	static boolean [][] visited;
	//방사능은 상하좌우 이동 가능
	static int [][] move = {{1,0},{-1,0},{0,1},{0,-1}}; 
	
	public static void bfs(int x, int y) {
		Queue<Loc> q = new LinkedList<>();
		q.add(new Loc(x, y));
		
		//탐색할 지점이 남아 있으면
		while(!q.isEmpty()) {
			Loc l = q.poll();
			
			for(int i=0;i<4;i++) {
				int nx = l.x+move[i][1];
				int ny = l.y+move[i][0];
				//다음 탐색 지점이 영역을 벗어나면
				if(nx<0||ny<0||nx>=r||ny>=c) {
					continue;
				}
				//인접한 지점에 저글링이 있으면
				if(!visited[nx][ny]&&map[nx][ny]==1) {
					visited[nx][ny]=true;
					map[nx][ny]=0;
					//감염되는 속도
					dp[nx][ny]=dp[l.x][l.y]+1;
					//마지막 저글링이 감염될 때까지 걸리는 시간 갱신
					if(dp[nx][ny]>=max) {
						max=dp[nx][ny];
					}
					q.add(new Loc(nx, ny));
				}
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		c = sc.nextInt();
		r = sc.nextInt();
		
		if(1<=r&&r<=100&&1<=c&&c<=100) {
			map = new int[r][c];
			dp = new int[r][c];
			visited = new boolean[r][c];
			
			//0 혹은 1(저글링이 있는 위치) 입력
			for(int i=0;i<r;i++) {
				//입력 시 각 숫자를 따로 입력하는 것이 아닌, 한줄의 문자열로 입력
				String str = sc.next();
				for(int j=0;j<c;j++) {
					map[i][j]=str.charAt(j)-'0';
				}
			}
			//방사능이 투하되는 지점
			int x_des = sc.nextInt();
			int y_des = sc.nextInt();
			
			//BFS 탐색 시작
			bfs(y_des-1,x_des-1);
			//죽지 않고 남아있는 저글링 수
			int left = 0;
			
			for(int i=0;i<r;i++) {
				for(int j=0;j<c;j++) {
					if(map[i][j]==1) {
						left++;
					}
				}
			}
			System.out.println(max+3);
			System.out.println(left);
		}
	}
}
