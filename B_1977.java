package test_190128;

import java.util.ArrayList;
import java.util.Scanner;

//n�̻� m������ �ڿ��� �� ������������ �� ����ϱ�
public class B_1977 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		if(n<=10000&&m<=10000) {
			ArrayList<Integer> ans = new ArrayList<>();
			int start = (int)Math.sqrt(n);
			int end = (int)Math.sqrt(m);
			
			int sum = 0;
			//Ž�� ����
			for(int i=start;i<=end;i++) {
				if(n<=Math.pow(i, 2)&&Math.pow(i, 2)<=m) {
					ans.add((int)Math.pow(i, 2));
				}
			}
			System.out.println(ans.get(0));
			for(int i=0;i<ans.size();i++) {
				sum+=ans.get(i);
			}
			System.out.println(sum);
		}
	}
}
