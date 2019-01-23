package test_190123;

import java.util.Arrays;
import java.util.Scanner;

//n개 도현이의 집이 있는 좌표 x, 설치하고자 하는 공유기 갯수 c가 주어질 때 최대한 많은 곳에서 와이파이를 사용할 시 인접 공유기 간 거리의 최대값 구하기
public class B_2110 {

	static int [] x;
	static int c;
	
	public static boolean result(int mid) {
		int cnt = 1;
		int last = x[0];
		for(int i=1;i<x.length;i++) {
			//두 집 간(=인접 공유기)거리가 기준거리 이상이면(=설치 가능)
			if(x[i]-last>=mid) {
				cnt++;
				last=x[i];
			}
		}
		
		//현재의 기준거리에서 입력된 대수만큼 공유기 설치 가능 여부 반환
		//true면 기준거리 범위 up
		//false면 기준거리 범위 down
		return cnt>=c;
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		c = sc.nextInt();
		
		if(2<=n&&n<=200000&&2<=c&&c<=n) {
			x = new int[n];
			//집의 좌표 입력
			for(int i=0;i<x.length;i++) {
				x[i]=sc.nextInt();
			}
			Arrays.sort(x);
			//이분탐색
			//최단거리
			int left = 1;
			//정답변수
			int ans = 1;
			//최장거리
			int right = x[x.length-1]-x[0];
			while(left<=right) {
				//반복 시 새로 측정되는 인접 공유기 간 기준거리
				int mid = (left+right)/2;
				if(result(mid)) {
					left=mid+1;
					ans=Math.max(ans, mid);
				}else {
					right=mid-1;
				}
			}
			System.out.println(ans);
		}
	}
}
