package test_190121;

import java.util.Scanner;

//ã���� �ϴ� ���ڿ��� n���� ���� ���ڿ��� �־��� ��, �ش� ������ ã���� �ϴ� ���ڿ��� ���ԵǾ����� Ȯ���ϴ� ���α׷� �ۼ��ϱ�
public class B_5555 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int n = sc.nextInt();
		int cnt = 0;
		
		if(1<=n&&n<=100) {
			int k = 0;
			while(k<n) {
				String ring = sc.next();
				for(int i=0;i<ring.length();i++) {
					if(ring.charAt(i)==str.charAt(0)) {
						if(i+str.length()<=ring.length()
								&&ring.substring(i, i+str.length()).equals(str)) {
							cnt++;
							break;
						}
						//�κ� ���ڿ��� ������ ���� ���ڿ��� ������ �����(�ٽ� �� �ε������� Ž��)
						else if(i+str.length()>ring.length()) {
							String tmp = ring.substring(i,ring.length());
							int limit = str.length()-tmp.length();
							for(int j=0;j<limit;j++) {
								tmp+=ring.charAt(j);
							}
							if(tmp.equals(str)) {
								cnt++;
								break;
							}
						}
					}
				}
				k++;
			}
			System.out.println(cnt);
		}
	}
}
