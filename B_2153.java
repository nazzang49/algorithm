package test_181113;

import java.util.Scanner;

//�Էµ� �ܾ��� �� ���ĺ��� ���ڷ� �����Ͽ� ���� ������ �Ҽ����� �Ǻ��ϱ�
public class B_2153 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		//�� ���ں� ��ȯ�� ���� ������ �迭(a-Z)
		int [] arr = new int[52];
		int sum = 0;
		
		//�ܾ��� ���̴� 20�� ����
		if(str.length()<=20) {
			for(int i=0;i<arr.length;i++) {
				arr[i]=i+1;
			}
			for(int i=0;i<str.length();i++) {
				if('A'<=str.charAt(i)&&str.charAt(i)<='Z') {
					sum+=arr[26+str.charAt(i)-'A'];
				}else {
					sum+=arr[str.charAt(i)-'a'];
				}
			}
			boolean flag = false;
			for(int i=2;i<=sum/2;i++) {
				if(sum%i==0) {
					flag = true;
					break;
				}
			}
			if(!flag) {
				System.out.println("It is a prime word");
			}else {
				System.out.println("It is not a prime word");
			}
		}
	}
}
