package test_190114;

import java.util.Scanner;

//������ ������ ���� Ư�� ���ϰ� ��ġ�ϴ� ���ڿ��� ��¿� ������ ���� ���, �Է����� �־����� ���ϸ��� �־��� ���ϰ� ��ġ�ϴ��� �Ǹ��ϴ� ���α׷� �ۼ��ϱ�
public class B_9996 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		if(1<=n&&n<=100) {
			//�־����� ���� ���ڿ�
			String pat = sc.next();
			String [] ans = new String[n];
			for(int i=0;i<n;i++) {
				//���� ���ڿ��� ���� �Է� ���ڿ�
				String str = sc.next();
				boolean flag = false;
				for(int j=0;j<str.length();j++) {
					if(pat.charAt(j)=='*') {
						break;
					}
					//��ǥ(������ ���ڿ��� �� �ڸ�)�� ������ �� ���ڿ��� �� �ڸ� ��(�տ�������)
					else if(str.charAt(j)!=pat.charAt(j)) {
						flag=true;
						break;
					}
				}
				//���� ���ڿ� ��� ��
				if(!flag) {
					for(int j=pat.length()-1;j>=0;j--) {
						if(pat.charAt(j)=='*') {
							break;
						}
						//��ǥ(������ ���ڿ��� �� �ڸ�)�� ������ �� ���ڿ��� �� �ڸ� ��(�ڿ�������)
						else if(str.charAt(j+str.length()-pat.length())!=pat.charAt(j)) {
							flag=true;
							break;
						}
					}
					//���� ���ڿ��� ��� ��
					if(!flag) {
						ans[i]="DA";
						continue;
					}
				}
				ans[i]="NE";
			}
			for(int i=0;i<ans.length;i++) {
				System.out.println(ans[i]);
			}
		}
	}
}
