package test_190327;

import java.util.ArrayList;
import java.util.Scanner;

//������ �ֻ����� ��ġ, �̵� ����� ���ʴ�� �־��� ��, �̵��� �� ���� �ֻ����� ��ܿ� ����Ǵ� ���� ����ϱ�
public class B_14499 {

	static int n;
	static int m;
	static int x;
	static int y;
	static int k;
	//��� 1,1 �ٴ� 3,1
	static int [][] dice = new int[4][3];
	static int [][] map;
	static ArrayList<Integer> ans = new ArrayList<>();
	
	public static void roll(int order) {
		//�������� ��ĭ �̵�
		if(order==1) {
			//���� �����
			if(y+1>=m) {
				ans.add(-1);
			}
			//���� ��(����)
			else {
				y++;
				int tmp = dice[1][0];
				dice[1][0]=dice[3][1];
				dice[3][1]=dice[1][2];
				dice[1][2]=dice[1][1];
				dice[1][1]=tmp;
				//���� �� ��� ���� ���� �� �ٴڸ� ����
				ans.add(dice[1][1]);
				if(map[x][y]==0) {
					map[x][y]=dice[3][1];
				}else {
					dice[3][1]=map[x][y];
					map[x][y]=0;
				}
			}
		}
		//�������� ��ĭ �̵�
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
		//�������� ��ĭ �̵�
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
		//�������� ��ĭ �̵�
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
			//���� �Է�
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					map[i][j]=sc.nextInt();
				}
			}
			//��� �Է�
			for(int i=0;i<k;i++) {
				roll(sc.nextInt());
			}
			//���� ���
			for(int i=0;i<k;i++) {
				if(ans.get(i)!=-1) System.out.println(ans.get(i));
			}
		}
	}
}
