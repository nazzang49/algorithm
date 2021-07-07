package test_181129;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Loc {
	int x, y;
	
	public Loc(int x, int y) {
		this.x=x;
		this.y=y;
	}
}

//테트리스 게임(색의 종류가 적힌 블록 위치가 주어질 때 점수 획득 횟수 구하기)
public class B_11559 {

	//횟수 변수
	static int cnt;
	static char [][] map;
	//상하좌우 탐색 가능
	static int [][] move = {{1,0},{-1,0},{0,1},{0,-1}};
	static boolean [][] visited;
	//부서질 뿌요 좌표 저장할 가변배열(4개 이상이면 한번이라도 부서지는 것)
	static ArrayList<Loc> point = new ArrayList<>();
	//초기값 설정
	static boolean chk = false;

	//빈 공간 위 블럭 존재 시 해당 블럭 -> 빈 공간으로 잡아당기는 메소드(한 열마다 탐색)
	public static void gravity() {
		int t=11;
		Queue<Character> q = new LinkedList<>();
		for(int j=0;j<6;j++) {
			for(int i=11;i>=0;i--) {
				if(map[i][j]!='.') {
					q.add(map[i][j]);
					//잡아당겨진 부분은 빈 공간으로 변경
					map[i][j]='.';
				}
			}
			t=11;
			while(!q.isEmpty()) {
				char a = q.poll();
				map[t--][j]=a;
			}
		}
	}
	
	//부서지는 영역 -> 빈 공간으로 바꾸는 메소드
	public static boolean flag(ArrayList<Loc> list) {
		if(list.size()>=4) {
			for(int i=0;i<list.size();i++) {
				Loc l = list.get(i);
				map[l.x][l.y]='.';
			}
			point.clear();
			return true;
		}else {
			//부서지는 영역이 없으면 false 반환
			point.clear();
			return false;
		}
	}
	
	public static void bfs(int x, int y) {
		Queue<Loc> q = new LinkedList<>();
		q.add(new Loc(x, y));
		
		while(!q.isEmpty()) {
			Loc l = q.poll();
			
			//x가 행, y가 열
			for(int i=0;i<4;i++) {
				int nextx = l.x+move[i][0];
				int nexty = l.y+move[i][1];
				//다음 지점이 영역 밖이면
				if(nextx<0||nexty<0||nextx>=12||nexty>=6) {
					continue;
				}
				if(!visited[nextx][nexty]) {
					//다음 지점이 현재 색깔과 같다면(총 5가지 색깔)
					if(map[nextx][nexty]==map[l.x][l.y]) {
						point.add(new Loc(nextx, nexty));
						visited[nextx][nexty]=true;
						q.add(new Loc(nextx, nexty));
					}
				}
			}
			//하나의 영역이 형성되면
			if(q.isEmpty()) {
				if(!chk) {
					chk=flag(point);
				}else {
					flag(point);
				}
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		map = new char[12][6];
		visited = new boolean[12][6];
		
		for(int i=0;i<12;i++) {
			String str = sc.next();
			for(int j=0;j<6;j++) {
				map[i][j]=str.charAt(j);
			}
		}
		
		while(true) {
			//가장 아래서부터 탐색(아래로 잡아당겨야 하므로
			for(int i=11;i>=0;i--) {
				for(int j=0;j<6;j++) {
					//아직 방문하지 않았고 빈 공간이 아닐 경우
					if(!visited[i][j]&&map[i][j]!='.') {
						visited[i][j]=true;
						point.add(new Loc(i, j));
						bfs(i,j);
					}
				}
			}
			//뿌요 영역이 한번이라도 부서지면
			if(chk) {
				//횟수 증가
				cnt++;
				//부서진 영역이 있을 때만 잡아당기기 실행
				gravity();
			}else {
				System.out.println(cnt);
				System.exit(0);
			}
			//탐색 여부 배열 및 부서질 뿌요 좌표 배열 초기화
			visited = new boolean[12][6];
			point = new ArrayList<>();
			chk = false;
		}
	}
}
