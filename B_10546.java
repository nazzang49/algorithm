package test_190117;

import java.util.Scanner;

//참가자 명단과 완주자 명단이 주어질 때, 완주하지 못한 참가자 이름 출력하기
public class B_10546 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		if(1<=n&&n<=Math.pow(10,5)) {
			String [] runner = new String[n];
			boolean [] visited = new boolean[n];
			//참가자 명단 입력
			for(int i=0;i<runner.length;i++) {
				runner[i]=sc.next();
			}
			//완주자 명단 입력
			for(int i=0;i<n-1;i++) {
				//완주자 명단 순서대로 입력
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
