package test_190114;

import java.util.Scanner;

//�α��̰� ��й�ȣ�� �Է��ϴ� ��Ģ�� �־��� ��, ������ �Ǵ� ��й�ȣ�� ���̿� ��� ���� ����ϱ�
public class B_9933 {

	public static boolean result(String str1, String str2) {
		for(int i=0;i<str1.length();i++) {
			//������ ���ڰ� �ٸ���
			if(str1.charAt(i)!=str2.charAt(str2.length()-1-i)) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		if(2<=n&&n<=100) {
			String [] words = new String[n];
			//�ܾ� �Է�
			for(int i=0;i<words.length;i++) {
				words[i]=sc.next();
			}
			//Ž�� ����
			for(int i=0;i<words.length-1;i++) {
				for(int j=i+1;j<words.length;j++) {
					//�ܾ��� ���̰� ������(���� ������ ���ڿ����� Ȯ��)
					if(words[i].length()==words[j].length()) {
						boolean flag = result(words[i],words[j]);
						if(flag) {
							System.out.println(words[i].length()+" "+words[i].charAt(words[i].length()/2));
							System.exit(0);
						}
					}
				}
			}
		}
	}
}
