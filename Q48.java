package solution;

import java.util.Scanner;

//n�� ũ�⿡ ���� "����" ���ڿ��� �ݺ��ؼ� ����ϴ� ���α׷� �����ϱ�
public class Q48 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		if(1<=n&&n<=10000) {
			String str = "";
			for(int i=0;i<n;i++) {
				if(i%2==0) {
					str+="��";
				}else {
					str+="��";
				}
			}
			System.out.println(str);
		}
	}
}
