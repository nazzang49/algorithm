package solution;

import java.util.Scanner;

//치즈 1kg을 A/B만큼 훔쳐갔을 때, 남아있는 치즈의 양을 기약분수로 표현하기
public class Q90 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		if(1<=n&&n<k&&k<=9) {
			int p = k-n;
			int q = k;
			boolean flag = true;
			//기약분수 체크
			while(flag) {
				//분모 분수가 모두 2로 나눠지는지
				if(p%2==0&&q%2==0) {
					p/=2;
					q/=2;
					continue;
				}
				//분모 분수가 모두 3로 나눠지는지
				if(p%3==0&&q%3==0) {
					p/=3;
					q/=3;
					continue;
				}
				flag = false;
			}
			System.out.println(p);
			System.out.println(q);
		}
	}
}
