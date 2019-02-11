package test_190211;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//�������� = ������ ������ �ִ� �۾��� ���ʷ� ������ ��, �� ������ �������ֱ� ���� ����ϴ� �˰���
//ť�� Ȱ���Ͽ� ���� ����
//���������� �ð� ���⵵ = ���� ���� + ���� ����(�ſ� ���� Ž�� �ӵ���� �� �� ����)

//(���� ���)
//1) ���� ������ 0�� Ư�� ���� ť�� ����(����)
//2) ť���� ���Ҹ� ���� ��� ���� ����
//3) ���� ���� ���� ������ 0�� �� ���� �ٽ� ť�� ����
//4) ť�� �� ������ 2,3�� ���� �ݺ�
public class TopologySort {

	static int n;
	static int [] inDegree;
	static ArrayList<Integer> [] A;
	
	public static void topologySort() {
		int [] result = new int[10];
		Queue<Integer> q = new LinkedList<>();
		for(int i=1;i<=n;i++) {
			//���������� 0�� ���� ť�� ����(1��)
			if(inDegree[i]==0) {
				q.add(i);
			}
		}
		//ť Ž�� ����
		for(int i=1;i<=n;i++) {
			//n�� �湮 �� ť�� ��� ��� = ����Ŭ
			if(q.isEmpty()) {
				System.out.println("����Ŭ�� �߻��մϴ�.");
				return;
			}
			//���� �տ� �ִ� ���� ����(�������� = 0)
			int x = q.peek();
			q.poll();
			//���� ����� ���� �迭
			result[i]=x;
			//x������ ����� ��� ���� ���� �۾�
			for(int j=0;j<A[x].size();j++) {
				int y = A[x].get(j);
				//���Ӱ� ���������� 0�� �� ���� ť�� ����
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
		//����� ���� = 7���� ����
		n = 7;
		//���� �� ���� ���� ����(���ǻ� 10)
		inDegree = new int[10];
		A = new ArrayList[10];
		for(int i=0;i<=n;i++) {
		A[i]=new ArrayList<>();
		}
		
		//���� ���� �� �������� �Է�
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
