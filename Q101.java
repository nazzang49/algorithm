package solution;

import java.util.Scanner;

//PPAP를 P로 바꿀 수 있고, P와 A로만 이루어진 문자열이 주어질 때 해당 문자열이 PPAP 문자열인지 판별하기
public class Q101 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		if(1<=str.length()&&str.length()<=1000000) {
			if(str.length()<4) {
				if(str.equals("P")) {
					System.out.println("PPAP");
				}else {
					System.out.println("NP");
				}
				System.exit(0);
			}else {
				//PPAP문자를 P로 변경
				String tmp = str.replaceAll("PPAP", "P");
				if(tmp.equals("PPAP")) {
					System.out.println("PPAP");
				}else {
					System.out.println("NP");					
				}
				System.exit(0);
			}
		}
	}
}
