package solution;

import java.util.Scanner;

//딜러가 특정 숫자가 적힌 카드를 뽑았을 때, 그 수보다 작은 수가 적힌 카드들의 부분합으로 해당 숫자를 표현할 수 있는지 구하기
public class Q78 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		//테스트 케이스 개수
		int t = sc.nextInt();
		
		if(1<=t&&t<=Math.pow(10, 3)) {
			//각 케이스별 정답 담을 배열
			String [] answer = new String[t];
			for(int k=0;k<t;k++) {
				int n = sc.nextInt();
				if(2<=n&&n<=Math.pow(10, 9)) {
					//홀수는 무조건 가능
					if(n%2==1) {
						answer[k]="GAZUA";
						continue;
					}
					//짝수는 탐색 실행
					else {
						boolean flag = false;
						//중간값부터 감소시키면서 탐색
						for(int i=n/2;i>=2;i--) {
							int sum = 0;
							sum+=i;
							for(int j=i-1;j>=1;j--) {
								sum+=j;
								if(sum==n) {
									flag=true;
									answer[k]="GAZUA";
									break;
								}
								//초과하면 탐색 종료
								if(sum>n) {
									break;
								}
							}
							if(flag) {
								break;
							}	
						}
						if(!flag) {
							answer[k]="GOHANGANG";
						}
					}
				}
			}
			for(int i=0;i<answer.length;i++) {
				System.out.println(answer[i]);
			}
		}
	}
}
