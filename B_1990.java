package test_181116;

import java.util.ArrayList;
import java.util.Scanner;

//�־��� �Է°��� ���� ������ �Ҽ��Ӱ� ���ÿ� �Ӹ������ �ڿ��� ���
public class B_1990 {

	public static void main(String[] args) {

		//int�� ������ 2,147,483,647 (10�� 9�� �ڸ�)
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		ArrayList<Integer> list = new ArrayList<>();
		
		//1)�Ҽ� �Ǻ�
		//2)�Ӹ���� �Ǻ�
		if(5<=a&&a<b&&b<=100000000) {
			for(int i=a;i<=b;i++) {
				boolean flag = false;
				for(int j=2;j<=i/2;j++) {
					if(i%j==0) {
						flag=true;
						break;
					}
				}
				//�Ҽ��� ���
				if(!flag) {
					String str = String.valueOf(i);
					for(int j=0;j<str.length()/2;j++) {
						//�Ӹ���� �ƴ� ���
						if(str.charAt(j)!=str.charAt(str.length()-1-j)) {
							flag=true;
							break;
						}
					}
					//�Ҽ��̸鼭 �Ӹ������ ���
					if(!flag) {
						list.add(i);
					}
				}
			}
			for(int i=0;i<list.size();i++) {
				System.out.println(list.get(i));
			}
			System.out.println(-1);
		}
	}
}
