package test_190114;

import java.util.Scanner;

//���ؿ��� �ܾ �����Ǵ� ��Ģ�� ���� ��, �Է����� �־����� �ܾ� �� �л����� ���� �� �ִ� �ܾ��� ���� �ִ밪 ����ϱ�
public class B_1062 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		//���� �����ϴ� �ܾ��� ����
		int cnt = 0;
		
		if(1<=n&&n<=50&&0<=k&&k<=26) {
			if(k<5) {
				System.out.println("�ܾ ���� �� �����ϴ�.");
				System.exit(0);
			}
			int j = 0;
			while(j<n) {
				//�Է����� �־����� ���ڿ�
				String str = sc.next();
				//���ĺ��� ���忩�� ������ �迭
				int [] alpha = new int[26];
				int tmp = k;
				for(int i=0;i<str.length();i++) {
					//���� ������ ���ڿ��̸�
					if(alpha[str.charAt(i)-'a']==0) {
						alpha[str.charAt(i)-'a']++;
						tmp--;
					}
				}
				//���� �� �ִ� ���
				if(tmp>=0) {
					cnt++;
				}
				j++;
			}
			System.out.println(cnt);
		}
	}
}
