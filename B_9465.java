package test_190115;

import java.util.Scanner;

//���� �����ϴ� ��ƼĿ�� �� �� ����, �� �࿡ ���� �� ������ ��ƼĿ�� ������ �־��� �� ���� �� �ִ� ������ �ִ밪 ���ϱ�
public class B_9465 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		if(1<=n&&n<=100000) {
			int [][] map = new int[2][n];
			//���� �Է�
			for(int i=0;i<map.length;i++) {
				for(int j=0;j<map[i].length;j++) {
					map[i][j]=sc.nextInt();
				}
			}
			//DP ���
			map[0][1]=map[1][0]+map[0][1];
			map[1][1]=map[0][0]+map[1][1];
			//��(2������ Ž��)
			for(int j=2;j<n;j++) {
				//��
				for(int i=0;i<map.length;i++) {
					map[i][j]=Math.max(map[1-i][j-1],map[1-i][j-2])+map[i][j];
				}
			}
			System.out.println(Math.max(map[0][n-1], map[1][n-1]));
		}
	}
}
