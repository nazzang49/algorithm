package test_190131;

import java.util.Scanner;

//두 정수 n과 f가 주어질 때, n이 f로 나눠지도록 하는 마지막 두자리 수의 최소값 출력하기
public class B_1075 {

	public static int result(int n, int f) {
		String str = String.valueOf(n);
		char [] arr = str.toCharArray();
		//마지막 두자리 = 0 변경
		arr[arr.length-2]='0';
		arr[arr.length-1]='0';
		str = new String(arr);
		
		int newN = Integer.parseInt(str);
		while(true) {
			if(newN%f==0) {
				break;
			}
			newN++;
		}
		return newN;
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int f = sc.nextInt();
		
		if(n<=2000000000&&f<=100) {
			int ans = result(n,f);
			String str = String.valueOf(ans);
			System.out.print(str.charAt(str.length()-2));
			System.out.print(str.charAt(str.length()-1));
		}
	}
}
