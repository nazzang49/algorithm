package test_181106;

import java.util.Scanner;

//피보나치 수의 확장(음수 적용 가능)
public class B_1788 {

	public static int fibonacci(int n) {
		if(n==0) {
			return 0;
		}else if(n==1) {
			return 1;
		}else if(n==-1) {
			return 1;
		}else if(n<-1) {
			return -fibonacci(n+1)+fibonacci(n+2);
		}else {
			return fibonacci(n-1)+fibonacci(n-2);
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		if(Math.abs(n)<1000000) {
			int tmp = fibonacci(n);
			if(tmp>1) {
				System.out.println(1);
				System.out.println(Math.abs(tmp)%1000000000);
			}else if(tmp==0) {
				System.out.println(0);
				System.out.println(Math.abs(tmp)%1000000000);
			}else {
				System.out.println(-1);
				System.out.println(Math.abs(tmp)%1000000000);			
			}
		}
	}
}
