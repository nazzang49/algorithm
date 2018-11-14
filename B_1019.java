package test_181114;

import java.util.Scanner;

//주어진 책 페이지까지 0-9까지의 숫자가 각각 몇번 등장하는지 구하기
//ex) 11 -> 1 4 1 1 1 1 1 1 1 1
public class B_1019 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		//각 숫자의 출현 빈도 저장할 배열
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
