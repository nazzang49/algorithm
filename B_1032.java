package test_190115;

import java.util.Scanner;

//n���� ���� �̸��� �־��� ��, ���� �̸��� Ư�� ���� �����Ͽ� ����ϱ�
public class B_1032 {

	//�� ���� ���ڿ� �� ����� ���ڿ� ����
	public static String result(String str1, String str2) {
		String tmp = "";
		for(int i=0;i<str1.length();i++) {
			if(str1.charAt(i)==str2.charAt(i)) {
				boolean flag = false;
				tmp+=str1.charAt(i);
				for(int j=i+1;j<str1.length();j++) {
					if(str1.charAt(j)!=str2.charAt(j)) {
						flag=true;
						break;
					}
					tmp+=str1.charAt(j);
				}
				if(flag) {
					break;
				}
			}
		}
		return tmp;
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		if(1<=n&&n<=50) {
			String [] words = new String[n];
			//�ܾ� �Է�
			for(int i=0;i<words.length;i++) {
				String str = sc.next();
				//�ܾ��� ���̴� �ִ� 50
				if(str.length()<=50) {
					words[i]=str;
				}
			}
			//�ʱ� ������ ���� ���ڿ�
			String tmp = result(words[0],words[1]);
			//Ž�� ����(�� �ڸ��� �ִ� ���ĺ� �� -> ��� ���� ��� ����� ���ڿ� ���� ����)
			for(int i=2;i<words.length;i++) {
				tmp = result(tmp,words[i]);
			}
			int len = words[0].length()-tmp.length();
			for(int i=0;i<len;i++) {
				tmp+='?';
			}
			System.out.println(tmp);
		}
	}
}
