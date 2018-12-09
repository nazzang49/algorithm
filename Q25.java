package solution;

import java.util.Scanner;

//괄호 문자열의 쌍(열고 닫는)으로 표현할 수 있는 올바른 문자열 개수 구하기
public class Q25 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		//입력되는 괄호 쌍의 개수
		int n = sc.nextInt();
		
		if(1<=n&&n<=14) {
			int [] answer = new int[n+1];
			answer[1]=1;
			answer[2]=2;
			answer[3]=5;
			for(int i=4;i<=n;i++) {
				//앞에서부터 여는 괄호의 개수에 따라
				for(int j=1;j<i;j++) {
					answer[i]+=j*answer[i-j];
				}
				answer[i]++;
			}
			System.out.println(answer[n]);
		}
	}
}
