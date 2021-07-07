package test_181122;

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

//적록색약인 사람과 그렇지 않은 사람이 보는 RGB 세가지 색상으로 이루어진 영역 분별하기
public class B_10026 {

	static int n;
	static char [][] map;
	//방문 여부 배열도 두개 준비
	static boolean [][] visited;
	//영역 개수(적록색약 O / R과 G구분 못함)
	static int cnt1;
	//영역 개수(적록색약 X)
	static int cnt2;
	//다음 지점
	static int [][] move = {{1,0},{-1,0},{0,1},{0,-1}};
	
	public static void bfs(int x, int y, int k) {
		
		Queue<Position> q = new LinkedList<>();
		q.add(new Position(x, y));
		
		while(!q.isEmpty()) {
			Position p = q.poll();
			
			//상하좌우 탐색
			for(int i=0;i<4;i++) {
				int nextx = p.x+move[i][0];
				int nexty = p.y+move[i][1];
				
				//다음 지점이 영역 밖일 경우
				if(nextx<0||nexty<0||nextx>=n||nexty>=n) {
					continue;
				}
				//적록색약인 경우
				if(k==0) {
					if(!visited[nextx][nexty]
							&&(((map[p.x][p.y]=='R'||map[p.x][p.y]=='G')
							&&(map[nextx][nexty]=='R'||map[nextx][nexty]=='G'))
							||(map[p.x][p.y]=='B'&&map[nextx][nexty]=='B'))) {
						visited[nextx][nexty]=true;
						q.add(new Position(nextx, nexty));
					}
				}
				//적록색약이 아닌 경우
				else {
					if(!visited[nextx][nexty]
							&&((map[p.x][p.y]=='R'&&map[nextx][nexty]=='R')
							||(map[p.x][p.y]=='G'&&map[nextx][nexty]=='G')
							||(map[p.x][p.y]=='B'&&map[nextx][nexty]=='B'))) {
						visited[nextx][nexty]=true;
						q.add(new Position(nextx, nexty));
					}
				}
			}
			//더 이상 탐색할 지점이 없으면(=영역 형성)
			if(q.isEmpty()) {
				if(k==0) {
					cnt1++;	
				}else {
					cnt2++;
				}	
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		if(1<=n&&n<=100) {
			map = new char[n][n];
			visited = new boolean[n][n];
			for(int i=0;i<n;i++) {
				String str = sc.next();
				if(str.length()==n) {
					for(int j=0;j<n;j++) {
						map[i][j]=str.charAt(j);
					}	
				}else {
					System.out.println("문자열의 길이를 확인해주세요.");
					System.exit(0);
				}
			}
			int k = 0;
			while(k<2) {
				for(int i=0;i<n;i++) {
					for(int j=0;j<n;j++) {
						if(!visited[i][j]) {
							bfs(i,j,k);
						}
					}
				}
				//초기화
				visited = new boolean[n][n];
				k++;
			}
			
			//적록색약X
			System.out.print(cnt2+" ");
			//적록색약O
			System.out.print(cnt1);
		}
	}
}
