package test_190218;

import java.util.ArrayList;
import java.util.Scanner;

//n���� �ڿ���, ������ �Ǵ� �ڿ��� x�� �־��� �� x���� ���� �ڿ��� ��� ����ϱ�
public class B_10871 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int x = sc.nextInt();
		
		if(n<=10000&&x<=10000) {
			ArrayList<Integer> ans = new ArrayList<>();
			//��� Ž��
			for(int i=0;i<n;i++) {
				int tmp = sc.nextInt();
				if(tmp<x) System.out.print(tmp+" ");
			}
		}	
	}
}
