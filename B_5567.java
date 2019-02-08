package test_190208;

import java.util.ArrayList;
import java.util.Scanner;

//결혼식에 친구, 해당 친구의 친구까지 초대하려고 할 때, 입력된 친구 정보를 바탕으로 최종 초대하는 인원수 구하기
public class B_5567 {

	static int n;
	static int m;
	static boolean [][] friend;
	static boolean [] visited;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		//상근이의 직속 친구
		ArrayList<Integer> close = new ArrayList<>();
		if(n<=500&&m<=10000) {
			friend = new boolean[n+1][n+1];
			visited = new boolean[n+1];
			int cnt = 0;
			
			//친구 관계 설정
			for(int i=1;i<=m;i++) {
				int tmp1 = sc.nextInt();
				int tmp2 = sc.nextInt();
				
				if(tmp1==1) {
					cnt++;
					visited[tmp2]=true;
					close.add(tmp2);
				}
				friend[tmp1][tmp2]=friend[tmp2][tmp1]=true;
			}
			
			//탐색 실행
			for(int i=0;i<close.size();i++) {
				for(int j=2;j<=n;j++) {
					if(friend[close.get(i)][j]&&!visited[j]) {
						visited[j]=true;
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}
	}
}
