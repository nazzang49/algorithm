package test_190114;

import java.util.ArrayList;
import java.util.Scanner;

//직원들의 수 n, 월급 변화 쿼리의 수 m, 월급 변화가 명령어 p 또는 u로 주어질 때 월급 변화 결과값 출력하기
public class B_2820 {

	static int [] payment;
	static boolean [] visited;
	static boolean [][] line;
	static ArrayList<Integer> ans = new ArrayList<>();
	
	public static void dfs(int num, int pay) {
		for(int i=1;i<payment.length;i++) {
			//아직 월급 올리지 않은 직원이고, 부하직원이면(월급 증가)
			if(!visited[i]&&line[num][i]) {
				visited[i]=true;
				//num의 부하직원인 경우, 월급 증가
				payment[i]+=pay;
				dfs(i,pay);
				//백트래킹
				visited[i]=false;
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		if(1<=n&&n<=500000&&1<=m&&m<=500000) {
			//직원들의 초기 월급 담을 배열
			payment = new int[n+1];
			//직원 간의 상하 관계 정의할 배열
			line = new boolean[n+1][n+1];
			visited = new boolean[n+1];
			//초기 월급 및 상하관계 입력(상근이는 회사 대표이므로, 초기 월급만 입력)
			payment[1]=sc.nextInt();
			for(int i=2;i<=n;i++) {
				int tmp1 = sc.nextInt();
				int tmp2 = sc.nextInt();
				payment[i]=tmp1;
				line[tmp2][i]=true;
			}
			//월급 변화 쿼리 명령어 입력
			int k = 0;
			while(k<m) {
				String query = sc.next();
				//tmp1의 모든 부하직원 월급 tmp2만큼 증가
				if(query.equals("p")) {
					int tmp1 = sc.nextInt();
					int tmp2 = sc.nextInt();
					dfs(tmp1, tmp2);
				}
				//tmp1의 월급 출력
				else {
					int tmp1 = sc.nextInt();
					ans.add(payment[tmp1]);
				}
				k++;
			}
			for(int i=0;i<ans.size();i++) {
				System.out.println(ans.get(i));
			}
		}
	}
}
