package test_190116;

import java.util.ArrayList;
import java.util.Scanner;

//5�� ���ڿ� ������ FBI�� ���ԵǾ� �ִ� ������ �ε��� ������������ �����Ͽ� ����ϱ�
public class B_2857 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> ans = new ArrayList<>();
		
		//���� �Է�
		for(int i=1;i<=5;i++) {
			String str = sc.next();
			for(int j=0;j<str.length();j++) {
				if(str.charAt(j)=='F'&&str.substring(j, j+3).equals("FBI")) {
					ans.add(i);
					break;
				}
			}
		}
		if(ans.isEmpty()) {
			System.out.println("HE GOT AWAY");
			System.exit(0);
		}
		for(int i=0;i<ans.size();i++) {
			System.out.println(ans.get(i));
		}
	}
}
