package solution;

import java.util.Scanner;

//�� ������ ����Ǵ� �ֽİ����� �迭�� �־��� ��, ������ ������ �ð� ���ϱ�
public class Q14 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int cnt = 0;
		
		if(1<=n&&n<=100000) {
			int [] price = new int[n];
			int [] answer = new int[n];
			for(int i=0;i<price.length;i++) {
				int tmp = sc.nextInt();
				if(2<=tmp&&tmp<=10000) {
					price[i]=tmp;
				}
			}
			
			for(int i=0;i<price.length-1;i++) {
				for(int j=i+1;j<price.length;j++) {
					if(price[i]>price[j]) {
						cnt++;
						break;
					}else {
						cnt++;
					}
				}
				answer[i]=cnt;
				cnt=0;
			}
			
			for(int i=0;i<n;i++) {
				System.out.println(answer[i]);
			}
		}
	}
}
