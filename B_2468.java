package test_181113;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point{
	int x, y;
	
	public Point(int x, int y) {
		this.x=x;
		this.y=y;
	}
}

//장마철 빗물에 잠기지 않는 안전영역의 개수(빗물의 수위에 따른 안전영역의 최대 개수) 구하기(bfs 탐색)
public class B_2468 {

	static int n;
	static int [][] map;
	static ArrayList<Integer> list;
	static int [] movex = {1,-1,0,0};
	static int [] movey = {0,0,-1,1};;
	static int cnt = 0;
	static boolean [][] visited;
	
	public static void bfs(int low, int x, int y) {
		
		//탐색 시작 지점 저장
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(x, y));
		visited[x][y]=true;
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			//현재 지점에서 다음 탐색할 지점(상,하,좌,우)
			boolean flag = false;
			for(int i=0;i<4;i++) {
				int nextx = p.x+movex[i];
				int nexty = p.y+movey[i];
				
				//영역 벗어나는 지점은 탐색할 필요 없음
				if(nextx<0||nexty<0||nextx>=n||nexty>=n) {
					continue;
				}
				//인접 지점 + 잠기는
				if(!visited[nextx][nexty]&&map[nextx][nexty]<=low) {
					continue;
				}
				//인접 지점 + 잠기지 않는
				if(!visited[nextx][nexty]&&map[nextx][nexty]>low) {
					visited[nextx][nexty]=true;
					flag=true;
					q.add(new Point(nextx, nexty));
				}
			}
			//하나의 영역이 형성되었을 때
			if(!flag) {
				cnt++;
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new int[n][n];
		//강수량에 의한 빗물 높이(최저기준은 1, 최고기준은 map의 최대값)
		int low = 1;
		int high = 0;
		visited = new boolean[n][n];
		list = new ArrayList<>(); 
		//안전 영역의 총 개수
		
		if(2<=n&&n<=100) {
			for(int i=0;i<map.length;i++) {
				for(int j=0;j<map.length;j++) {
					int tmp = sc.nextInt();
					if(1<=tmp&&tmp<=100) {
						map[i][j]=tmp;
						if(tmp>high) {
							high=tmp;
						}
					}
				}
			}
			
			//빗물의 수위를 하나씩 높이면서 탐색 반복
			while(low<=high) {
				for(int i=0;i<map.length;i++) {
					for(int j=0;j<map.length;j++) {
						if(!visited[i][j]&&map[i][j]>low) {
							bfs(low, i, j);
						}
					}
				}
				list.add(cnt);
				cnt=0;
				low++;
			}
			
			int [] answer = new int[list.size()];
			for(int i=0;i<answer.length;i++) {
				answer[i]=list.get(i);
			}
			Arrays.sort(answer);
			System.out.println(answer[answer.length-1]);
		}
	}
}
