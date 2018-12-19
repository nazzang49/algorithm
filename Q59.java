package solution;

import java.util.Scanner;

//입력값을 두 개 이상의 자연수 합으로 나타내는 모든 경우의 수를 구하시오
public class Q59 {

	static int n;
	static int cnt = 0;
	
	public static void dfs(int end, int sum) {
		if(sum==n) {
			cnt++;
		}else if(sum<n) {
			for(int i=end;i>=1;i--) {
				sum+=i;
				dfs(i,sum);
				//그 다음 반복에 대한 초기화 작업
				sum-=i;
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		if(1<=n&&n<=50) {
			for(int i=1;i<n;i++) {
				dfs(i,i);
			}
			System.out.println(cnt);
		}
	}
}
