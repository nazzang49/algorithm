package solution;

import java.util.ArrayList;
import java.util.Scanner;

//Ư�� ���ڿ��� ���� ���ڿ��� �Է� �� ��, �ش� ���ڿ����� ���� ���ڿ��� �ݺ��ؼ� �����ϰ� ���� ���� ���ڿ� ����ϱ�
public class Q74 {

	static ArrayList<Character> answer = new ArrayList<>();
	
	public static void result(String ban) {
		for(int i=0;i<answer.size();i++) {
			if(answer.get(i)==ban.charAt(0)) {
				boolean flag = false;
				for(int j=1;j<ban.length();j++) {
					if(answer.get(i+j)!=ban.charAt(j)) {
						flag=true;
						break;
					}
				}
				//���� ���ڿ��� �ִ� ���
				if(!flag) {
					for(int k=0;k<ban.length();k++) {
						answer.remove(i);
					}
					result(ban);
				}
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		String ban = sc.next();
		
		if(str.length()<=1000000&&ban.length()<=str.length()) {
			for(int i=0;i<str.length();i++) {
				answer.add(str.charAt(i));
			}
			result(ban);
			//���� ���
			for(int i=0;i<answer.size();i++) {
				System.out.print(answer.get(i));
			}
		}
	}
}
