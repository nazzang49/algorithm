package solution;

import java.util.Scanner;

//�Էµ� ���ڿ��� �κ� ���ڿ� �� ���� �� �Ӹ����(�յڸ� �ٲپ ���� ���ڿ��� �Ǵ�) ���� ���ϱ�
public class Q44 {

	static String str;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		str = sc.next();
		
		//� ���ڸ� �������� �������� index�� �̵��ϸ鼭 �� ���� �� ���� ��
		if(1<=str.length()&&str.length()<=2500) {
			//�� ���̽��� �ִ밪 ����
			int max = Integer.MIN_VALUE;
			for(int i=0;i<str.length();i++) {
				//�ε��� ��ġ
				int idx = 1;
				//�� ���̽��� �Ӹ���� ����
				int cnt = 1;				
				while(true) {
					//���ϰ��� �ϴ� �ε����� ���ڿ� ���� ����� ���
					if(i-idx<0||i+idx>=str.length()) {
						break;
					}
					//�Ӹ������ �Ǵ� ���
					if(str.charAt(i-idx)==str.charAt(i+idx)) {
						//������ 1, ���� 1 ���� 2 ���� ����
						cnt+=2;
						idx++;
					}else {
						break;
					}
				}
				if(cnt>=max) {
					max=cnt;
				}
			}
			System.out.println(max);
		}
	}
}
