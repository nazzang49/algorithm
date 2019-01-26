package test_190126;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Q {
	int idx, point;
	
	public Q(int idx, int point) {
		this.idx=idx;
		this.point=point;
	}
}

//�����ͱ��� ���� �տ� �ִ� ������ �� �� �������� �߿䵵�� ���Ͽ� ����ϰų� ���� ������ ������ ������ ���α׷� �ۼ��ϱ� 
public class B_1966 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		int k = 0;
		int [] ans = new int[t];
		while(k<t) {
			//���� ����
			int n = sc.nextInt();
			//���� ���� ��ġ
			int m = sc.nextInt();
			
			Queue<Q> q = new LinkedList<>();
			//���� ������ �߿䵵 �Է�
			for(int i=0;i<n;i++) {
				q.add(new Q(i, sc.nextInt()));
			}
			
			int cnt = 0;
			while(!q.isEmpty()) {
				//���� �տ� �ִ� ���� ����
				Q q1 = q.poll();
				Iterator<Q> it = q.iterator();
				boolean flag = false;
				while(it.hasNext()) {
					//�ڿ� �ִ� ������ �߿䵵�� ũ��(���� ���� �ڷ� �̵�)
					if(q1.point<it.next().point) {
						flag=true;
						q.add(q1);
						break;
					}
				}
				//�ڿ� �ִ� ������ �߿䵵�� ���ų� ������(���� ���� ���)
				if(!flag) {
					cnt++;
					//���� �˰��� �ϴ� �����̸�
					if(q1.idx==m) {
						ans[k]=cnt;
						break;
					}
				}
			}
			k++;
		}
		for(int i=0;i<ans.length;i++) {
			System.out.println(ans[i]);
		}
	}
}
