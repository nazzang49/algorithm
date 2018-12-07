package solution;

import java.util.Scanner;

//��ȭ��ȣ�ο� ���� ��ȭ��ȣ �� �ٸ� ��ȣ�� ���ξ��� ��� ã��
public class Q21 {

	//��� �� ��ȣ�� �ٸ� ��ȣ�� ���ξ �Ǵ��� Ȯ���ϴ� �޼ҵ�
	public static boolean find(String [] phone) {
		for(int i=0;i<phone.length;i++) {
			String str = phone[i];
			for(int j=0;j<phone.length;j++) {
				if(i==j) continue;
				if(str.length()<=phone[j].length()) {
					String str_com=phone[j].substring(0, str.length());
					if(str.equals(str_com)) {
						return false;
					}
				}
			}
		}
		return true;
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		//��ȭ��ȣ�� ����
		int n = sc.nextInt();
		
		if(1<=n&&n<=1000000) {
			String [] phone = new String[n];
			//��ȭ��ȣ �Է�
			for(int i=0;i<n;i++) {
				String tmp = sc.next();
				if(1<=tmp.length()&&tmp.length()<=20) {
					phone[i]=tmp;
				}
			}
			boolean answer = find(phone);
			System.out.println(answer);
		}
	}
}
