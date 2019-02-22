package test_181109;

import java.util.Scanner;

//누울 자리를 찾아라
public class B_1652 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		char [][] map = new char[n][n];
		int cnt1 = 0;
		int cnt2 = 0;
		
		if(1<=n&&n<=100) {
			//탐색할 맵 형성
			for(int i=0;i<map.length;i++) {
				String tmp = sc.next();
				for(int j=0;j<map.length;j++) {
					map[i][j]=tmp.charAt(j);
				}
			}
			for(int i=0;i<map.length;i++) {
				for(int j=0;j<map.length-1;j++) {
					if(map[i][j]=='.'&&map[i][j]==map[i][j+1]) {
						cnt1++;
						break;
					}
				}
			}
			for(int j=0;j<map.length;j++) {
				for(int i=0;i<map.length-1;i++) {
					if(map[i][j]=='.'&&map[i][j]==map[i+1][j]) {
						cnt2++;
						break;
					}
				}
			}
			System.out.println(cnt1);
			System.out.println(cnt2);
		}
	}
}
