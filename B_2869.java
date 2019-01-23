package test_190123;

import java.util.Scanner;

//달팽이가 낮에 a미터 상승, 저녁에 b미터 하강하고, 올라가야할 막대의 높이는 v미터일 때 모두 올라가는데 며칠이 걸리는지 출력하기 
public class B_2869 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int v = sc.nextInt();
		
		if(1<=b&&b<a&&a<=v&&v<=1000000000) {
			//이분탐색
			int left = 0;
			int right = v/(a-b);
			int mid = 0;
			while(left<=right) {
				//기준 일수
				mid = (left+right)/2;
				if(mid*a-(mid-1)*b>=v) {
					break;
				}else {
					left=mid+1;
				}
			}
			System.out.println(mid);
		}
	}
}
