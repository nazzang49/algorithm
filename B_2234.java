package test_181130;

import java.util.HashMap;
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

//길을 따라 성곽의 벽이 동서남북 방향으로 임의 존재할 때 전체 방의 개수, 가장 큰 방의 크기, 하나의 벽을 제거할 시 형성될 수 있는 가장 넓은 방의 크기 구하기
public class B_2234 {

	static int r;
	static int c;
	//이진수 담을 배열(이동 가능한 방향)
	static String [][] map;
	//방마다 번호 지정할 배열
	static int [][] room;
	static int [][] move = {{1,0},{-1,0},{0,1},{0,-1}};
	static boolean [][] visited;
	//방의 개수
	static int cnt;
	//방의 넓이
	static int area;
	//최대 방의 크기를 구할 가변 배열
	static HashMap<Integer,Integer> answer = new HashMap<>();
	
	public static void bfs(int x, int y) {
		Queue<Pos> q = new LinkedList<>();
		q.add(new Pos(x, y));
		
		while(!q.isEmpty()) {
			Pos p = q.poll();
			
			for(int i=0;i<4;i++) {
				//이동 가능한 경우만 조사(벽에 막혀 있지 않고 아직 방문하지 않은)
				if(map[p.x][p.y].charAt(i)=='0') {
					//남쪽이동
					if(i==0&&!visited[p.x+1][p.y]) {
						visited[p.x+1][p.y]=true;
						q.add(new Pos(p.x+1, p.y));
						room[p.x+1][p.y]=cnt;
						area++;
					}
					//동쪽이동
					if(i==1&&!visited[p.x][p.y+1]) {
						visited[p.x][p.y+1]=true;
						q.add(new Pos(p.x, p.y+1));
						room[p.x][p.y+1]=cnt;
						area++;
					}
					//북쪽이동
					if(i==2&&!visited[p.x-1][p.y]) {
						visited[p.x-1][p.y]=true;
						q.add(new Pos(p.x-1, p.y));
						room[p.x-1][p.y]=cnt;
						area++;
					}
					//서쪽이동
					if(i==3&&!visited[p.x][p.y-1]) {
						visited[p.x][p.y-1]=true;
						q.add(new Pos(p.x, p.y-1));
						room[p.x][p.y-1]=cnt;
						area++;
					}
				}
			}
			//하나의 방이 형성되면
			if(q.isEmpty()) {
				//방 번호 별 크기 저장
				answer.put(cnt, area);
				//방 번호 증가
				cnt++;
				//방 크기 초기화
				area=0;
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		r = sc.nextInt();
		c = sc.nextInt();
		if(1<=r&&r<=50&&1<=r&&r<=50) {
			map = new String[c][r];
			visited = new boolean[c][r];
			room = new int[c][r];
			
			for(int i=0;i<c;i++) {
				for(int j=0;j<r;j++) {
					int tmp = sc.nextInt();
					//2진수로 변형하여 저장
					//4자리 형태가 아니면
					String str=Integer.toBinaryString(tmp);
					if(4-str.length()==1) {
						str="0"+str;
					}else if(4-str.length()==2) {
						str="00"+str;
					}else if(4-str.length()==3) {
						str="000"+str;
					}
					map[i][j]=str;
				}
			}
			for(int i=0;i<c;i++) {
				for(int j=0;j<r;j++) {
					//방문하지 않은 방이면
					if(!visited[i][j]) {
						room[i][j]=cnt;
						bfs(i,j);
					}
				}
			}
			//방의 개수
			System.out.println(cnt);
			//최대 방의 크기 (오름차순 정렬)
			int max = 0;
			for(int i=0;i<answer.size();i++) {
				if(max<answer.get(i)) {
					max=answer.get(i);
				}
			}
			System.out.println(max);
			max=0;
			//벽을 하나 없앨 시 형성 가능한 최대 방의 크기
			for(int i=0;i<c;i++) {
				for(int j=0;j<r;j++) {
					for(int m=0;m<4;m++) {
						int nextx = i+move[m][1];
						int nexty = j+move[m][0];
						
						if(nextx<0||nexty<0||nextx>=c||nexty>=r) {
							continue;
						}
						//방 번호가 다른 영역이 등장하면(두 영역의 합 구하기)
						if(room[i][j]!=room[nextx][nexty]) {
							if(max<answer.get(room[i][j])+answer.get(room[nextx][nexty])) {
								max=answer.get(room[i][j])+answer.get(room[nextx][nexty]);
							}
						}
					}
				}
			}
			System.out.println(max);
		}
	}
}
