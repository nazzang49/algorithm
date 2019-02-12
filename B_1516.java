package test_190212;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//n���� ������ ��ġ�� ��, ��ġ�ϴµ� �ɸ��� �ð��� ���� ��ġ�ؾ� �ϴ� ������ ��ȣ�� �־��� �� �� ������ ��ġ�ϴµ� �ɸ��� �ּҽð� ����ϱ�
public class B_1516 {
	
	static int n;
	static int [] inDegree;
	//�� ������ ��ġ�ϴµ� �ɸ��� �ð�
	static int [] time;
	static ArrayList<Integer> [] A;
	
	//���� ����
	public static void topologySort() {
		Queue<Integer> q = new LinkedList<>();
		//���������� 0�� ���� �ε����� ����
		for(int i=1;i<=n;i++) {
			if(inDegree[i]==0) {
				q.add(i);
			}
		}
		//���� ����
		for(int i=1;i<=n;i++) {
			int x = q.poll();
			//���� �۾� ���� �۾� Ž��
			for(int j=0;j<A[x].size();j++) {
				int y = A[x].get(j);
				if(--inDegree[y]==0) {
					//���� ��ġ �ð��� ���� ��ġ �ð� ����
					time[y]+=time[x];
					q.add(y);
				}
			}
		}
		//���� ���
		for(int i=1;i<=n;i++) System.out.println(time[i]);
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		if(n<=500) {
			inDegree = new int[n+1];
			A = new ArrayList[n+1];
			time = new int[n+1];
			
			//�� ���Ӹ��� �� ���� ��ġ�Ǿ�� �� ���� ��ȣ ����(�ν��Ͻ� ����)
			for(int i=1;i<=n;i++) {
				A[i]=new ArrayList<>();
			}
			
			//�� ������ ��ġ�ϴµ� �ɸ��� �ð� �� ���� ��ġ ���� �Է�
			for(int i=1;i<=n;i++) {
				time[i]=sc.nextInt();
				while(true) {
					int tmp = sc.nextInt();
					if(tmp==-1) {
						break;
					}
					//���� ���� �� ���� ����
					A[tmp].add(i);
					inDegree[i]++;
				}
			}
			topologySort();
		}else {
			System.out.println("�Է� ������ Ȯ�����ּ���.");
			System.exit(0);
		}	
	}
}
