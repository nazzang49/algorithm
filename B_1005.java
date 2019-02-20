package test_190220;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//건물 n개의 건설과 관련하여 건설 규칙 m개가 소요 시간과 함께 주어질 때, 특정 건물을 건설 완료하는데 걸리는 시간 구하기
public class B_1005 {

	static int n;
	static int m;
	static ArrayList<Integer> [] A;
	static int [] inD;
	static int [] time;
	
	//위상정렬
	public static int topologySort(int e) {
		int [] result = new int[n+1];
		//진입차수 = 0 -> 큐에 저장
		Queue<Integer> q = new LinkedList<>();
		for(int i=1;i<=n;i++) {
			if(inD[i]==0) {
				q.add(i);
				result[i]=time[i];
			}
		}
		//정렬 실행
		for(int i=1;i<=n;i++) {
			int x = q.poll();
			for(int j=0;j<A[x].size();j++) {
				//x와 연결된 y
				int y = A[x].get(j);
				if(--inD[y]==0) {
					q.add(y);
				}
				result[y]=Math.max(result[y], result[x]+time[y]);
			}
		}
		return result[e];
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		if(t<=1000) {
			int [] ans = new int[t];
			int k = 0;
			while(k<t) {
				//건물 갯수
				n = sc.nextInt();
				//규칙 갯수
				m = sc.nextInt();
				//시간 입력
				time = new int[n+1];
				for(int i=1;i<=n;i++) time[i]=sc.nextInt();
				A=new ArrayList[n+1];
				inD = new int[n+1];
				for(int i=1;i<=n;i++) {
					A[i]=new ArrayList<>();
				}
				//간선 정보 입력
				for(int i=0;i<m;i++) {
					int tmp1 = sc.nextInt();
					int tmp2 = sc.nextInt();
					A[tmp1].add(tmp2);
					inD[tmp2]++;
				}
				//탐색 실행
				ans[k]=topologySort(sc.nextInt());
				k++;
			}
			//정답 출력
			for(int i=0;i<ans.length;i++) {
				System.out.println(ans[i]);
			}
		}
	}
}
