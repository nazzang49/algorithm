package test_190201;

import java.util.Scanner;

//������ ������, Ŭ������ �뷮�� �־��� ��, ���� ����� Ŭ������ �뷮 ����ϱ�
public class B_1350 {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		//������ �ִ� ���� = 1000
		if(n<=1000) {
			int [] file = new int[n];
			//���� �뷮 �Է�
			for(int i=0;i<file.length;i++) {
				file[i]=sc.nextInt();
			}
			//Ŭ������ �뷮 �Է�
			int k = sc.nextInt();
			long size = 0;
			//Ž�� ����
			for(int i=0;i<n;i++) {
				if(file[i]%k==0) size+=file[i];
				else size+=(file[i]/k+1)*k;
			}
			System.out.println(size);
		}
	}
}
