package solution;

import java.util.Scanner;

//코어별로 작업을 처리하는 시간이 다르고, 처리해야 하는 작업의 수가 주어질 때 마지막으로 작업을 처리하게 되는 코어는 몇번인지 출력하기
//해결 but 비효율적인 방법인듯
public class Q18 {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		//코어의 수
		int n = sc.nextInt();
		//처리해야할 작업의 수
		int task = sc.nextInt();
		
		if(2<=n&&n<=10000&&1<=task&&task<=50000) {
			int [] core = new int[n];
			boolean [] visited = new boolean[n];
			for(int i=0;i<core.length;i++) {
				core[i]=sc.nextInt();
				//처음에는 모든 코어 차례대로 입장
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
