package test_190220;

import java.util.Scanner;

//알파벳으로 이루어진 게임판이 주어질 때, 같은 알파벳을 한번 이상 지날 수 없다면 말이 건널 수 있는 최대 칸수 구하기
public class B_1987 {

	static int r;
	static int c;
	static char [][] map;
	//상하좌우 이동 가능
	static int [][] move = {{1,0},{-1,0},{0,1},{0,-1}};
	static int [] alpha = new int[26];
	static int max = 0;
	
	public static void dfs(int x, int y, int cnt) {
		for(int i=0;i<4;i++) {
			int nx = x+move[i][0];
			int ny = y+move[i][1];
			
			//다음 지점 = 영역 밖
			if(nx<=0||ny<=0||nx>r||ny>c) continue;
			
			//다음 지점 = 영역 내(방문 처리 + 알파벳 등장 처리)
			if(alpha[map[nx][ny]-'A']==0) {
				//현재 경로에서는 방문한 것으로 처리
				alpha[map[nx][ny]-'A']=1;
				dfs(nx,ny,cnt+1);
				//백트래킹(다음 경로에서 영향 받지 않도록)
				alpha[map[nx][ny]-'A']=0;
			}else {
				max=Math.max(max, cnt);
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		r = sc.nextInt();
		c = sc.nextInt();
		if(r<=20&&c<=20) {
			map = new char[r+1][c+1];
			//알파벳 입력
			for(int i=1;i<=r;i++) {
				String str = sc.next();
				for(int j=1;j<=c;j++) {
					map[i][j]=str.charAt(j-1);
				}
			}
			alpha[map[1][1]-'A']=1;
			//DFS 탐색
			dfs(1,1,1);
			System.out.println(max);
		}	
	}
}
