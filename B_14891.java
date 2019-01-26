package test_190126;

import java.util.Scanner;

//4개의 톱니바퀴가 n극과 s극을 8개의 톱니로 구성된 채 서로 하나의 톱니를 공유하고 있을 때, 회전 횟수, 회전 종류가 주어질 시 12시 방향의 극 종류를 통해 얻을 수 있는 점수의 합계 출력하기
public class B_14891 {
	
	static int [][] circle = new int[4][8];
	static boolean [] visited = new boolean[4];

	//점수 합계 메소드
	public static int cal() {
		int sum = 0;
		if(circle[0][0]==1) sum+=1;
		if(circle[1][0]==1) sum+=2;
		if(circle[2][0]==1) sum+=4;
		if(circle[3][0]==1) sum+=8;
		return sum;
	}
	
	//회전 메소드
	public static void turn(int idx, int dir) {
		if(dir==1) {
			int tmp = circle[idx][7];
			for(int i=1;i<8;i++) {
				circle[idx][i]=circle[idx][i-1];
			}
			circle[idx][0]=tmp;
		}else {
			int tmp = circle[idx][0];
			for(int i=0;i<7;i++) {
				circle[idx][i]=circle[idx][i+1];
			}
			circle[idx][7]=tmp;
		}
	}
	
	//회전 실행 메소드
	public static void lotation(int idx, int dir) {
		
		if(idx>=4||idx<0) return;
		
		//왼쪽 검사
		if(idx-1>=0&&circle[idx][6]!=circle[idx-1][2]&&!visited[idx-1]) {
			visited[idx-1]=true;
			lotation(idx-1,dir*-1);
			visited[idx-1]=false;
			turn(idx-1,dir*-1);
		}
		
		//오른쪽 검사
		if(idx+1<=3&&circle[idx][2]!=circle[idx+1][6]&&!visited[idx+1]) {
			visited[idx+1]=true;
			lotation(idx+1,dir*-1);
			visited[idx+1]=false;
			turn(idx+1,dir*-1);
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		//톱니 상태 입력
		for(int i=0;i<4;i++) {
			String str = sc.next();
			for(int j=0;j<8;j++) {
				circle[i][j]=str.charAt(j)-'0';
			}
		}
		
		//회전 횟수 입력(1회전 = 1칸씩 이동)
		int k = sc.nextInt();
		if(1<=k&&k<=100) {
			for(int i=0;i<k;i++) {
				//회전하고자 하는 톱니바퀴 번호
				int idx = sc.nextInt();
				//회전 방향
				int dir = sc.nextInt();
				
				System.out.println();
				
				visited[idx-1]=true;
				lotation(idx-1,dir);
				//백트래킹
				visited[idx-1]=false;
				turn(idx-1,dir);

				for(int l=0;l<4;l++) {
					for(int j=0;j<8;j++) {
						System.out.print(circle[l][j]);
					}
					System.out.println();
				}
				
			}
			System.out.println();
			System.out.println(cal());
		}
	}
}
