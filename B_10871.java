package test_190218;

import java.util.ArrayList;
import java.util.Scanner;

//n개의 자연수, 기준이 되는 자연수 x가 주어질 때 x보다 작은 자연수 모두 출력하기
public class B_10871 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int x = sc.nextInt();
		
		if(n<=10000&&x<=10000) {
			ArrayList<Integer> ans = new ArrayList<>();
			//즉시 탐색
			for(int i=0;i<n;i++) {
				int tmp = sc.nextInt();
				if(tmp<x) System.out.print(tmp+" ");
			}
		}	
	}
}
