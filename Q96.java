package solution1;

import java.util.ArrayList;
import java.util.Scanner;

//�Է� ���ڿ��� ���� n, ������ �� �ִ� ���� �� k�� �־��� �� Ȯ�� ������ �ִ� ������ ���� ���ڿ� ���� ����ϱ�
public class Q96 {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		ArrayList<Character> list = new ArrayList<>();
		
		if(1<=n&&n<=100000&&0<=k&&k<=100000) {
			String str = sc.next();
			if(str.length()==n) {
				if(n==k) {
					System.out.println(n);
					System.exit(0);
				}
				//�ݺ������� ���̴� ��� ���� ������ �ᱹ (n+k�� ���)���̵鸸�� ���ǿ� ������
				for(int i=(n+k)/2;i>=1;i--) {
					//���������� ��츸 üũ
					if((n+k)%i==0) {
						//�ݺ����� ����
						for(int j=0;j<i;j++) {
							list.add(str.charAt(j));
						}
						int cnt = 1;
						while(cnt<(n+k)/i) {
							if(str.length()-i*cnt<=i) {
								boolean flag = false;
								for(int m=i*cnt;m<str.length();m++) {
									//�ٸ� ���ڰ� ������(���� �ݺ� ����)
									if(list.get(m-i*cnt)!=str.charAt(m)) {
										flag = true;
										break;
									}
								}
								if(!flag) {
									System.out.println(i);
									System.exit(0);
								}else {
									break;
								}
							}else {
								boolean flag = false;
								for(int m=i*cnt;m<i*cnt+i;m++) {
									//�ٸ� ���ڰ� ������(���� �ݺ� ����)
									if(list.get(m-i*cnt)!=str.charAt(m)) {
										flag = true;
										break;
									}
								}
								if(flag) {
									break;
								}
							}
							cnt++;
						}
						list.clear();
					}
				}
				System.out.println(0);
				System.exit(0);
			}
		}
	}
}
