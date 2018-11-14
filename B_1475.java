package test_181114;

import java.util.Scanner;

//입력값을 표현하기 위해 필요한 0-9까지의 숫자 세트 개수 구하기(6과 9는 거꾸로 뒤집어 사용 가능)
public class B_1475 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] arr = new int[10];
		//세트 개수
		int max = 0;
		
		//출현 빈도가 높은 숫자 기준
		if(0<=n&&n<=1000000) {
			String str = String.valueOf(n);
			for(int i=0;i<str.length();i++) {
				arr[str.charAt(i)-'0']++;
			}
			
			if(arr[6]%2==0) arr[6]=arr[6]/2;
			else arr[6]=arr[6]/2+1;
			if(arr[9]%2==0) arr[9]=arr[9]/2;
			else arr[9]=arr[9]/2+1;
				
			for(int i=0;i<arr.length;i++) {
				if(arr[i]>max) {
					max=arr[i];
				}
			}
			
			if(max<arr[6]+arr[9]) {
				max=arr[6]+arr[9];
			}
			System.out.println(max);
		}
	}
}
