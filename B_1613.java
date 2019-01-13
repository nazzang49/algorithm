package test_190113;

import java.util.Scanner;

public class B_1613 {

	static int n;
	static int m;
	static int k;
	static int des;
	static int result=0;
	static int [][] history;
	
	//이전 값과 달라지면 더 이상 유추할 수 없음
	public static void dfs(int sta, int bfo, int count) {
		//탐색 끝나는 경우
		if(history[sta][des]!=0) {
			//바로 끝나는 경우
			if(count==0) {
				result=history[sta][des];
				return;	
			}
			//한번 이상 거쳐서 끝나는 경우(이전값과 비교 필수)
			else {
				if(history[sta][des]==bfo) {
					result=history[sta][des];
					return;
				}
			}
		}
		//거쳐가는 경우
		else {
			count++;
			for(int i=1;i<=n;i++) {
				//전후관계 존재하는 경우
				if(history[sta][i]!=0) {
					//처음이면 이전값 저장
					if(count==1) {
						bfo=history[sta][i];
						dfs(i,bfo,count);
					}
					//처음이 아니면 이전값과 비교(같을 때만 재귀함수 호출)
					else {
						if(bfo==history[sta][i]) {
							dfs(i,bfo,count);
						}
					}
				}
			}	
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		if(1<=n&&n<=400&&1<=m&&m<=50000) {
			history = new int[n+1][n+1];
			//사건 전후관계 입력
			for(int i=0;i<m;i++) {
				int tmp1 = sc.nextInt();
				int tmp2 = sc.nextInt();
				history[tmp1][tmp2]=-1;
				history[tmp2][tmp1]=1;
			}
			k = sc.nextInt();
			//전후관계를 알고자 하는 쌍의 개수
			if(1<=k&&k<=50000) {
				int [] ans = new int[k];
				int j = 0;
				while(j<k) {
					int tmp1 = sc.nextInt();
					int tmp2 = sc.nextInt();
					des=tmp2;
					dfs(tmp1,0,0);
					ans[j]=result;
					result=0;
					j++;
				}
				for(int i=0;i<ans.length;i++) {
					System.out.println(ans[i]);
				}
			}
		}
	}
}
