package solution;

import java.util.Scanner;

//�����濡 ������ ������ ������ �������� �迭�� �־��� ��, �������� ���� 1�� ���ϱ�
public class Q6 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		if(1<=n&&n<=100000) {
			String [] runner = new String[n];
			String [] finish = new String[n-1];
			boolean [] visited = new boolean[n];
			
			//�Է�
			for(int i=0;i<runner.length;i++) {
				runner[i]=sc.next();
			}
			for(int i=0;i<finish.length;i++) {
				finish[i]=sc.next();
			}
			
			//Ž��(�����ڿ� ������ ��� ��)
			for(int i=0;i<finish.length;i++) {
				for(int j=0;j<runner.length;j++) {
					if(finish[i].equals(runner[j])) {
						visited[j]=true;
						break;
					}
				}
			}
			//false�� idx�� �̸� ���
			for(int i=0;i<visited.length;i++) {
				if(!visited[i]) {
					System.out.println(runner[i]);
					System.exit(0);
				}
			}
		}
	}
}
