package solution;

import java.util.Scanner;

//����̰� �Է��� ���ڿ��� ���� ��, �Է°����� �־��� ���ĺ��� ������ �����ϴ� ���� �� �κ� ���ڿ� ���� ���ϱ� 
public class Q76 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		//�־����� ���ĺ� ����
		int n = sc.nextInt();
		String str = sc.next();
		int length = 0;
		int max = 0;
		int cnt = 0;
		//Ư�� ���ĺ��� ���� ���� �˻�
		int [] alpha = new int[26];
		
		for(int i=0;i<str.length()-1;i++) {
			alpha[str.charAt(i)-'a']++;
			cnt++;
			length++;
			for(int j=i+1;j<str.length();j++) {
				if(cnt<=n) {
					//�̹� ������ ���ĺ��̸�
					if(alpha[str.charAt(j)-'a']!=0) {
						length++;
					}
					//���� ������ ���ĺ��̸�(cnt+1)
					else {
						alpha[str.charAt(i)-'a']++;
						cnt++;
						if(cnt!=n) {
							length++;	
						}
					}					
				}else {
					//�ִ���� ��
					if(max<=length) {
						max=length;
					}
					//�ʱ�ȭ
					length=0;
					cnt=0;
					alpha = new int[26];
					break;
				}
			}
		}
		System.out.println(max);
	}
}
