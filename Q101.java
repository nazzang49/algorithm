package solution;

import java.util.Scanner;

//PPAP�� P�� �ٲ� �� �ְ�, P�� A�θ� �̷���� ���ڿ��� �־��� �� �ش� ���ڿ��� PPAP ���ڿ����� �Ǻ��ϱ�
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
				//PPAP���ڸ� P�� ����
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
