package test_190220;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//�ǹ� n���� �Ǽ��� �����Ͽ� �Ǽ� ��Ģ m���� �ҿ� �ð��� �Բ� �־��� ��, Ư�� �ǹ��� �Ǽ� �Ϸ��ϴµ� �ɸ��� �ð� ���ϱ�
public class B_1005 {

	static int n;
	static int m;
	static ArrayList<Integer> [] A;
	static int [] inD;
	static int [] time;
	
	//��������
	public static int topologySort(int e) {
		int [] result = new int[n+1];
		//�������� = 0 -> ť�� ����
		Queue<Integer> q = new LinkedList<>();
		for(int i=1;i<=n;i++) {
			if(inD[i]==0) {
				q.add(i);
				result[i]=time[i];
			}
		}
		//���� ����
		for(int i=1;i<=n;i++) {
			int x = q.poll();
			for(int j=0;j<A[x].size();j++) {
				//x�� ����� y
				int y = A[x].get(j);
				if(--inD[y]==0) {
					q.add(y);
				}
				result[y]=Math.max(result[y], result[x]+time[y]);
			}
		}
		return result[e];
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		if(t<=1000) {
			int [] ans = new int[t];
			int k = 0;
			while(k<t) {
				//�ǹ� ����
				n = sc.nextInt();
				//��Ģ ����
				m = sc.nextInt();
				//�ð� �Է�
				time = new int[n+1];
				for(int i=1;i<=n;i++) time[i]=sc.nextInt();
				A=new ArrayList[n+1];
				inD = new int[n+1];
				for(int i=1;i<=n;i++) {
					A[i]=new ArrayList<>();
				}
				//���� ���� �Է�
				for(int i=0;i<m;i++) {
					int tmp1 = sc.nextInt();
					int tmp2 = sc.nextInt();
					A[tmp1].add(tmp2);
					inD[tmp2]++;
				}
				//Ž�� ����
				ans[k]=topologySort(sc.nextInt());
				k++;
			}
			//���� ���
			for(int i=0;i<ans.length;i++) {
				System.out.println(ans[i]);
			}
		}
	}
}
