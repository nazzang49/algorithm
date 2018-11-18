package test_181103;

import java.util.Scanner;

//팩토리얼 출력
public class B_10872 {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		if(0<=n&&n<=12) {
			if(n==0) {
				System.out.println(0);
				System.exit(0);
			}
			int tmp = 1;
			for(int i=2;i<=n;i++) {
				tmp*=i;
			}
			System.out.println(tmp);
		}
	}
}
