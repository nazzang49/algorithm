package solution;

import java.util.Scanner;

//전화번호부에 적힌 전화번호 중 다른 번호의 접두어인 경우 찾기
public class Q21 {

	//어느 한 번호가 다른 번호의 접두어가 되는지 확인하는 메소드
	public static boolean find(String [] phone) {
		for(int i=0;i<phone.length;i++) {
			String str = phone[i];
			for(int j=0;j<phone.length;j++) {
				if(i==j) continue;
				if(str.length()<=phone[j].length()) {
					String str_com=phone[j].substring(0, str.length());
					if(str.equals(str_com)) {
						return false;
					}
				}
			}
		}
		return true;
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		//전화번호부 길이
		int n = sc.nextInt();
		
		if(1<=n&&n<=1000000) {
			String [] phone = new String[n];
			//전화번호 입력
			for(int i=0;i<n;i++) {
				String tmp = sc.next();
				if(1<=tmp.length()&&tmp.length()<=20) {
					phone[i]=tmp;
				}
			}
			boolean answer = find(phone);
			System.out.println(answer);
		}
	}
}
