package test_190117;

import java.util.Scanner;

//������ ��ܰ� ������ ����� �־��� ��, �������� ���� ������ �̸� ����ϱ�
public class B_10546 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		if(1<=n&&n<=Math.pow(10,5)) {
			String [] runner = new String[n];
			boolean [] visited = new boolean[n];
			//������ ��� �Է�
			for(int i=0;i<runner.length;i++) {
				runner[i]=sc.next();
			}
			//������ ��� �Է�
			for(int i=0;i<n-1;i++) {
				//������ ��� ������� �Է�
				String finish = sc.next();
				for(int j=0;j<runner.length;j++) {
					if(!visited[j]&&runner[j].equals(finish)) {
						visited[j]=true;
						break;
					}
				}
			}
			for(int i=0;i<n;i++) {
				if(!visited[i]) {
					System.out.println(runner[i]);
				}
			}
		}
	}
}
