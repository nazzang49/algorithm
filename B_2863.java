package test_181109;

import java.util.Scanner;

//2X2 행렬에서 90도로 숫자의 위치를 회전시키며 얻는 분수 중 최대값 구하기
public class B_2863 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int [][] map = new int[2][2];
		int sum = 0;
		int answer = 0;
		
		for(int i=0;i<map.length;i++) {
			for(int j=0;j<map.length;j++) {
				int tmp = sc.nextInt();
				if(1<=tmp&&tmp<=100) {
					map[i][j]=tmp;	
				}
			}
		}
		//4회전 하면 최초 배열 형태로 복귀
		for(int i=0;i<4;i++) {
			int a = 0;
			int b = 0;
			//최초 배열
			if(i==0) {
				a = map[0][0]/map[1][0];
				b = map[0][1]/map[1][1];
				sum = a+b;
			}
			//회전 시작
			else {
				int tmp = map[0][0];
				map[0][0] = map[1][0];
				map[1][0] = map[1][1];
				map[1][1] = map[0][1];
				map[0][1] = tmp;
				a = map[0][0]/map[1][0];
				b = map[0][1]/map[1][1];
				//이전 합보다 현재 합이 더 크면
				if(sum<a+b) {
					sum=a+b;
					answer=i;
				}
			}
		}
		System.out.println(answer);
	}
}
