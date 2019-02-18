package test_190218;

import java.util.Scanner;

//A,B,C 세 수를 곱한 결과에 0~9까지의 숫자가 모두 몇번 쓰였는지 출력하기
public class B_2577 {

	//0~9까지 각 숫자가 몇번 쓰였는지 배열 반환할 메소드
	public static int [] result(int n) {
		int [] ans = new int[10];
		String str = String.valueOf(n);
		for(int i=0;i<str.length();i++) {
			ans[str.charAt(i)-'0']++;
		}
		return ans;
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		
		if(A<=1000&&B<=1000&&C<=1000) {
			int tmp = A*B*C;
			int [] ans = result(tmp);
			for(int i=0;i<ans.length;i++) {
				System.out.println(ans[i]);
			}
		}else System.out.println("입력 조건을 확인하세요.");
	}
}
