package test_190218;

import java.util.ArrayList;
import java.util.Scanner;

//�Էµ� ���ڿ��� �Ӹ�������� Ȯ���ϴ� ���α׷� �ۼ��ϱ�
public class B_10988 {
	
	public static int result(String str) {
		boolean flag = false;
		for(int i=0;i<str.length()/2;i++) {
			//���ʰ� ������ ���� ��
			if(str.charAt(i)!=str.charAt(str.length()-1-i)) {
				flag = true;
			}
		}
		if(!flag) {
			return 1;
		}
		return 0;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> ans = new ArrayList<>();
		
		while(true) {
			String str = sc.next();
			if(str.length()<=100) {
				if(str.equals("exit")) {
					break;
				}
				ans.add(result(str));
			}
		}
		//���� ���
		for(int i=0;i<ans.size();i++) {
			System.out.println(ans.get(i));
		}
	}
}
