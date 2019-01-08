package solution;

import java.util.Arrays;
import java.util.Scanner;

//가장 인접한 공유기 간 거리가 최대가 되도록 하는 결과값 출력하기
public class Q144 {

	static int [] x;
	static int c;
	static int max = Integer.MIN_VALUE;
	
	public static void dfs(int now, int [] dis, int count) {
		//공유기 모두 설치했을 때
		if(count==c) {
			Arrays.sort(dis);
			if(max<=dis[0]) {
				max=dis[0];
			}
		}else {
			count++;
			for(int i=now+1;i<x.length;i++) {
				dis[count-2]=x[i]-x[now];
				dfs(i,dis,count);
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		c = sc.nextInt();
		
		if(2<=n&&n<=200000&&2<=c&&c<=200000) {
			x = new int[n];
			int [] dis = new int[c-1];
			//집의 위치 입력
			for(int i=0;i<n;i++) {
				x[i]=sc.nextInt();
			}
			//집의 위치 오름차순 정렬
			Arrays.sort(x);
			for(int i=0;i<x.length;i++) {
				dfs(i,dis,1);
			}
			System.out.println(max);
		}
	}
}
