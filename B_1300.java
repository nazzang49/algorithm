package test_190123;

import java.util.Scanner;

//nxn 행렬의 각 인덱스끼리의 곱 i*j를 1차원 배열에 저장했을 때, k번째 자연수 구하기
public class B_1300 {

	static int n;
	static int k;
	
	public static boolean result(int mid) {
		int cnt = 0;
		//배수 개념 적용(i행의 모든 열에 있는 수는 i배수 => i행에서 mid보다 작거나 같은 모든 수의 갯수)
		for(int i=1;i<=n;i++) {
			cnt+=Math.min(n, mid/i);
		}
		
		return cnt>=k? true : false;
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		
		if(n<=Math.pow(10, 5)&&k<=Math.min(Math.pow(10, 9),n*n)) {
			int left = 1;
			int right = 1000000000;
			int mid = 0;
			
			int ans = Integer.MAX_VALUE;
			while(left<=right) {
				mid = (left+right)/2;
				if(result(mid)) {
					right=mid-1;
					ans = Math.min(ans,mid);
				}else {
					left=mid+1;
				}
			}
			System.out.println(ans);
		}	
	}
}
