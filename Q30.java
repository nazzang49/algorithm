package solution;

import java.util.ArrayList;
import java.util.Scanner;

//�ڿ��� �迭, ������ �и� �־��� �� ���������� ���� ����ϱ�
public class Q30 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		//�迭�� ���� �� ������ �и�(�ڿ���)
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		if(1<=n&&1<=k) {
			//�Է�
			ArrayList<Integer> list = new ArrayList<>();
			for(int i=0;i<n;i++) {
				int tmp = sc.nextInt();
				if(1<=tmp) {
					if(tmp%k==0) {
						list.add(tmp);
					}
				}
			}
			if(list.isEmpty()) {
				System.out.println(-1);
			}else {
				for(int i=0;i<list.size()-1;i++) {
					for(int j=i;j<list.size();j++) {
						if(list.get(i)>=list.get(j)) {
							int tmp = list.get(i);
							list.set(i, list.get(j));
							list.set(j, tmp);
						}
					}
				}
				for(int i=0;i<list.size();i++) {
					System.out.print(list.get(i)+" ");
				}
			}
		}
	}
}
