package test_190211;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//n���� �л����� �� ���� ��, �� �л��� Ű�� ���ϴ� ����� Ȱ���� ��� �Էµ� ������ �������� �л����� ���� ����� ���α׷� �ۼ��ϱ�
public class B_2252 {

	//�л� ��
	static int n;
	//��������
	static int m;
	//��������
	static int [] inDegree;
	//��������
	static ArrayList<Integer> [] A;
	
	//�������� �˰��� Ȱ��
	public static void topologySort() {
		//1������ n������ �л� ����
		int [] result = new int[n+1];
		Queue<Integer> q = new LinkedList<>();
		//���������� 0�� �л� ť�� ����
		for(int i=1;i<=n;i++) {
			if(inDegree[i]==0) {
				q.add(i);
			}
		}
		//Ž�� ����
		for(int i=1;i<=n;i++) {
			if(q.isEmpty()) {
				System.out.println("����Ŭ�� �߻��մϴ�.");
				return;
			}
			int x = q.poll();
			result[i]=x;
			//x�� �л����� ū �л��� ����ŭ �ݺ��� ����
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
		if(n<=32000&&m<=100000) {
			inDegree = new int[n+1];
			A = new ArrayList[n+1];
			//�ν��Ͻ� ����
			Arrays.fill(A, new ArrayList<>());
			
			//���� ���� �Է�(�� �л��� Ű ��)
			for(int i=0;i<m;i++) {
				int tmp1 = sc.nextInt();
				int tmp2 = sc.nextInt();
				//��������
				A[tmp1].add(tmp2);
				//�������� ����
				inDegree[tmp2]++;
			}
			topologySort();
		}	
	}
}
