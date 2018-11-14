package test_181103;

import java.util.Scanner;

//눈을 깜빡이고 뜰 때마다 정렬이 달라지는 문자열 출력
public class B_9519 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String str = sc.next();
		
		if(1<=n&&n<=1000000000&&str.length()<=31000) {
			char [] arr = str.toCharArray();
			for(int i=0;i<n;i++) {
				//짝수길이면,
				if(str.length()%2==0) {
					for(int j=1;j<str.length()/2;j++) {
						//키값
						char tmp = arr[j];
						for(int k=j;k<arr.length-1;k++) {
							arr[k]=arr[k+1];
						}
						arr[arr.length-j]=tmp;
					}
				//홀수길이면,
				}else {
					for(int j=1;j<str.length()/2+1;j++) {
						//키값
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
