package solution;

import java.util.Scanner;

//어떤 수를  표현하는 연속된 수들의 부분합 경우의 수 구하기
public class Q47 {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int cnt = 0;
		int sum = 0;
		
		if(1<=n&&n<=10000) {
			int i = 1;
			//중간값까지만 확인하면 됨
			while(i<=n/2) {
				for(int j=i;j<=n/2+1;j++) {
					sum+=j;
					System.out.println("sum : "+sum);
					if(sum==n) {
						cnt++;
						break;
					}
				}
				sum=0;
				i++;
			}
			System.out.println(cnt+1);
		}
	}
}
