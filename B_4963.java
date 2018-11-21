package test_181121;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pos{
	
	int x,y;
	
	public Pos(int x, int y) {
		this.x=x;
		this.y=y;
	}
}

//바다에 둘러 쌓여있는 땅의 조건에 따라 섬의 개수 구하기(BFS 탐색)
public class B_4963 {

	static int n;
	static int m;
	static int [][] map;
	static boolean [][] visited;
	//각 테스트 케이스별 섬의 개수(케이스마다 초기화 필수)
	static int cnt;
	//가로, 세로, 대각선 이동
	static int [][] move = {{1,0},{-1,0},{0,1},{0,-1},
			{1,1},{1,-1},{-1,1},{-1,-1}};
	
	public static void bfs(int x, int y) {
		Queue<Pos> q = new LinkedList<>();
		q.add(new Pos(x, y));
		
		//탐색 지점이 없어질 때까지 탐색 반복
		while(!q.isEmpty()) {
			Pos p = q.poll();
			//인접 지점이 모두 바다가 되는 순간을 판명할 플래그 변수(cnt++)
			boolean flag = false;
			
			//해당 지점을 감싸고 있는 인접 지점 8군데 탐색
			for(int i=0;i<8;i++) {
				int nextx = p.x+move[i][0];
				int nexty = p.y+move[i][1];
				
				//지도 밖의 지점은 탐색 불가
				if(nextx<0||nexty<0||nextx>=m||nexty>=n) {
					continue;
				}
				//인접 지점이 0(바다)일 경우
				if(map[nextx][nexty]==0) {
					continue;
				}
				//가로 및 세로 인접 지점이 1(땅)이고 방문하지 않은 지점일 경우
				if(map[nextx][nexty]==1&&!visited[nextx][nexty]&&i<4) {
					visited[nextx][nexty]=true;
					q.add(new Pos(nextx, nexty));
					flag = true;
				}
				//대각선 인접 지점이 1(땅)이고 방문하지 않은 지점일 경우
				if(map[nextx][nexty]==1&&!visited[nextx][nexty]&&!flag&&i>=4) {
					visited[nextx][nexty]=true;
					q.add(new Pos(nextx, nexty));
					flag = true;
				}
			}
			if(!flag&&q.isEmpty()) {
				cnt++;
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> answer = new ArrayList<>();
		
		while(true) {
			n = sc.nextInt();
			m = sc.nextInt();
			//두 변수 모두 0이면 입력 종료
			if(n==0&&m==0) {
				for(int i=0;i<answer.size();i++) {
					System.out.println(answer.get(i));
				}
				break;
			}
			if(1<=n&&n<=50&&1<=m&&m<=50) {
				map = new int [m][n];
				visited = new boolean [m][n];
				for(int i=0;i<map.length;i++) {
					for(int j=0;j<map[i].length;j++) {
						//1은 땅, 0은 바다
						map[i][j]=sc.nextInt();
					}
				}
				for(int i=0;i<map.length;i++) {
					for(int j=0;j<map[i].length;j++) {
						//방문한 곳이 아니고 땅일 경우 탐색 진행
						if(!visited[i][j]&&map[i][j]==1) {
							visited[i][j]=true;
							bfs(i,j);
						}
					}
				}
				answer.add(cnt);
				cnt=0;
			}
		}
	}
}
