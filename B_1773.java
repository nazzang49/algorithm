package test_181106;

import java.util.Scanner;

//���׼ ����Ǵ� ������ �� �� �ִ� �� �ð� ���ϱ�(�ԷµǴ� �ֱ��� ���)
public class B_1773 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int t = sc.nextInt();
		boolean [] visited = new boolean[2000001];
		int cnt = 0;
		
		if(1<=n&&n<=100&&1<=t&&t<=2000000) {
			for(int i=0;i<n;i++) {
				int cycle = sc.nextInt();
				if(1<=cycle&&cycle<=t) {
					for(int j=1;j<=t;j++) {
						if(j%cycle==0&&!visited[j]) {
							cnt++;
							visited[j]=true;
						}
					}
				}
			}
			System.out.println(cnt);
		}
	}
}
