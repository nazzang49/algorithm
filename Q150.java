package solution;

import java.util.ArrayList;
import java.util.Scanner;

//주어지는 그래프가 이분 그래프(정점의 집합을 2개 그룹으로 분할했을 때 부분집합 내 정점들끼리 서로 인접하지 않는)인지 아닌지 판별하는 프로그램 작성하기
//(포인트) 어느 하나의 노드라도 부분집합으로 나뉠 수 없는 경우 이분그래프가 될 수 없음
public class Q150 {

	static boolean [] visited;
	static boolean [][] line;
	static int v;
	static int e;
	
	public static boolean dfs(int now, int count, ArrayList<Integer> list) {
		count++;
		for(int i=1;i<=v;i++) {
			//도달 경로가 있고, 아직 방문하지 않았으며 직접적으로 인접하지 않은 노드일 경우
			if(!visited[i]&&line[now][i]&&count==2) {
				visited[i]=true;
				list.add(i);
			}
			//바로 인접한 노드의 경우(재귀 호출만)
			else if(!visited[i]&&line[now][i]&&count==1) {
				dfs(i,count,list);
			}
		}
		if(list.size()>1) {
			//형성된 그룹 내 인접한 노드가 있는지 확인
			for(int i=0;i<list.size()-1;i++) {
				for(int j=i+1;j<list.size();j++) {
					//인접하다면
					if(line[list.get(i)][list.get(j)]) {
						return false;
					}
				}
			}	
		}
		return true;
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		if(1<=t&&t<=5) {
			String [] ans = new String[t];
			int k = 0;
			while(k<t) {
				//정점 갯수
				v = sc.nextInt();
				//간선 갯수
				e = sc.nextInt();
				line = new boolean[v+1][v+1];
				visited = new boolean[v+1];
				ArrayList<Integer> list = new ArrayList<>();
				//간선 정보 입력
				for(int i=0;i<e;i++) {
					int tmp1 = sc.nextInt();
					int tmp2 = sc.nextInt();
					//두 노드 간의 연결 O
					line[tmp1][tmp2]=line[tmp2][tmp1]=true;
				}
				boolean flag = false;
				//각 노드(1번 ~ v번) 마다 탐색 실행(하나라도 false 반환 시, 이분그래프 될 수 없음)
				for(int i=1;i<=v;i++) {
					//아직 방문하지 않은 경우
					if(!visited[i]) {
						visited[i]=true;
						list.add(i);
						flag = dfs(i,0,list);
						//규칙을 만족하지 못하는 경우
						if(!flag) {
							break;
						}
						list.clear();
					}
				}
				if(!flag) {
					ans[k]="NO";
				}else {
					ans[k]="YES";
				}
				k++;
			}
			for(int i=0;i<ans.length;i++) {
				System.out.println(ans[i]);
			}
		}
	}
}
