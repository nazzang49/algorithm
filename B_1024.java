package test_190131;

import java.util.ArrayList;
import java.util.Scanner;

//합이 n이면서, 길이가 최소 l이상인 최소 길이의 연속된 수 리스트 구하기
public class B_1024 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int l = sc.nextInt();
		
		if(n<=1000000000&&2<=l&&l<=100) {
			ArrayList<Integer> ans = new ArrayList<>();
			//l부터 리스트의 길이를 1씩 증가시키면서 연속된 세 수의 합 = n 판별
			while(l<101) {
				//(일반화) n = l * x + l * (l-1) / 2
				int x = (n-l*(l-1)/2);
				if(x%l==0&&x>=0) {
					x=x/l;
					for(int i=0;i<l;i++) {
						ans.add(x+i);
					}
					break;
				}
				l++;
			}
			//그러한 수열이 존재하지 않으면
			if(l==101) {
				System.out.println(-1);
			}
			for(int i=0;i<ans.size();i++) {
				System.out.println(ans.get(i));
			}
		}
	}
}
