package test_190114;

import java.util.ArrayList;
import java.util.Scanner;

//��Ģ�� �°� �ԷµǴ� �������̰� �־��� ��, �� �ӿ��� Ȧ���� �����ϴ� ������ �� ���� ����ϱ�
public class B_1637 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		//�������� ���� �����迭
		ArrayList<Integer> list = new ArrayList<>();
		
		if(1<=n&&n<=20000) {
			int k = 0;
			while(k<n) {
				int tmp1 = sc.nextInt();
				int tmp2 = sc.nextInt();
				int tmp3 = sc.nextInt();
				list.add(tmp1);
				//�������� �Է�
				for(int i=1;tmp1+tmp3*i<=tmp2;i++) {
					list.add(tmp1+tmp3*i);
				}
				k++;
			}
			//�����ϴ� ���� ������ ����
			int cnt = 0;
			for(int i=0;i<list.size()-1;i++) {
				cnt++;
				for(int j=i+1;j<list.size();j++) {
					if(list.get(i)==list.get(j)) {
						cnt++;
					}
				}
				if(cnt%2==1) {
					System.out.println(list.get(i));
					System.out.println(cnt);
					break;
				}
				cnt=0;
			}
		}
	}
}
