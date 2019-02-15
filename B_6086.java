package test_190215;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//파이프 갯수 n과 각 구간별 파이프 용량이 주어질 때, A부터 Z까지 한번에 보낼 수 있는 최대 유량 구하기(네트워크 플로우)
public class B_6086 {

	//파이프 갯수
	static int n;
	//유량
	static int [][] f;
	//용량
	static int [][] c;
	//간선 배열
	static ArrayList<Integer> [] A;
	//경로 배열
	static int [] d;
	static int result = 0;
	
	//BFS 탐색 활용
	public static void maxFlow(int s, int e) {
		while(true) {
			Arrays.fill(d, -1);
			Queue<Integer> q = new LinkedList<>();
			q.add(s);
			while(!q.isEmpty()) {
				int x = q.poll();
				for(int i=0;i<A[x].size();i++) {
					//x->y 경로
					int y = A[x].get(i);
					//아직 한번도 사용하지 않은 파이프고, 파이프 용량이 남아있는 경우
					if(d[y]==-1&&c[x][y]-f[x][y]>0) {
						d[y]=x;
						q.add(y);
						//도착 지점이면
						if(y==e) {
							break;
						}
					}
				}
			}
			//더 이상 도착 지점으로 이동 불가능하면
			if(d[e]==-1) break;
			//현재 경로의 최대 유량(도착 -> 출발, 거꾸로 돌아가며 최대 유량 갱신)
			int flow = Integer.MAX_VALUE;
			for(int i=e;i!=s;i=d[i]) {
				flow=Math.min(flow, c[d[i]][i]-f[d[i]][i]);
			}
			//양과 음의 유량 증가
			for(int i=e;i!=s;i=d[i]) {
				f[d[i]][i]+=flow;
				c[i][d[i]]-=flow;
			}
			result+=flow;
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		if(n<=700) {
			c = new int[n+1][n+1];
			f = new int[n+1][n+1];
			A = new ArrayList[n+1];
			d = new int[n+1];
			
			for(int i=1;i<=n;i++) {
				A[i]=new ArrayList<>();
			}
			
			//파이프 생성
			for(int i=1;i<=n;i++) {
				//파이프 출발
				String s = sc.next();
				//파이프 도착
				String e = sc.next();
				int sInt = s.charAt(0)-'A'+1;
				int eInt = e.charAt(0)-'A'+1;
				if(e.equals("Z")) {
					eInt=n;
				}
				//양방향 연결(음의 유량 고려)
				A[sInt].add(eInt);
				A[eInt].add(sInt);
				//파이프 용량 입력
				c[sInt][eInt]=sc.nextInt();
			}
			maxFlow(1,n);
			System.out.println(result);
		}
	}
}
