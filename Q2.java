package solution;

import java.util.Scanner;

//�Է¹��� ���ڿ��� ��� ���� ��ȯ�ϱ�(���̰� ¦���̸� �α��� ��ȯ)
public class Q2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		if(1<=t&&t<=1000) {
			String [] answer = new String[t];
			int k = 0;
			while(k<t) {
				String str = sc.next();
				if(1<=str.length()&&str.length()<=100) {
					String tmp = "";
					//���̰� ¦���̸�
					if(str.length()%2==0) {
						tmp=str.substring(str.length()/2-1, str.length()/2+1);
					}
					//���̰� Ȧ���̸�
					else {
						tmp+=str.charAt(str.length()/2);
					}
					answer[k]=tmp;
				}else {
					System.out.println("�Է� ��Ģ�� Ȯ�����ּ���.");
					System.exit(0);
				}
				k++;
			}
			for(int i=0;i<answer.length;i++) {
				System.out.println(answer[i]);
			}
		}
	}
}
