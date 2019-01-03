package solution1;

import java.util.Scanner;

//체스판 위에 있는 나이트의 현재 좌표가 주어질 때 이동할 수 있는 경우의 수 구하기(최대 8)
public class Q125 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String point = sc.next();
		
		//나이트가 이동할 수 있는 최대 경우의 수 = 8
		int [][] move = {{2,1},{2,-1},{-2,1},{-2,-1},{1,2},{-1,2},{1,-2},{-1,-2}};
		int cnt = 0;
		
		for(int i=0;i<8;i++) {
			int nx = point.charAt(1)-'0'+move[i][0]-1;
			int ny = (int)(point.charAt(0)-'a')+move[i][1];
			
			if(!(nx<0||ny<0||nx>=8||ny>=8)) {
				cnt++;
			}
			
		}
		System.out.println(cnt);
	}
}
