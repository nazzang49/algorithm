package test_190212;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//n개의 게임을 설치할 때, 설치하는데 걸리는 시간과 먼저 설치해야 하는 게임의 번호가 주어질 시 각 게임을 설치하는데 걸리는 최소시간 출력하기
public class B_1516 {
	
	static int n;
	static int [] inDegree;
	//각 게임을 설치하는데 걸리는 시간
	static int [] time;
	static ArrayList<Integer> [] A;
	
	//위상 정렬
	public static void topologySort() {
		Queue<Integer> q = new LinkedList<>();
		//진입차수가 0인 게임 인덱스에 저장
		for(int i=1;i<=n;i++) {
			if(inDegree[i]==0) {
				q.add(i);
			}
		}
		//위상 정렬
		for(int i=1;i<=n;i++) {
			int x = q.poll();
			//현재 작업 다음 작업 탐색
			for(int j=0;j<A[x].size();j++) {
				int y = A[x].get(j);
				if(--inDegree[y]==0) {
					//이전 설치 시간에 현재 설치 시간 누적
					time[y]+=time[x];
					q.add(y);
				}
			}
		}
		//정답 출력
		for(int i=1;i<=n;i++) System.out.println(time[i]);
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		if(n<=500) {
			inDegree = new int[n+1];
			A = new ArrayList[n+1];
			time = new int[n+1];
			
			//각 게임마다 그 다음 설치되어야 할 게임 번호 저장(인스턴스 생성)
			for(int i=1;i<=n;i++) {
				A[i]=new ArrayList<>();
			}
			
			//각 게임을 설치하는데 걸리는 시간 및 선행 설치 게임 입력
			for(int i=1;i<=n;i++) {
				time[i]=sc.nextInt();
				while(true) {
					int tmp = sc.nextInt();
					if(tmp==-1) {
						break;
					}
					//간선 연결 및 차수 증가
					A[tmp].add(i);
					inDegree[i]++;
				}
			}
			topologySort();
		}else {
			System.out.println("입력 조건을 확인해주세요.");
			System.exit(0);
		}	
	}
}
