package test_190212;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//n���� ������ �⿬�ϴ� ���α׷��� ������ ���ϱ� ���� m�� ���� PD���� ���� ���� ���� ���� �Է����� �־��� ��, ��� �������� �⿬ ���� ����ϱ�
public class B_2623 {

	static int n;
	static int m;
	static int [] inDegree;
	static ArrayList<Integer> [] A;
	
	public static void topologySort() {
		int [] result = new int[n+1];
		Queue<Integer> q = new LinkedList<>();
		//���� ������ 0�� ���� ��ȣ ť�� ����
		for(int i=1;i<=n;i++) {
			if(inDegree[i]==0) q.add(i);
		}
		//���� ����
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
		//���� ���
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
			
			//�� ���� PD�� ������ ������ �⿬ ����
			for(int i=1;i<=m;i++) {
				ArrayList<Integer> list = new ArrayList<>();
				//���� ���� �ο� ��
				int num = sc.nextInt();
				for(int j=1;j<=num;j++) {
					list.add(sc.nextInt());
				}
				//���İ��� �Է�
				for(int k=0;k<list.size()-1;k++) {
					A[list.get(k)].add(list.get(k+1));
					inDegree[list.get(k+1)]++;
				}
			}
			topologySort();
		}else {
			System.out.println("�Է� ������ Ȯ�����ּ���.");
			System.exit(0);
		}
	}
}
