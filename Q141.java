package solution;

import java.util.Scanner;

//두 행렬의 곱 결과 출력하기
public class Q141 {

	static int [][] answer;
	static int [][] A;
	static int [][] B;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		
		if(1<=n&&n<=100&&1<=m&&m<=100&&1<=k&&k<=100) {
			A = new int[n][m];
			B = new int[m][k];
			//행렬 입력
			for(int i=0;i<A.length;i++) {
				for(int j=0;j<A[i].length;j++) {
					A[i][j]=sc.nextInt();
				}
			}
			for(int i=0;i<B.length;i++) {
				for(int j=0;j<B[i].length;j++) {
					B[i][j]=sc.nextInt();
				}
			}
			
			answer = new int[n][k];
			
			for(int i=0;i<n;i++) {
				int cnt = 0;
				while(cnt<k) {
					for(int j=0;j<m;j++) {
						answer[i][cnt]+=A[i][j]*B[j][cnt];
					}
					cnt++;
				}
			}
			for(int i=0;i<answer.length;i++) {
				for(int j=0;j<answer[i].length;j++) {
					System.out.print(answer[i][j]+" ");
				}
				System.out.println();
			}
		}
	}
}
