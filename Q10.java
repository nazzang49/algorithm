package solution;

import java.util.Scanner;

//n�� 4���� �־��� 2���� �迭���� �̹� ���� idx�� �����ϰ� Ư�� ĭ�� ���� ������ �ջ��� �� ������ �� ���� �� ���� �� �ִ� �ִ밪 ���ϱ�
public class Q10 {
	
	static int [][] map;
	static int max = 0;
	static int n;
	
	//DFS+��Ʈ��ŷ
	public static void dfs(int x, int y, int sum) {
		//������ �� ���� ��(�ִ밪 ��)
		if(x==n) {
			if(max<=sum) {
				max=sum;
			}
		}else {
			sum+=map[x][y];
			for(int j=0;j<4;j++) {
				//�� ���� ������ ���̶� ������(����� �� ����)
				if(j==y) {
					continue;
				}else {
					dfs(x+1,j,sum);	
				}
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		if(1<=n&&n<=100000) {
			map = new int[n][4];
			//�Է�
			for(int i=0;i<map.length;i++) {
				for(int j=0;j<map[i].length;j++) {
					map[i][j]=sc.nextInt();
				}
			}
			//Ž��
			for(int j=0;j<4;j++) {
				dfs(0,j,0);
			}
			System.out.println(max);
		}
	}
}
