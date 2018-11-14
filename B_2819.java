package test_181103;

import java.util.Scanner;

//로봇의 이동경로에 따른 조사점과의 거리 합 출력(거리는 맨해튼 거리(=택시 기하학)를 기준으로 계산)
//맨해튼 거리 = 좌표 차의 제곱이 아닌 좌표 차의 절대값을 더해 거리 계산
public class B_2819 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		//조사점
		int [] x = new int[n];
		int [] y = new int[n];
		
		int [] answer = new int[m];
		
		//로봇의 좌표
		int a = 0;
		int b = 0;
		
		String order = "";
		
		if(1<=n&&n<=100000&&1<=m&&m<=300000) {
			for(int i=0;i<n;i++) {
				int tmp1 = sc.nextInt();
				int tmp2 = sc.nextInt();
				if(tmp1<=1000000&&tmp2<=1000000) {
					x[i] = tmp1;
					y[i] = tmp2;	
				}
			}
			order = sc.next();
			
			for(int i=0;i<order.length();i++) {
				//각 명령어 실행 시 조사점들과의 거리 합계 저장
				int sum=0;
				if(order.charAt(i)=='S') {
					b++;
					for(int j=0;j<x.length;j++) {
						sum+=Math.abs(x[j]-a)+Math.abs(y[j]-b);
					}
				}else if(order.charAt(i)=='J') {
					b--;
					for(int j=0;j<x.length;j++) {
						sum+=Math.abs(x[j]-a)+Math.abs(y[j]-b);
					}
				}else if(order.charAt(i)=='I') {
					a++;
					for(int j=0;j<x.length;j++) {
						sum+=Math.abs(x[j]-a)+Math.abs(y[j]-b);
					}
				}else if(order.charAt(i)=='Z') {
					a--;
					for(int j=0;j<x.length;j++) {
						sum+=Math.abs(x[j]-a)+Math.abs(y[j]-b);
					}
				}
				answer[i]=sum;
			}
			for(int i=0;i<answer.length;i++) {
				System.out.println(answer[i]);
			}
		}
	}
}
