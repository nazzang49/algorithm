package test_190213;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//네트워크 플로우 = 특정 정점에서 어느 한 정점으로 데이터 전송 시 막힘 없이 한번에 전송 가능한 최대 유량 계산하는 알고리즘
//BFS 탐색 활용(=에드몬드-카프 알고리즘)
public class NetworkFlow {

	//정점의 갯수
	static int n;
	//간선 갯수
	static int m;
	//정점 방문 여부
	static int [] d;
	//각 정점의 용량(capacity), 초기값 = 입력
	static int [][] c;
	//각 정점의 유량(flow), 초기값 = 0
	static int [][] f;
	//인접 정점 정보
	static ArrayList<Integer> [] A;
	//정답으로 출력할 최대 유량
	static int result = 0;
	
	//최대 유량 구하는 메소드(출발 -> 도착)
	public static void maxFlow(int s, int e) {
		while(true) {
			//초기화
			Arrays.fill(d, -1);
			Queue<Integer> q = new LinkedList<>();
			q.add(s);
			while(!q.isEmpty()) {
				int x = q.poll();
				for(int i=0;i<A[x].size();i++) {
					int y = A[x].get(i);
					//방문하지 않은 노드 중 용량이 남은 경우(s->e로 이동 중)
					if(d[y]==-1&&c[x][y]-f[x][y]>0) {
						//경로를 기억하기 위한 방식(x->y)
						d[y]=x;
						q.add(y);
						//찾고자 하는 정점에 도착했으면
						if(y==e) {
							break;
						}
					}
				}
			}
			//모든 경로를 실행한 경우(무한반복 탈출)
			if(d[e]==-1) break;
			int flow = Integer.MAX_VALUE;
			//e->s로 거꾸로 돌아가면서 현재 경로의 최소 유량(=현재 경로를 정체없이 지날 수 있는 최대 유량) 확정
			for(int i=e;i!=s;i=d[i]) {
				//현재 노드로 오는 간선의 용량 - 유량
				flow = Math.min(flow, c[d[i]][i]-f[d[i]][i]);
			}
			//확정된 최소 유량만큼 현재 경로 유량 갱신
			for(int i=e;i!=s;i=d[i]) {
				f[d[i]][i]+=flow;
				//음의 유량값 갱신(새로 추가되는 만큼 감소)
				c[i][d[i]]-=flow;
			}
			result+=flow;
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		if(n<=1000) {
			//1 ~ n번 정점 존재
			d = new int[n+1];
			c = new int[n+1][n+1];
			f = new int[n+1][n+1];
			A = new ArrayList[n+1];
			
			//각 정점별 인접정점 입력을 위한 가변배열 생성
			for(int i=0;i<=n;i++) {
				A[i]=new ArrayList<>();
			}
			
			//간선 정보 입력(음의 유량 고려하기 위해 양방향으로 입 력)
			A[1].add(2);
			A[2].add(1);
			c[1][2] = 12;
			
			A[1].add(4);
			A[4].add(1);
			c[1][4] = 11;
			
			A[2].add(3);
			A[3].add(2);
			c[2][3] = 6;

			A[2].add(4);
			A[4].add(2);
			c[2][4] = 3;
			
			A[2].add(5);
			A[5].add(2);
			c[2][5] = 5;
			
			A[2].add(6);
			A[6].add(2);
			c[2][6] = 9;
			
			A[3].add(6);
			A[6].add(3);
			c[3][6] = 8;
			
			A[4].add(5);
			A[5].add(4);
			c[4][5] = 9;
			
			A[5].add(3);
			A[3].add(5);
			c[5][3] = 3;

			A[5].add(6);
			A[6].add(5);
			c[5][6] = 4;
			
			//네트워크 플로우 알고리즘 실행
			maxFlow(1,6);
			System.out.println(result);
		}	
	}
}
