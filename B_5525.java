package test_190114;

import java.util.Scanner;

//I와 O가 교대로 반복해서 나오는 문자열을 Pn이라고 할 때, 특정 문자열 내 Pn이 몇번 포함되어 있는지 구하는 프로그램 작성하기
public class B_5525 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		//O의 갯수(I의 갯수 = n+1)
		int n = sc.nextInt();
		int m = sc.nextInt();
		//정답 담을 변수
		int cnt = 0;
		
		if(1<=n&&n<=1000000&&2*n+1<=m&&m<=1000000) {
			String str = sc.next();
			//탐색 실행
			for(int i=0;i<m-1;i++) {
				if(str.charAt(i)=='I') {
					int tmp = n+n;
					//i가 짝수이면(홀수번째 인덱스에 O가 위치)
					if(i%2==0) {
						for(int j=i+1;j<m;j++) {
							//각각의 인덱스에 있어야할 문자가 없는 경우(Pn이 형성되지 못하는 경우)
							if((j%2==1&&str.charAt(j)!='O')
									||(j%2==0&&str.charAt(j)!='I')) {
								break;
							}
							tmp--;
							//Pn이 형성되는 경우
							if(tmp==0) {
								cnt++;
								break;
							}
						}
					}
					//i가 홀수이면(짝수번째 인덱스에 O가 위치)
					else {
						for(int j=i+1;j<m;j++) {
							//각각의 인덱스에 있어야할 문자가 없는 경우(Pn이 형성되지 못하는 경우)
							if((j%2==0&&str.charAt(j)!='O')
									||(j%2==1&&str.charAt(j)!='I')) {
								break;
							}
							tmp--;
							//Pn이 형성되는 경우
							if(tmp==0) {
								cnt++;
								break;
							}
						}
					}
				}
			}
			System.out.println(cnt);
		}
	}
}
