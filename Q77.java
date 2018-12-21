package solution;

import java.util.Arrays;
import java.util.Scanner;

//�־��̿� ����Կ��� ���� n(Ȧ��)���� ���� ���ڰ� ���� ī�尡 �־�����, �� n���带 ���� ���Ƿ� ���� ī���� ���ڸ� ���ϸ� ������ ��°����� �� �� �־��̰� �̱� �� �ִ� ��찡 �ִٸ� yes, ���ٸ� no ����ϱ� 
public class Q77 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		if(1<=n&&n<=100000) {
			//�־�
			int [] person1 = new int[n];
			//�����
			int [] person2 = new int[n];
			//����� ī�� üũ
			boolean [] visited = new boolean[n];
			//ī�� �Է�
			for(int i=0;i<person1.length;i++) {
				int tmp = sc.nextInt();
				if(0<=tmp&&tmp<=100000) {
					person1[i]=tmp;
				}
			}
			for(int i=0;i<person2.length;i++) {
				int tmp = sc.nextInt();
				if(0<=tmp&&tmp<=100000) {
					person2[i]=tmp;
				}
			}
			//Ž��
			//1) �������� ����
			Arrays.sort(person1);
			Arrays.sort(person2);
			int cnt = 0;
			
			for(int i=0;i<person1.length;i++) {
				for(int j=0;j<person2.length;j++) {
					if(person1[i]<person2[j]&&!visited[j]) {
						visited[j]=true;
						cnt++;
					}
				}
			}
			//�¸��� �ʿ��� �ּ� ���� �̻��� ȹ���ϸ�(����� �� �ִ� ���)
			if(cnt>=(n+1)/2) {
				System.out.println("YES");
				System.exit(0);
			}
			System.out.println("NO");
		}
	}
}
