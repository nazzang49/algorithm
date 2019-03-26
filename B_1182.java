package test_190326;

import java.util.Scanner;

//주어진 수열에서 부분 수열의 합이 S가 되는 경우의 수 구하기
public class B_1182 {

	static int n;
	static int s;
	static int [] arr;
	static int cnt = 0;
	
	public static void dfs(int cur, int sum) {
		if(sum==s) {
			cnt++;
		}
		for(int i=cur+1;i<n;i++) {
			sum+=arr[i];
			dfs(i,sum);
			//백트래킹
			sum-=arr[i];
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		s = sc.nextInt();
		
		if(n<=20&&Math.abs(s)<=1000000) {
			arr = new int[n];
			//정수 입력
			for(int i=0;i<arr.length;i++) {
				arr[i]=sc.nextInt();
			}
			//탐색
			for(int i=0;i<n;i++) {
				dfs(i,arr[i]);
			}
			System.out.println(cnt);
		}	
	}
}
