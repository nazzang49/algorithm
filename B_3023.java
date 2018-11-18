package test_181106;

import java.util.Scanner;

//특정 문양의 1/4에 해당하는 패턴을 보고 최초 문양의 형태를 맞히는 문제
public class B_3023 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		int c = sc.nextInt();
		
		if(1<=r&&r<=50&&1<=c&&c<=50) {
			char [][] map = new char[r+1][c+1];
			for(int i=1;i<map.length;i++) {
				String tmp = sc.next();
				for(int j=1;j<map[i].length;j++) {
					map[i][j]=tmp.charAt(j-1);
				}
			}
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			char [][] line = new char [r*2+1][r*2+1];
			for(int i=1;i<=r*2;i++) {
				if(i<=r) {
					//오른쪽 상위 대칭
					for(int k=1;k<line[i].length;k++) {
						if(k<=r) {
							line[i][k]=map[i][k];
						}else {
							line[i][k]=map[i][r*2+1-k];
						}
					}
				//하위 대칭
				}else {
					for(int k=1;k<line[i].length;k++) {
						line[i][k]=line[r*2+1-i][k];	
					}
				}
			}
			for(int i=1;i<line.length;i++) {
				for(int j=1;j<line[i].length;j++) {
					if(i==x&&y==j) {
						if(line[x][y]=='.') {
							System.out.print('#');
						}else {
							System.out.print('.');
						}
					}else {
						System.out.print(line[i][j]);	
					}
				}
				System.out.println();
			}
		}
	}
}
