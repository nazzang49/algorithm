package solution;

import java.util.Arrays;
import java.util.Scanner;

//추의 무게가 들어있는 배열이 주어질 때 해당 추들의 조합으로 측정할 수 없는 무게의 최소값 구하기
public class Q46 {

	static boolean [] visited;
	static int [] arr;
	static int cnt = 0;
	
	public static void dfs(int start, int sum, int target) {
		//추들의 부분합으로 타깃 숫자 측정 가능하면
		if(sum==target) {
			cnt++;
		}else if(sum<target) {
			for(int i=start;i<visited.length;i++) {
				if(!visited[i]) {
					visited[i]=true;
					sum+=arr[i];
					dfs(i,sum,target);
					sum-=arr[i];
					visited[i]=false;
				}
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		if(1<=n&&n<=10000) {
			visited = new boolean[n];
			arr = new int[n];
			//추 무게 입력
			for(int i=0;i<n;i++) {
				arr[i]=sc.nextInt();
			}
			//실행(오름차순 정렬)
			Arrays.sort(arr);
			int i=0;
			int tmp = 0;
			while(i<n) {
				visited[i]=true;
				dfs(i,arr[i],tmp+1);
				//무게 추의 조합으로 표현 가능한 수이면
				if(cnt!=0) {
					tmp++;
					cnt=0;
					i=0;
					visited[i]=false;
					continue;
				}
				visited[i]=false;
				i++;
			}
			System.out.println(tmp+1);
		}
	}
}
