package test_190212;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//n명의 가수가 출연하는 프로그램에 순서를 정하기 위한 m명 보조 PD들의 임의 가수 순서 값이 입력으로 주어질 때, 모든 가수들의 출연 순서 출력하기
public class B_2623 {

	static int n;
	static int m;
	static int [] inDegree;
	static ArrayList<Integer> [] A;
	
	public static void topologySort() {
		int [] result = new int[n+1];
		Queue<Integer> q = new LinkedList<>();
		//진입 차수가 0인 가수 번호 큐에 저장
		for(int i=1;i<=n;i++) {
			if(inDegree[i]==0) q.add(i);
		}
		//위상 정렬
		for(int i=1;i<=n;i++) {
			int x = q.poll();
			result[i]=x;
			for(int j=0;j<A[x].size();j++) {
				int y = A[x].get(j);
				if(--inDegree[y]==0) {
					q.add(y);
				}
			}
		}
		//정답 출력
		for(int i=1;i<=n;i++) System.out.println(result[i]);
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		if(n<=1000&&m<=100) {
			inDegree = new int[n+1];
			A = new ArrayList[n+1];
			
			for(int i=1;i<=n;i++) A[i]=new ArrayList<>();
			
			//각 보조 PD가 선정할 임의의 출연 순서
			for(int i=1;i<=m;i++) {
				ArrayList<Integer> list = new ArrayList<>();
				//순서 정할 인원 수
				int num = sc.nextInt();
				for(int j=1;j<=num;j++) {
					list.add(sc.nextInt());
				}
				//선후관계 입력
				for(int k=0;k<list.size()-1;k++) {
					A[list.get(k)].add(list.get(k+1));
					inDegree[list.get(k+1)]++;
				}
			}
			topologySort();
		}else {
			System.out.println("입력 조건을 확인해주세요.");
			System.exit(0);
		}
	}
}
