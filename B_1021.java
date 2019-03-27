package test_190327;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.Scanner;

//����� ť���� ���ϴ� ��ġ�� �ִ� �����͸� �ּ� �������� �̴� ����� �� ���ϱ�
public class B_1021 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		if(n<=50&&m<=n) {
			//����� ť = ��ũ
			Deque<Integer> dq = new ArrayDeque<>();
			//���� �Է�
			for(int i=1;i<=n;i++) {
				//�ܼ� add�� �տ������� ���ʷ� ������ �Է��ϴ� ���
				dq.add(i);
			}
			
			int cnt = 0;
			//ã���� �ϴ� ���� �Է� �� Ž��
			for(int i=0;i<m;i++) {
				int tmp = sc.nextInt();
				while(true) {
					int idx = 0;
					Iterator<Integer> it = dq.iterator();
					while(it.hasNext()) {
						if(it.next()==tmp) break;
						idx++;
					}
					//ã���� �ϴ� ������ ���� �տ� ��ġ�� ������ = �ٷ� ���(�� ���� ���, ���ʰ� ������ �� ��� �� ������� ���)
					if(idx==0) {
						dq.pollFirst();
						break;
					}
					//���� ����
					else if(dq.size()/2>=idx) {
						dq.addLast(dq.pollFirst());
						cnt++;
					}
					//������ ����
					else {
						dq.addFirst(dq.pollLast());
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}	
	}
}
