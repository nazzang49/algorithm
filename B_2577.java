package test_190218;

import java.util.Scanner;

//A,B,C �� ���� ���� ����� 0~9������ ���ڰ� ��� ��� �������� ����ϱ�
public class B_2577 {

	//0~9���� �� ���ڰ� ��� �������� �迭 ��ȯ�� �޼ҵ�
	public static int [] result(int n) {
		int [] ans = new int[10];
		String str = String.valueOf(n);
		for(int i=0;i<str.length();i++) {
			ans[str.charAt(i)-'0']++;
		}
		return ans;
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		
		if(A<=1000&&B<=1000&&C<=1000) {
			int tmp = A*B*C;
			int [] ans = result(tmp);
			for(int i=0;i<ans.length;i++) {
				System.out.println(ans[i]);
			}
		}else System.out.println("�Է� ������ Ȯ���ϼ���.");
	}
}
