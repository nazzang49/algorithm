package solution;

import java.util.Scanner;

//마라톤에 참여한 선수와 완주한 선수들의 배열이 주어질 때, 완주하지 못한 1인 구하기
public class Q6 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		if(1<=n&&n<=100000) {
			String [] runner = new String[n];
			String [] finish = new String[n-1];
			boolean [] visited = new boolean[n];
			
			//입력
			for(int i=0;i<runner.length;i++) {
				runner[i]=sc.next();
			}
			for(int i=0;i<finish.length;i++) {
				finish[i]=sc.next();
			}
			
			//탐색(완주자와 참가자 명단 비교)
			for(int i=0;i<finish.length;i++) {
				for(int j=0;j<runner.length;j++) {
					if(finish[i].equals(runner[j])) {
						visited[j]=true;
						break;
					}
				}
			}
			//false인 idx의 이름 출력
			for(int i=0;i<visited.length;i++) {
				if(!visited[i]) {
					System.out.println(runner[i]);
					System.exit(0);
				}
			}
		}
	}
}
