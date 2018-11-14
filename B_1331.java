package test_181114;

import java.util.Scanner;

//6X6 크기의 체스판에서 나이트가 입력값에 따라 모든 지점을 탐색할 때 중복 없이 이행했을 시 valid 출력
public class B_1331 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		boolean [][] visited = new boolean[6][6];
		
		//36개 입력값 준비
		for(int i=0;i<visited.length;i++) {
			for(int j=0;j<visited.length;j++) {
				String tmp = sc.next();
				if(tmp.charAt(0)-'A'>5||tmp.charAt(1)-'1'>5) {
					System.out.println("입력값 규칙을 다시 확인해주세요.");
					System.exit(0);
				}else {
					//아직 방문 X 지점일 경우
					if(!visited[tmp.charAt(0)-'A'][tmp.charAt(1)-'1']) {
						visited[tmp.charAt(0)-'A'][tmp.charAt(1)-'1']=true;
					}
					//이미 방문 O 지점일 경우(올바른 탐색 실패 = 프로그램 종료)
					else {
						System.out.println("Invalid");
						System.exit(0);
					}
				}
			}
		}
		System.out.println("Valid");
	}
}
