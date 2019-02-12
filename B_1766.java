package test_190212;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

//n개의 문제들을 풀 때, 먼저 풀어야 하는 문제와 쉬운 문제가 규칙으로 주어질 시 모든 문제를 푸는 순서 출력하기
public class B_1766 {

	//모든 문제 갯수
	static int n;
	//선후관계 갯수
	static int m;
	//각 문제의 진입차수
	static int [] inDegree;
	//문제들의 선후관계
	static ArrayList<Integer> [] A;
	
	public static void topologySort() {
		//정답으로 출력할 배열
		int [] result = new int[n+1];
		PriorityQueue<Integer> q = new PriorityQueue<Integer>();
		//진입차수가 0인 것부터 차례대로 큐에 저장
		for(int i=1;i<=n;i++) {
			if(inDegree[i]==0) {
				q.add(i);
			}
		}
		//위상정렬 실행
		for(int i=1;i<=n;i++) {
			int x = q.poll();
			result[i]=x;
			for(int j=0;j<A[x].size();j++) {
				int y = A[x].get(j);
				//간선 하나 제거 후 진입차수가 0이 되는 인덱스 다시 큐에 저장
				if(--inDegree[y]==0) {
					q.add(y);
				}
			}
		}
		//정답 배열 출력
		for(int i=1;i<=n;i++) {
			System.out.println(result[i]);
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		if(n<=32000&&m<=100000) {
			inDegree = new int[n+1];
			A = new ArrayList[n+1];
			
			for(int i=1;i<=n;i++) {
				A[i]=new ArrayList<>();
			}
			
			//선후관계 정보 입력
			for(int i=1;i<=m;i++) {
				//시작 노드
				int s = sc.nextInt();
				//진입 노드
				int e = sc.nextInt();
				
				A[s].add(e);
				//진입 노드의 차수 증가
				inDegree[e]++;
			}
			topologySort();
		}	
	}
}
