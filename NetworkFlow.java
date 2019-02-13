package test_190213;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//��Ʈ��ũ �÷ο� = Ư�� �������� ��� �� �������� ������ ���� �� ���� ���� �ѹ��� ���� ������ �ִ� ���� ����ϴ� �˰���
//BFS Ž�� Ȱ��(=������-ī�� �˰���)
public class NetworkFlow {

	//������ ����
	static int n;
	//���� ����
	static int m;
	//���� �湮 ����
	static int [] d;
	//�� ������ �뷮(capacity), �ʱⰪ = �Է�
	static int [][] c;
	//�� ������ ����(flow), �ʱⰪ = 0
	static int [][] f;
	//���� ���� ����
	static ArrayList<Integer> [] A;
	//�������� ����� �ִ� ����
	static int result = 0;
	
	//�ִ� ���� ���ϴ� �޼ҵ�(��� -> ����)
	public static void maxFlow(int s, int e) {
		while(true) {
			//�ʱ�ȭ
			Arrays.fill(d, -1);
			Queue<Integer> q = new LinkedList<>();
			q.add(s);
			while(!q.isEmpty()) {
				int x = q.poll();
				for(int i=0;i<A[x].size();i++) {
					int y = A[x].get(i);
					//�湮���� ���� ��� �� �뷮�� ���� ���(s->e�� �̵� ��)
					if(d[y]==-1&&c[x][y]-f[x][y]>0) {
						//��θ� ����ϱ� ���� ���(x->y)
						d[y]=x;
						q.add(y);
						//ã���� �ϴ� ������ ����������
						if(y==e) {
							break;
						}
					}
				}
			}
			//��� ��θ� ������ ���(���ѹݺ� Ż��)
			if(d[e]==-1) break;
			int flow = Integer.MAX_VALUE;
			//e->s�� �Ųٷ� ���ư��鼭 ���� ����� �ּ� ����(=���� ��θ� ��ü���� ���� �� �ִ� �ִ� ����) Ȯ��
			for(int i=e;i!=s;i=d[i]) {
				//���� ���� ���� ������ �뷮 - ����
				flow = Math.min(flow, c[d[i]][i]-f[d[i]][i]);
			}
			//Ȯ���� �ּ� ������ŭ ���� ��� ���� ����
			for(int i=e;i!=s;i=d[i]) {
				f[d[i]][i]+=flow;
				//���� ������ ����(���� �߰��Ǵ� ��ŭ ����)
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
			//1 ~ n�� ���� ����
			d = new int[n+1];
			c = new int[n+1][n+1];
			f = new int[n+1][n+1];
			A = new ArrayList[n+1];
			
			//�� ������ �������� �Է��� ���� �����迭 ����
			for(int i=0;i<=n;i++) {
				A[i]=new ArrayList<>();
			}
			
			//���� ���� �Է�(���� ���� ����ϱ� ���� ��������� �� ��)
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
			
			//��Ʈ��ũ �÷ο� �˰��� ����
			maxFlow(1,6);
			System.out.println(result);
		}	
	}
}
