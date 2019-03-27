package test_190327;

import java.util.ArrayList;
import java.util.Scanner;

//지도와 주사위의 위치, 이동 명령이 차례대로 주어질 때, 이동할 때 마다 주사위의 상단에 노출되는 정수 출력하기
public class B_14499 {

	static int n;
	static int m;
	static int x;
	static int y;
	static int k;
	//상단 1,1 바닥 3,1
	static int [][] dice = new int[4][3];
	static int [][] map;
	static ArrayList<Integer> ans = new ArrayList<>();
	
	public static void roll(int order) {
		//동쪽으로 한칸 이동
		if(order==1) {
			//범위 벗어나면
			if(y+1>=m) {
				ans.add(-1);
			}
			//범위 내(스왑)
			else {
				y++;
				int tmp = dice[1][0];
				dice[1][0]=dice[3][1];
				dice[3][1]=dice[1][2];
				dice[1][2]=dice[1][1];
				dice[1][1]=tmp;
				//스왑 후 상단 정수 저장 및 바닥면 복사
				ans.add(dice[1][1]);
				if(map[x][y]==0) {
					map[x][y]=dice[3][1];
				}else {
					dice[3][1]=map[x][y];
					map[x][y]=0;
				}
			}
		}
		//서쪽으로 한칸 이동
		else if(order==2) {
			if(y-1<0) {
				ans.add(-1);
			}else {
				y--;
				int tmp = dice[1][2];
				dice[1][2]=dice[3][1];
				dice[3][1]=dice[1][0];
				dice[1][0]=dice[1][1];
				dice[1][1]=tmp;
				ans.add(dice[1][1]);
				if(map[x][y]==0) {
					map[x][y]=dice[3][1];
				}else {
					dice[3][1]=map[x][y];
					map[x][y]=0;
				}
			}
		}
		//북쪽으로 한칸 이동
		else if(order==3) {
			if(x-1<0) {
				ans.add(-1);
			}
			else {
				x--;
				int tmp = dice[2][1];
				dice[2][1]=dice[3][1];
				dice[3][1]=dice[0][1];
				dice[0][1]=dice[1][1];
				dice[1][1]=tmp;
				ans.add(dice[1][1]);
				if(map[x][y]==0) {
					map[x][y]=dice[3][1];
				}else {
					dice[3][1]=map[x][y];
					map[x][y]=0;
				}
			}
		}
		//남쪽으로 한칸 이동
		else {
			if(x+1>=n) {
				ans.add(-1);
			}
			else {
				x++;
				int tmp = dice[0][1];
				dice[0][1]=dice[3][1];
				dice[3][1]=dice[2][1];
				dice[2][1]=dice[1][1];
				dice[1][1]=tmp;
				ans.add(dice[1][1]);
				if(map[x][y]==0) {
					map[x][y]=dice[3][1];
				}else {
					dice[3][1]=map[x][y];
					map[x][y]=0;
				}
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		if(n<=20&&m<=20) {
			map = new int[n][m];
			x = sc.nextInt();
			y = sc.nextInt();
			k = sc.nextInt();
			//지도 입력
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					map[i][j]=sc.nextInt();
				}
			}
			//명령 입력
			for(int i=0;i<k;i++) {
				roll(sc.nextInt());
			}
			//정답 출력
			for(int i=0;i<k;i++) {
				if(ans.get(i)!=-1) System.out.println(ans.get(i));
			}
		}
	}
}
