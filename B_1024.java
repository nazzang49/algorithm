package test_190131;

import java.util.ArrayList;
import java.util.Scanner;

//���� n�̸鼭, ���̰� �ּ� l�̻��� �ּ� ������ ���ӵ� �� ����Ʈ ���ϱ�
public class B_1024 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int l = sc.nextInt();
		
		if(n<=1000000000&&2<=l&&l<=100) {
			ArrayList<Integer> ans = new ArrayList<>();
			//l���� ����Ʈ�� ���̸� 1�� ������Ű�鼭 ���ӵ� �� ���� �� = n �Ǻ�
			while(l<101) {
				//(�Ϲ�ȭ) n = l * x + l * (l-1) / 2
				int x = (n-l*(l-1)/2);
				if(x%l==0&&x>=0) {
					x=x/l;
					for(int i=0;i<l;i++) {
						ans.add(x+i);
					}
					break;
				}
				l++;
			}
			//�׷��� ������ �������� ������
			if(l==101) {
				System.out.println(-1);
			}
			for(int i=0;i<ans.size();i++) {
				System.out.println(ans.get(i));
			}
		}
	}
}
