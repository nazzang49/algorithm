package test_190118;

import java.util.Scanner;

//���ڿ��� ���̰� �Էµ� ��, ���ĺ� �빮�ڸ� �����Ͽ� ���� �� �ִ� ���� ���� ideal string ����ϱ�
public class B_1352 {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		//���ĺ� �빮�ڸ� �������� Ž��
		if(1<=n&&n<=100) {
			String tmp = "";
			int idx = n/2;
			if(n%2!=0) {
				idx++;
			}
			//���ڿ��� �߰����� �������� ���� ���ĺ� ������� ä���ش�
			for(int i=0;i<idx;i++) {
				tmp+=(char)(65+i);
			}
			//������ �ε������� ������� ������ŭ ä���� ���� �ݺ��ؼ� �÷��ش�
			for(int i=tmp.length()-1;i>=0;i--) {
				for(int j=0;j<i;j++) {
					tmp+=tmp.charAt(i);
				}
			}
			if(tmp.length()!=n) {
				System.out.println(-1);
				System.exit(0);
			}else {
				System.out.println(tmp);
			}
		}
	}
}
