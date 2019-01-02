package solution;

import java.util.Scanner;

//주기 수열의 최소 주기값 출력하기
public class Q119 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		int n3 = sc.nextInt();
		int n4 = sc.nextInt();
		
		int min = Integer.MAX_VALUE;
		
		if(1<=n1&&n1<=100&&2<=n2&&n2<=100&&2<=n3&&n3<=100&&5<=n4&&n4<=100&&n1<n4) {
			int [] S = new int[1001];
			S[0]=n1;
			//입력
			for(int i=1;i<S.length;i++) {
				S[i]=(n2*S[i-1]+n3)%n4;
			}
			//탐색
			for(int i=0;i<S.length-1;i++) {
				int cnt = 1;
				for(int j=i+1;j<S.length;j++) {
					//같은 숫자가 나오면 하나의 주기 형성
					if(S[i]==S[j]) {
						break;
					}
					cnt++;
				}
				if(min>cnt) {
					min=cnt;
				}
				//새로운 주기값 = 이전 주기값 (이제 계속 반복된다는 의미)
				else if(min==cnt) {
					break;
				}
			}
			System.out.println(min);
		}
	}
}
