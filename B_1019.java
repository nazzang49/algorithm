package test_181114;

import java.util.Scanner;

//�־��� å ���������� 0-9������ ���ڰ� ���� ��� �����ϴ��� ���ϱ�
//ex) 11 -> 1 4 1 1 1 1 1 1 1 1
public class B_1019 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		//�� ������ ���� �� ������ �迭
		int [] arr = new int[10];
		
		if(1<=n&&n<=1000000000) {
			for(int i=1;i<=n;i++) {
				String str = String.valueOf(i);
				for(int j=0;j<str.length();j++) {
					arr[str.charAt(j)-'0']++;
				}
			}
			for(int i=0;i<arr.length;i++) {
				System.out.print(arr[i]+" ");
			}
		}
	}
}
