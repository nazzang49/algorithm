package test_190125;

import java.util.Arrays;
import java.util.Scanner;

//���ڿ� S�� ��� ���̻縦 ���������� ��迭�Ͽ� ����ϱ�
public class B_11656 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		if(str.length()<=1000) {
			//���̻� ���� = ���ڿ��� ����
			String [] ans = new String[str.length()];
			
			for(int i=0;i<str.length();i++) {
				ans[i]=str.substring(i, str.length());
			}
			
			Arrays.sort(ans);
			for(int i=0;i<ans.length;i++) {
				System.out.println(ans[i]);
			}
		}
	}
}
