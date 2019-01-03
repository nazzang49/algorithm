package solution1;

import java.util.Arrays;
import java.util.Scanner;

//팬의 수와 위치, 모든 팬들의 동일한 초기 만족도가 주어질 때 모두 포옹을 마친 후 얻을 있는 팬 만족도의 최대값 구하기(1초 경과 시 만족도 1 감소)
public class Q124 {

	//최대값 저장 변수
	static int max = Integer.MIN_VALUE;
	static boolean [] visited;
	static int k;
	static int n;
	static int [] x;
	
	public static void dfs(int start, int dis, int sum, int count) {
		if(count==n) {
			//이전 만족도의 합과 비교
			if(max<=sum) {
				max=sum;
			}
		}else {
			count++;
			for(int i=0;i<n;i++) {
				//방문하지 않은 팬이면
				if(!visited[i]) {
					visited[i]=true;
					//현재 위치까지 도달하기까지 걸린 전체 이동 거리
					dis+=Math.abs(x[i]-x[start]);
					if(k-dis>0) {
						//기본 만족도 - 누적 이동 거리(현재 위치에 있는 팬의 최종 만족도)
						sum+=(k-dis);
						dfs(i,dis,sum,count);
						sum-=(k-dis);
					}else {
						dfs(i,dis,sum,count);
					}
					dis-=Math.abs(x[i]-x[start]);
					visited[i]=false;
				}
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		
		if(0<=n&&n<=100&&1<=k&&k<=10000) {
			x = new int[n];
			visited = new boolean[n];
			//각 팬들의 위치 순서대로 입력
			for(int i=0;i<x.length;i++) {
				x[i]=sc.nextInt();
			}
			//팬들의 위치 오름차순 정렬
			Arrays.sort(x);
			//0에서부터 출발
			for(int i=0;i<x.length;i++) {
				visited[i]=true;
				//전체 만족도에서 첫번째 팬에게 이동하는 동안 감소하는 양 반영
				dfs(i,Math.abs(x[i]),k-Math.abs(x[i]),1);
				visited[i]=false;
			}
			System.out.println(max);
		}
	}
}
