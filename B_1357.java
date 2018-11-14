package test_181107;

import java.util.Scanner;

//입력값을 역순으로 만드는 함수에 의한 두 숫자의 합 구하기
public class B_1357 {
	
	public static int rev(String a) {
		char [] arr = a.toCharArray();
		for(int i=0;i<arr.length;i++) {
			char tmp = arr[i];
			arr[i]=arr[a.length()-1-i];
			arr[a.length()-1-i]=tmp;
		}
		
		return Integer.parseInt(new String(arr));
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		
		if(1<=x&&x<=1000&&1<=y&&y<=1000) {
			String x_str = String.valueOf(x);
			String y_str = String.valueOf(y);
			
			//역순 배열된 숫자 다시 저장
			x = rev(x_str);
			y = rev(y_str);
			
			System.out.println(rev(String.valueOf(x+y)));
		}
		
	}

}
