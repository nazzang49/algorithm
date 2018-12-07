package solution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

class Docu {
	int idx, value;
	
	public Docu(int idx, int value) {
		this.idx=idx;
		this.value=value;
	}
}

//�μ��ϰ��� �ϴ� ������ �߿䵵, ����ڰ� ��û�� ������ ��ġ�� �־��� �� �ش� ������ �� ��°�� ��µǴ��� ���ϱ�
public class Q20 {

	public static void search(ArrayList<Docu> q, int x) {
		int k=1;
		while(!q.isEmpty()) {
			boolean flag = false;
			Docu d = q.get(0);
			for(int i=1;i<q.size();i++) {
				Docu d_com = q.get(i);
				//�� �ʿ� �켱������ ���� ���� �ϳ��� ������ ���� ���������� �̵�
				if(d.value<d_com.value) {
					flag=true;
					d = q.remove(0);
					q.add(d);
					break;
				}
			}
			//����̸�
			if(!flag) {
				Docu m = q.remove(0);
				//��û�� �����̸�
				if(m.idx==x) {
					System.out.println(k);
					System.exit(0);
				}
				k++;
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		//���� ������� ������ ��
		int n = sc.nextInt();
		//��û ������ ��ġ(��� ���� �迭�� idx)
		int m = sc.nextInt();
		ArrayList<Docu> list = new ArrayList<>();
		
		if(1<=n&&n<=100&&0<=m&&m<=n-1) {
			for(int i=0;i<n;i++) {
				int tmp = sc.nextInt();
				//�߿䵵 �Է�(1~9 / ���� Ŭ���� �켱 ���)
				if(1<=tmp&&tmp<=9) {
					//���� ���� ��� idx�� �Բ� ����
					list.add(new Docu(i, tmp));
				}
			}
			search(list, m);
		}
	}
}
