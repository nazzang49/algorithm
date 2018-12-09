package solution;

import java.util.Scanner;

//어떠한 2차원 배열, 해당 배열에 담긴 숫자가 주어질 때 1만으로 이루어진 정사각형 영역 중에 가장 최대값 구하기
public class Q24 {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		int c = sc.nextInt();
		int max = Integer.MIN_VALUE;
		
		if(1<=r&&r<=1000&&1<=c&&c<=1000) {
			int [][] map = new int[r][c];
			int [][] dp = new int[r][c];
			//입력
			for(int i=0;i<map.length;i++) {
				for(int j=0;j<map[i].length;j++) {
					int tmp = sc.nextInt();
					if(tmp==0||tmp==1) {
						map[i][j]=tmp;
					}
				}
			}
			//탐색
			for(int i=0;i<map.length;i++) {
				for(int j=0;j<map[i].length;j++) {
					int min = 0;
					if(map[i][j]==1) {
						if(i==0||j==0) {
							dp[i][j]=1;
						}else {
							//왼쪽, 왼쪽 위(대각선), 위쪽 누적 데이터 중 최소값 저장
							min = Math.min(Math.min(dp[i][j-1], dp[i-1][j]), dp[i-1][j-1]);
							dp[i][j]=min+1;
						}
						max = Math.max(max, dp[i][j]);
					}
				}
			}
			System.out.println(max*max);
		}
	}
}
