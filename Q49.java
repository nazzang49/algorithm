package solution;

import java.util.Scanner;

//������ �ܾ ¦��, Ȧ�� �ε����� �Ǻ��Ͽ� �ҹ��� �� �빮�� ��ȯ�ϱ�
public class Q49 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		//������ �������� �ܾ� ����
		String [] words = str.split(" ");
		String [] answer = new String[words.length];
		for(int i=0;i<words.length;i++) {
			String tmp = "";
			for(int j=0;j<words[i].length();j++) {
				if(j%2==0) {
					char a = (char)(words[i].charAt(j)-32);
					tmp+=a;
				}else{
					tmp+=words[i].charAt(j);
				}
			}
			answer[i]=tmp;
			System.out.println(answer[i]);
		}
	}
}
