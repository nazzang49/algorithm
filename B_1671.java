package test_190215;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//상어의 수 n, 각 상어의 크기, 속도, 지능이 주어질 때, 규칙에 의해 최종적으로 살아남을 수 있는 상어의 마릿수 최소값 출력하기(최대 두마리 사냥 가능)
public class B_1671 {

	static int n;
	static int min = 0;
	static boolean [] visit;
	//d의 인덱스 = 잡아먹는 상어, d의 값 = 잡아먹히는 상어
	static int [] d;
	//특정 상어와 잡아먹을 수 있는 상어를 간선으로 연결
	static ArrayList<Integer> [] A;
	//크기, 속도, 지능 입력할 배열
	static int [][] arr;
	
	public static boolean dfs(int cur) {
		if(visit[cur]) return false;
		visit[cur]=true;
		for(int i=0;i<A[cur].size();i++) {
			//cur 상어가 잡아 먹을 수 있는 상어 = x
			int x = A[cur].get(i);
			if(d[x]==0||dfs(d[x])) {
				d[x]=cur;
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		if(n<=50) {
			A = new ArrayList[n+1];
			visit = new boolean[n+1];
			d = new int[n+1];
			arr = new int[n+1][3];
			
			for(int i=1;i<=n;i++) {
				A[i]=new ArrayList<>();
			}
			
			//상어 제원 입력
			for(int i=1;i<=n;i++) {
				arr[i][0]=sc.nextInt();
				arr[i][1]=sc.nextInt();
				arr[i][2]=sc.nextInt();
			}
			
			//두 마리씩 제원 비교(잡아먹는 쪽 - 앞, 잡아먹히는 쪽 - 뒤)
			for(int i=1;i<=n;i++) {
				for(int j=i+1;j<=n;j++) {
					if(arr[i][0]>=arr[j][0]&&arr[i][1]>=arr[j][1]&&arr[i][2]>=arr[j][2]) {
						A[i].add(j);
					}else if(arr[j][0]>=arr[i][0]&&arr[j][1]>=arr[i][1]&&arr[j][2]>=arr[i][2]) {
						A[j].add(i);
					}
				}
			}
			
			//DFS 탐색 실행(이분매칭 - 탐색 두번 실행 = 두마리까지 먹을 수 있기 때문)
			for(int i=1;i<=n;i++) {
				Arrays.fill(visit, false);
				//잡아 먹을 수 있는 상어가 있으면(죽는 상어 수+1)
				if(dfs(i)) min++;
				Arrays.fill(visit, false);
				if(dfs(i)) min++;
			}
			System.out.println(n-min);
		}
	}
}
