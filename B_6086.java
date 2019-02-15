package test_190215;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//������ ���� n�� �� ������ ������ �뷮�� �־��� ��, A���� Z���� �ѹ��� ���� �� �ִ� �ִ� ���� ���ϱ�(��Ʈ��ũ �÷ο�)
public class B_6086 {

	//������ ����
	static int n;
	//����
	static int [][] f;
	//�뷮
	static int [][] c;
	//���� �迭
	static ArrayList<Integer> [] A;
	//��� �迭
	static int [] d;
	static int result = 0;
	
	//BFS Ž�� Ȱ��
	public static void maxFlow(int s, int e) {
		while(true) {
			Arrays.fill(d, -1);
			Queue<Integer> q = new LinkedList<>();
			q.add(s);
			while(!q.isEmpty()) {
				int x = q.poll();
				for(int i=0;i<A[x].size();i++) {
					//x->y ���
					int y = A[x].get(i);
					//���� �ѹ��� ������� ���� ��������, ������ �뷮�� �����ִ� ���
					if(d[y]==-1&&c[x][y]-f[x][y]>0) {
						d[y]=x;
						q.add(y);
						//���� �����̸�
						if(y==e) {
							break;
						}
					}
				}
			}
			//�� �̻� ���� �������� �̵� �Ұ����ϸ�
			if(d[e]==-1) break;
			//���� ����� �ִ� ����(���� -> ���, �Ųٷ� ���ư��� �ִ� ���� ����)
			int flow = Integer.MAX_VALUE;
			for(int i=e;i!=s;i=d[i]) {
				flow=Math.min(flow, c[d[i]][i]-f[d[i]][i]);
			}
			//��� ���� ���� ����
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
			
			//������ ����
			for(int i=1;i<=n;i++) {
				//������ ���
				String s = sc.next();
				//������ ����
				String e = sc.next();
				int sInt = s.charAt(0)-'A'+1;
				int eInt = e.charAt(0)-'A'+1;
				if(e.equals("Z")) {
					eInt=n;
				}
				//����� ����(���� ���� ���)
				A[sInt].add(eInt);
				A[eInt].add(sInt);
				//������ �뷮 �Է�
				c[sInt][eInt]=sc.nextInt();
			}
			maxFlow(1,n);
			System.out.println(result);
		}
	}
}
