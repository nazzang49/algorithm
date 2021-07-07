package test_181126;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pos {
	int x, y;
	
	public Pos(int x, int y) {
		this.x=x;
		this.y=y;
	}
}

//어느 밭에 배추들이 심어진 좌표가 주어질 때, 해충으로부터 보호하기 위해 필요한 지렁이 마리수 구하기
public class B_1012 {

	static int [][] map;
	static boolean [][] visited;
	//필요한 배추 흰지렁이 수
	static int cnt;
	//배추 밭의 가로 길이, 세로 길이, 배추가 심어진 좌표 개수
	static int r;
	static int c;
	static int n;
	//상하좌우 이동 가능
	static int [][] move = {{1,0},{-1,0},{0,1},{0,-1}};
	static int [] answer;
	
	public static void bfs(int x, int y) {
		Queue<Pos> q = new LinkedList<>();
		q.add(new Pos(x, y));
		
		while(!q.isEmpty()) {
			Pos p = q.poll();
			for(int i=0;i<4;i++) {
				int nextx = p.x+move[i][0];
				int nexty = p.y+move[i][1];
				//다음 지점 = 배추밭 벗어나는 지점
				if(nextx<0||nexty<0||nextx>=r||nexty>=c) {
					continue;
				}
				//다음 지점 = 방문하지 않은 배추 지점
				if(!visited[nextx][nexty]&&map[nextx][nexty]==1) {
					visited[nextx][nexty]=true;
					q.add(new Pos(nextx, nexty));
				}
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		answer = new int[t];
		
		int k=0;
		while(k<t) {
			r = sc.nextInt();
			c = sc.nextInt();
			n = sc.nextInt();
			if(1<=r&&r<=50&&1<=c&&c<=50) {
				map = new int[r][c];
				visited = new boolean[r][c];
				for(int i=0;i<n;i++) {
					int x1 = sc.nextInt();
					int y1 = sc.nextInt();
					if(0<=x1&&x1<=r-1&&0<=y1&&y1<=c-1) {
						map[x1][y1]=1;
					}else {
						System.out.println("배추밭을 벗어납니다.");
						System.exit(0);
					}
				}
				for(int i=0;i<map.length;i++) {
					for(int j=0;j<map[i].length;j++) {
						//방문하지 않은 새로운 배추 영역이면 지렁이 개수 +1
						if(!visited[i][j]&&map[i][j]==1) {
							cnt++;
							visited[i][j]=true;
							bfs(i,j);
						}
					}
				}
			}else {
				System.out.println("입력값의 범위를 확인하세요.");
				System.exit(0);
			}
			answer[k]=cnt;
			cnt=0;
			k++;
		}
		for(int i=0;i<answer.length;i++) {
			System.out.println(answer[i]);
		}
	}
}
