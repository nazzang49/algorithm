package test_190118;

import java.util.Scanner;

//2차원 배열에 유성이 x 영역, 하늘이 . 영역, 땅이 # 영역으로 주어질 때 유성이 땅에 떨어지고 난 후 결과 출력하기
public class B_10703 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		int c = sc.nextInt();
		
		if(3<=r&&r<=3000&&3<=c&&c<=3000) {
			char [][] map = new char[r][c];
			//최초 사진의 형태 문자열로 입력
			for(int i=0;i<r;i++) {
				String str = sc.next();
				for(int j=0;j<c;j++) {
					map[i][j]=str.charAt(j);
				}
			}
			//빈 공간으로 이동할 수 있는 최대 칸수 구하기(열이 기준)
			int maxMove = Integer.MAX_VALUE;
			for(int i=0;i<c;i++) {
				int cnt = 0;
				//땅에서 부터 탐색 시작
				for(int j=r-1;j>=0;j--) {
					//유성이 떨어지는 하늘이면
					if(map[j][i]=='.') {
						cnt++;
					}
					//X가 등장할 때만 최대 이동 가능한 칸수 비교
					else if(map[j][i]=='X') {
						if(maxMove>cnt) {
							maxMove=cnt;
						}
						break;
					}
				}
			}
			System.out.println(maxMove);
			//유성의 이동 반영
			for(int i=0;i<c;i++) {
				for(int j=r-1;j>=0;j--) {
					if(map[j][i]=='X') {
						map[j+maxMove][i]='X';
						map[j][i]='.';
					}
				}
			}
			//정답 출력
			for(int i=0;i<r;i++) {
				for(int j=0;j<c;j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}
	}
}
