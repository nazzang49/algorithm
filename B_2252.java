package test_190211;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//n명의 학생들을 줄 세울 때, 두 학생의 키를 비교하는 방법을 활용할 경우 입력된 정보를 바탕으로 학생들의 줄을 세우는 프로그램 작성하기
public class B_2252 {

	//학생 수
	static int n;
	//간선갯수
	static int m;
	//진입차수
	static int [] inDegree;
	//간선정보
	static ArrayList<Integer> [] A;
	
	//위상정렬 알고리즘 활용
	public static void topologySort() {
		//1번부터 n번까지 학생 존재
		int [] result = new int[n+1];
		Queue<Integer> q = new LinkedList<>();
		//진입차수가 0인 학생 큐에 저장
		for(int i=1;i<=n;i++) {
			if(inDegree[i]==0) {
				q.add(i);
			}
		}
		//탐색 실행
		for(int i=1;i<=n;i++) {
			if(q.isEmpty()) {
				System.out.println("사이클이 발생합니다.");
				return;
			}
			int x = q.poll();
			result[i]=x;
			//x번 학생보다 큰 학생의 수만큼 반복문 실행
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
		if(n<=32000&&m<=100000) {
			inDegree = new int[n+1];
			A = new ArrayList[n+1];
			//인스턴스 생성
			Arrays.fill(A, new ArrayList<>());
			
			//간선 정보 입력(두 학생의 키 비교)
			for(int i=0;i<m;i++) {
				int tmp1 = sc.nextInt();
				int tmp2 = sc.nextInt();
				//간선연결
				A[tmp1].add(tmp2);
				//진입차수 증가
				inDegree[tmp2]++;
			}
			topologySort();
		}	
	}
}
