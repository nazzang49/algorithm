package solution;

import java.util.Scanner;

//양의 정수 n개가 주어졌을 때, 가능한 모든 쌍의 GCD 합 구하는 프로그램 작성하기
public class Q147 {

	//두 수의 최대 공약수 구하는 유클리드 메소드
	public static int GCD(int a, int b) {
		if(a<b) {
			int tmp = a;
			a=b;
			b=tmp;
		}
		return a%b==0? b:GCD(a%b,b);
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int [] answer = new int[t];
		
		int k = 0;
		while(k<t&&t<=100) {
			int n = sc.nextInt();
			int [] arr = new int[n];
			//n개의 자연수 입력
			for(int i=0;i<n;i++) {
				arr[i]=sc.nextInt();
			}
			int sum = 0;
			//각 쌍의 최대공약수 합 구하기
			for(int i=0;i<n-1;i++) {
				for(int j=i+1;j<n;j++) {
					sum+=GCD(arr[i],arr[j]);
				}
			}
			answer[k]=sum;
			k++;
		}
		for(int i=0;i<answer.length;i++) {
			System.out.println(answer[i]);
		}
	}
}
