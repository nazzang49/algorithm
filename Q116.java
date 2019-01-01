package solution;

import java.util.Scanner;

//냉장고의 부피를 이루는 세가지 정수 a,b,c가 있을 때 겉면적을 최소로 하며 주어진 부피를 만족하는 a,b,c 출력하기
public class Q116 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] answer = new int[3];
		
		int a = (int)Math.pow(n, 1/3f);
		boolean flag = false;
		for(int i=a;i>=1;i--) {
			//약수가 되는지 확인
			if(n%i==0) {
				flag=true;
				answer[0]=i;
				answer[1]=i;
				answer[2]=(int)(n/Math.pow(i, 2));
			}
			if(flag) {
				break;
			}
		}
		System.out.println(answer[0]);
		System.out.println(answer[1]);
		System.out.println(answer[2]);
	}
}
