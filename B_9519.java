package test_181103;

import java.util.Scanner;

//���� �����̰� �� ������ ������ �޶����� ���ڿ� ���
public class B_9519 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String str = sc.next();
		
		if(1<=n&&n<=1000000000&&str.length()<=31000) {
			char [] arr = str.toCharArray();
			for(int i=0;i<n;i++) {
				//¦�����̸�,
				if(str.length()%2==0) {
					for(int j=1;j<str.length()/2;j++) {
						//Ű��
						char tmp = arr[j];
						for(int k=j;k<arr.length-1;k++) {
							arr[k]=arr[k+1];
						}
						arr[arr.length-j]=tmp;
					}
				//Ȧ�����̸�,
				}else {
					for(int j=1;j<str.length()/2+1;j++) {
						//Ű��
						char tmp = arr[j];
						for(int k=j;k<arr.length-1;k++) {
							arr[k]=arr[k+1];
						}
						arr[arr.length-j]=tmp;
					}
				}
			}
			String answer = new String(arr);
			System.out.println(answer);
		}
	}
}
