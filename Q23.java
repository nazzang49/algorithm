package solution;

import java.util.Scanner;

//1 or 2 가로 길이를 가진 직사각형을 활용하여 세로 길이가 2, 가로 길이가 n인 직사각형을 가득 채울 때 활용할 수 있는 모든 방법 구하기
public class Q23 {

	static int cnt = 0;
	
	//DFS 탐색 반복하며 가로 길이 만족하는 순간 횟수 증가
	public static void dfs(int n, int sum) {
		if(sum==n) {
			//경우의 수 카운트+1
			cnt++;
		}else if(sum<n){
			for(int i=0;i<2;i++) {
				if(i==0) {
					dfs(n,sum+1);
				}else {
					dfs(n,sum+2);
				}
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		if(1<=n&&n<=60000) {
			dfs(n,0);
			System.out.println(cnt%1000000007);
		}
	}
}
