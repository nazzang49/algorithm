package test_181103;

import java.util.Scanner;

//파스칼 구하기(의사코드를 실제코드로 변경)
public class B_2986 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		if(1<=n&&n<=Math.pow(10, 9)) {
			int cnt = 0;
			for(int i=n-1;i>=1;i--) {
				cnt++;
				if(n%i==0) {
					break;
				}
			}
			System.out.println(cnt);
		}
	}
}
