package test_181107;

import java.util.Scanner;

//Z °æ·Î Å½»ö
public class B_1074 {
	
	static int cnt = 0;
	static int [][] map;
	static int n;
	static int r;
	static int c;
	
	public static void rec(int [][] arr) {
		for(int i=0;i<arr.length/4;i++) {
			
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		r = sc.nextInt();
		c = sc.nextInt();
		
		if(1<=n&&n<=15&&0<=r&&r<=(int)Math.pow(2, n)-1
				&&0<=c&&c<=(int)Math.pow(2, n)-1) {
			map = new int[(int)Math.pow(2, n)][(int)Math.pow(2, n)];
			rec(map);
		}
	}
}
