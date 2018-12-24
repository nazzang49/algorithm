package solution;

import java.util.Scanner;

//3의 배수 자연수 n이 주어질 때, 해당 자연수를 3의 배수 3개 숫자로 표현하는 경우의 수 구하기
public class Q84 {

	static int n;
	//경우의 수 저장
	static int cnt = 0;
	
	public static void dfs(int sum, int count) {
		if(sum==n&&count==3) {
			cnt++;
		}else if(sum<n&&count<3) {
			count++;
			for(int i=1;i<=n/3;i++) {
				sum+=i*3;
				dfs(sum, count);
				sum-=i*3;
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		//3의 배수 n
		if(3<=n&&n<=3000&&n%3==0) {
			for(int i=1;i<=n/3;i++) {
				dfs(i*3,1);
			}
			System.out.println(cnt);
		}
	}
}
