package solution;

import java.util.ArrayList;
import java.util.Scanner;

class Pos {
	int x, y;
	
	public Pos(int x, int y) {
		this.x=x;
		this.y=y;
	}
}

//음료수 캔의 개수 n, 자석 청소기의 개수 m, 청소기 구동 가능 시간 s, 각 청소기가 1분당 캔을 끌어들이는 속도 v가 주어질 때 처리할 수 있는 최대 캔의 개수 출력하기
//특정 청소기 - 특정 음료수 캔의 직선 거리 > s*v => 청소 불가능
public class Q121 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int s = sc.nextInt();
		int v = sc.nextInt();
		
		int cnt = 0;
				
		ArrayList<Pos> can = new ArrayList<>();
		ArrayList<Pos> cleaner = new ArrayList<>();
		boolean [] visited = new boolean[n];
		
		if(1<=n&&n<=100&&1<=m&&m<=100&&1<=s&&s<=100&&1<=v&&v<=100) {
			//캔과 청소기 좌표 입력
			for(int i=0;i<n;i++) {
				can.add(new Pos(sc.nextInt(), sc.nextInt()));
			}
			for(int i=0;i<m;i++) {
				cleaner.add(new Pos(sc.nextInt(), sc.nextInt()));
			}
			//탐색 실행(청소기 좌표를 기준으로)
			for(int i=0;i<m;i++) {
				Pos cleaner_p = cleaner.get(i);
				//최소 거리인지 확인할 변수
				double min = Integer.MAX_VALUE;
				int idx = 0;
				for(int j=0;j<n;j++) {
					if(!visited[j]) {
						Pos can_p = can.get(j);
						//캔과 청소기의 거리
						double dis = Math.sqrt(Math.pow(cleaner_p.x-can_p.x, 2)+Math.pow(cleaner_p.y-can_p.y, 2));
						if(min>=dis) {
							min=dis;
							idx=j;
						}	
					}
				}
				//최소거리 > 시간x거리(캔 처리 불가)
				if(min>s*v) {
					continue;
				}else {
					visited[idx]=true;
					cnt++;
				}
			}
			System.out.println(cnt);
		}
	}
}
