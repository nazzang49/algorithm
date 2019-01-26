package test_190126;

import java.util.Scanner;

//김지민과 임한수가 토너먼트 대진 시작 위치가 주어질 때, 몇 라운드에서 서로 만나게 되는지 출력하기(모두 승리한다는 가정 하)
public class B_1057 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		//토너먼트 인원 수(홀짝 모두 가능)
		int n = sc.nextInt();
		//김지민의 시작위치
		int k = sc.nextInt();
		//임한수의 시작위치
		int l = sc.nextInt();
		int r = 1;
		
		if(1<=n&&n<=100000&&k<=n&&l<=n&&k!=l) {
			//둘의 위치 차이 = 1(만나는 순간)
			while(Math.abs(l/2-k/2)!=1) {
				if(l==1) {
					l=1;
				}else if(l%2==0) {
					l/=2;
				}else {
					l=l/2+1;
				}
				
				if(k==1) {
					k=1;
				}else if(k%2==0) {
					k/=2;
				}else {
					k=k/2+1;
				}
				r++;
			}
			System.out.println(r);
		}
	}
}
