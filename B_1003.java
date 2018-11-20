package test_181120;

import java.util.Scanner;

//피보나치 함수를 DP로 구현하기
public class B_1003 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int [] answer = new int[t];
		
		for(int i=0;i<t;i++) {
			int tmp = sc.nextInt();
			if(0<=tmp&&tmp<=40) {
				if(tmp==0) {
					answer[i]=0;
					continue;
				}
				if(tmp==1) {
					answer[i]=1;
					continue;
				}
				int [] dp = new int[tmp+1];
				//초기값
				dp[0]=0;
				dp[1]=1;
				for(int j=2;j<=tmp;j++) {
					dp[j]=dp[j-2]+dp[j-1];
					if(j==tmp) {
						answer[i]=dp[j];
					}
				}
			}else {
				System.out.println("40보다 작은 자연수만 입력 가능합니다.");
				System.exit(0);
			}
		}
		for(int i=0;i<answer.length;i++) {
			System.out.println(answer[i]);
		}
	}
}
