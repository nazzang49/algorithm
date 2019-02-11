package test_190211;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//위상정렬 = 순서가 정해져 있는 작업을 차례로 수행할 때, 그 순서를 결정해주기 위해 사용하는 알고리즘
//큐를 활용하여 구현 가능
//위상정렬의 시간 복잡도 = 정점 갯수 + 간선 갯수(매우 빠른 탐색 속도라고 할 수 있음)

//(구현 방법)
//1) 진입 차수가 0인 특정 정점 큐에 저장(시작)
//2) 큐에서 원소를 꺼내 모든 간선 제거
//3) 제거 이후 진입 차수가 0이 된 정점 다시 큐에 저장
//4) 큐가 빌 때까지 2,3번 과정 반복
public class TopologySort {

	static int n;
	static int [] inDegree;
	static ArrayList<Integer> [] A;
	
	public static void topologySort() {
		int [] result = new int[10];
		Queue<Integer> q = new LinkedList<>();
		for(int i=1;i<=n;i++) {
			//진입차수가 0인 정점 큐에 저장(1번)
			if(inDegree[i]==0) {
				q.add(i);
			}
		}
		//큐 탐색 실행
		for(int i=1;i<=n;i++) {
			//n개 방문 전 큐가 비는 경우 = 사이클
			if(q.isEmpty()) {
				System.out.println("사이클이 발생합니다.");
				return;
			}
			//가장 앞에 있는 정점 추출(진입차수 = 0)
			int x = q.peek();
			q.poll();
			//순서 출력할 정답 배열
			result[i]=x;
			//x정점과 연결된 모든 간선 제거 작업
			for(int j=0;j<A[x].size();j++) {
				int y = A[x].get(j);
				//새롭게 진입차수가 0이 된 정점 큐에 저장
				if(--inDegree[y]==0) {
					q.add(y);
				}
			}
		}
		for(int i=1;i<=n;i++) {
			System.out.println(result[i]);
		}
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		//노드의 갯수 = 7개로 설정
		n = 7;
		//간선 및 진입 차수 설정(편의상 10)
		inDegree = new int[10];
		A = new ArrayList[10];
		for(int i=0;i<=n;i++) {
		A[i]=new ArrayList<>();
		}
		
		//간선 정보 및 진입차수 입력
		A[1].add(2);
		inDegree[2]++;
		A[1].add(5);
		inDegree[5]++;
		A[2].add(3);
		inDegree[3]++;
		A[3].add(4);
		inDegree[4]++;
		A[4].add(6);
		inDegree[6]++;
		A[5].add(6);
		inDegree[6]++;
		A[6].add(7);
		inDegree[7]++;
		
		topologySort();
	}
}
