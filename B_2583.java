package test_181126;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Loc {
	int x,y;
	
	public Loc(int x, int y) {
		this.x=x;
		this.y=y;
	}
}

//직사각형 형태의 모눈종이에 1X1 크기의 색을 임의로 칠할 때, 색칠된 영역 외 형성되는 영역 개수 구하기
public class B_2583 {

	static int r;
	static int c;
	//색칠된 영역 표시할 좌표
	static int k;
	static boolean [][] visited;
	//상하좌우 이동 가능
	static int [][] move = {{1,0},{-1,0},{0,1},{0,-1}};
	//색칠 되지 않은 영역 개수
	static int cnt;
	//색칠 되지 않은 영역별 넓이
	static int area;
	static ArrayList<Integer> answer = new ArrayList<>();

	public static void bfs(int x, int y) {
		Queue<Loc> q = new LinkedList<>();
		q.add(new Loc(x, y));
		
		while(!q.isEmpty()) {
			Loc l = q.poll();
			
			for(int i=0;i<4;i++) {
				int nextx = l.x+move[i][0];
				int nexty = l.y+move[i][1];
				
				//다음 지점이 영역 밖일 경우
				if(nextx<0||nexty<0||nextx>=r||nexty>=c) {
					continue;
				}
				//다음 지점이 방문하지 않은 지점, 즉 색칠 되지 않은 지점이면
				if(!visited[nextx][nexty]) {
					visited[nextx][nexty]=true;
					q.add(new Loc(nextx, nexty));
					//넓이 1추가
					area++;
				}
			}
			if(q.isEmpty()) {
				cnt++;
				answer.add(area);
				area=0;
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		r = sc.nextInt();
		c = sc.nextInt();
		k = sc.nextInt();
		
		if(1<=r&&r<=100&&1<=c&&c<=100&&1<=k&&k<=100) {
			visited = new boolean[r][c];
			
			for(int i=0;i<k;i++) {
				//색이 칠해지는 시작 지점
				int x1 = sc.nextInt();
				int y1 = sc.nextInt();
				int x2 = sc.nextInt();
				int y2 = sc.nextInt();
				//색칠된 부분은 true로 변경
				for(int j=y1;j<=y2-1;j++) {
					for(int m=x1;m<=x2-1;m++) {
						visited[j][m]=true;
					}
				}
			}
			for(int i=0;i<r;i++) {
				for(int j=0;j<c;j++) {
					if(!visited[i][j]) {
						visited[i][j]=true;
						area++;
						bfs(i,j);
					}
				}
			}
			System.out.println(cnt);
			//오름차순 정렬
			for(int i=0;i<answer.size()-1;i++) {
				for(int j=i+1;j<answer.size();j++) {
					if(answer.get(i)>answer.get(j)) {
						int tmp = answer.get(j);
						answer.set(j, answer.get(i));
						answer.set(i, tmp);
					}	
				}
			}
			for(int i=0;i<answer.size();i++) {
				System.out.print(answer.get(i)+" ");
			}
		}
	}
}
