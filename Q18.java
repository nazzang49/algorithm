package solution;

import java.util.Scanner;

//�ھ�� �۾��� ó���ϴ� �ð��� �ٸ���, ó���ؾ� �ϴ� �۾��� ���� �־��� �� ���������� �۾��� ó���ϰ� �Ǵ� �ھ�� ������� ����ϱ�
//�ذ� but ��ȿ������ ����ε�
public class Q18 {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		//�ھ��� ��
		int n = sc.nextInt();
		//ó���ؾ��� �۾��� ��
		int task = sc.nextInt();
		
		if(2<=n&&n<=10000&&1<=task&&task<=50000) {
			int [] core = new int[n];
			boolean [] visited = new boolean[n];
			for(int i=0;i<core.length;i++) {
				core[i]=sc.nextInt();
				//ó������ ��� �ھ� ���ʴ�� ����
				visited[i]=true;
				task--;
				
			}
			int k = 1;
			while(true) {
				for(int i=0;i<core.length;i++) {
					if(k%core[i]==0) {
						task--;
						if(task==0) {
							System.out.println(i+1);
							System.exit(0);
						}
					}
				}
				k++;
			}
		}
	}
}
