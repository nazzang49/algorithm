package test_190212;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

//n���� �������� Ǯ ��, ���� Ǯ��� �ϴ� ������ ���� ������ ��Ģ���� �־��� �� ��� ������ Ǫ�� ���� ����ϱ�
public class B_1766 {

	//��� ���� ����
	static int n;
	//���İ��� ����
	static int m;
	//�� ������ ��������
	static int [] inDegree;
	//�������� ���İ���
	static ArrayList<Integer> [] A;
	
	public static void topologySort() {
		//�������� ����� �迭
		int [] result = new int[n+1];
		PriorityQueue<Integer> q = new PriorityQueue<Integer>();
		//���������� 0�� �ͺ��� ���ʴ�� ť�� ����
		for(int i=1;i<=n;i++) {
			if(inDegree[i]==0) {
				q.add(i);
			}
		}
		//�������� ����
		for(int i=1;i<=n;i++) {
			int x = q.poll();
			result[i]=x;
			for(int j=0;j<A[x].size();j++) {
				int y = A[x].get(j);
				//���� �ϳ� ���� �� ���������� 0�� �Ǵ� �ε��� �ٽ� ť�� ����
				if(--inDegree[y]==0) {
					q.add(y);
				}
			}
		}
		//���� �迭 ���
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
			
			//���İ��� ���� �Է�
			for(int i=1;i<=m;i++) {
				//���� ���
				int s = sc.nextInt();
				//���� ���
				int e = sc.nextInt();
				
				A[s].add(e);
				//���� ����� ���� ����
				inDegree[e]++;
			}
			topologySort();
		}	
	}
}
