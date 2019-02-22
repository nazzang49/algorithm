package test_181115;

import java.util.Scanner;

//참여인원과 한 봉지 안에 든 사탕 개수가 주어질 때, 구매해야 할 사탕 봉지 개수 구하기
public class B_3955 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		long [] answer = new long[t];
		
		int k=0;
		while(k<t) {
			long n = sc.nextInt();
			long m = sc.nextInt();
			if(1<=n&&n<=Math.pow(10, 9)&&1<=m&&m<=Math.pow(10, 9)
					&&0<t&&t<100) {
				//파티 인원과 한 봉지 당 개수가 배수관계일 경우
				if(n%m==0) {
					System.out.println("들어온다");
					answer[k]=0;
					continue;
				}
				//파티 인원과 한 봉지 당 개수가 배수관계가 아닐 경우
				else {
					for(long i=1;i<=Math.pow(10, 9);i++) {
						if((n*i+1)%m==0) {
							long tmp = (n*i+1)/m;
							answer[k]=tmp;
							break;
						}
					}	
				}
			}
			k++;
		}
		for(int i=0;i<answer.length;i++) {
			if(answer[i]==0) {
				System.out.println("IMPOSSIBLE");
			}else {
				System.out.println(answer[i]);	
			}
		}
	}
}
