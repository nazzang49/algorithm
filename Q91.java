package solution;

import java.util.Scanner;

//주어진 숫자를 오로지 소수의 조합만으로 표현할 수 있는 경우의 수 구하기
public class Q91 {

	//조합이 성공하는 경우의 수
	static int cnt = 0;
	static int n;

	//소수인지 판별하는 메소드
	public static boolean sosoo(int n) {
		boolean flag = false;
		for(int i=2;i<=n/2;i++) {
			if(n%i==0) {
				flag=true;
				break;
			}
		}
		//소수라면
		if(!flag) {
			return true;
		}
		return false;
	}
	
	//n과 가장 가까우면서 소수인 수부터 감소하며 탐색
	public static void dfs(int now, int sum) {
		if(sum==n) {
			cnt++;
		}else if(sum<n) {
			int i=now;
			boolean flag = false;
			while(i>=2) {
				flag = sosoo(i);
				if(flag) {
					sum+=i;
					dfs(i,sum);
					sum-=i;
				}
				i--;
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		if(2<=n&&n<=40000) {
			int [] dp = new int[n];
			int i=n;
			boolean flag = false;
			while(i>=2) {
				flag = sosoo(i);
				if(flag) {
					dfs(i,i);
				}
				i--;
			}
			System.out.println((int)cnt%123456789);
		}
	}
}
