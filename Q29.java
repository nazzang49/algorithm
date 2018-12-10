package solution;

import java.util.Scanner;

//자연수 n의 모든 약수를 더한 값 출력하기
public class Q29 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		if(0<=n&&n<=3000) {
			int sum = 0;
			for(int i=1;i<=n;i++) {
				if(n%i==0) {
					sum+=i;
				}
			}
			System.out.println(sum);
		}
	}
}
