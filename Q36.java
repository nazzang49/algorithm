package solution;

import java.util.Scanner;

//�� ���ڿ��� �ε��� n��° ���ڸ� �������� �������� �����ϱ�
public class Q36 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		if(1<=n&&n<=50) {
			String [] str = new String[n];
			//�Է�
			for(int i=0;i<str.length;i++) {
				String tmp = sc.next();
				if(1<=tmp.length()&&tmp.length()<=100) {
					str[i]=tmp;
				}
			}
			//Ž��
			for(int i=0;i<str.length-1;i++) {
				for(int j=i+1;j<str.length;j++) {
					if(str[i].charAt(k)>str[j].charAt(k)) {
						String tmp = str[i];
						str[i]=str[j];
						str[j]=tmp;
					}else if(str[i].charAt(k)==str[j].charAt(k)) {
						int m = 0;
						while(m<str[i].length()||m<str[j].length()) {
							//���ϰ��� �ϴ� ��ġ�� ���ڰ� ������ ���� �տ������� ���ʴ�� ���ϸ� ���� ����
							if(str[i].charAt(m)>str[j].charAt(m)) {
								String tmp = str[i];
								str[i]=str[j];
								str[j]=tmp;
								break;
							}
							m++;
						}
					}
				}
			}
			//��� ���
			for(int i=0;i<str.length;i++) {
				System.out.println(str[i]);
			}
		}
	}
}
