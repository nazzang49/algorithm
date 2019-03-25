package test_190325;

import java.util.Scanner;

//1,2,3���θ� �̷���� ���̰� N�� ���� �� ���� ���� ������ �ΰ� �κ� ������ �������� ���� �� �� ���� ���� �� ���ϱ�
public class B_2661 {

	static int n;
	
	//���� �������� �Ǻ��� �޼ҵ�
	public static boolean flag(String str) {
		//���� ������ �κ� ���� ��
		for(int i=1;i<=str.length()/2;i++) {
			int j = 0;
			while(j+i+i<=str.length()) {
				//������ �κ� ������ ������
				if(str.substring(j, j+i).equals(str.substring(j+i, j+i+i))) {
					return false;
				}
				j++;
			}
		}
		return true;
	}
	
	public static void dfs(String str) {
		if(str.length()==n) {
			//���
			System.out.println(str);
			System.exit(0);
		}
		String tmp = str;
		//1~3�� ���ڸ� ��� ����
		for(int i=1;i<=3;i++) {
			tmp+=i;
			//���� ������ ��쿡�� ����ؼ� �ݺ�
			if(flag(tmp)) {
				dfs(tmp);
			}
			tmp = str;
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		//�ִ� 80�ڸ�
		if(n<=80) {
			dfs("1");
		}	
	}
}
