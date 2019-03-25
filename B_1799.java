package test_190325;

import java.util.Scanner;

//����� ���� �� �ִ� ��ġ�� �־��� ��, ���� ��� ������ �ʴ� ��Ģ�� �����ϴ� ����� �ִ� ���� ���ϱ�(���ĭ Ž�� + ���ĭ Ž��)
public class B_1799 {

	static int n;
	//ü���� ���� ��Ȳ
	static int [][] map;
	static int blackCnt = 0;
	static int whiteCnt = 0;
	//�»�, ���, ����, ����
	static int [] dx = {-1, -1, 1, 1};
	static int [] dy = {-1, 1, -1, 1};
	
	//���� ��ġ�� ��� ���� �� �ִ��� �Ǻ��ϴ� �޼ҵ�
	public static boolean isAble(boolean [][] v, int x, int y) {
		//����� ���� �� ���� �ڸ��̸� false ��ȯ
		if(map[x][y]==0) return false;
		//�밢�� ��� ��ġ Ž��
		for(int i=0;i<4;i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			for(int j=0;j<n;j++) {
				//ü���� ���� ��
				if(nx>=0&&ny>=0&&nx<n&&ny<n) {
					//�̹� ����� ������ �밢���̸� false ��ȯ
					if(v[nx][ny]) return false;
					nx = nx+dx[i];
					ny = ny+dy[i];
				}
			}
		}
		return true;
	}
	
	//���ĭ Ž��
	public static void black(boolean [][] v, int x, int y, int cnt) {
		blackCnt = Math.max(blackCnt, cnt);
		
		//���� ���� ��� �� Ž�� �� = ���� ������ �̵�(���� �ٲ� �� ���� ������׷� ��� ĭ ��ġ ����)
		if(y>=n) {
			x++;
			y=x%2==0?0:1;
		}
		
		if(x>=n) return;
		
		//��� ���� �� �ִ� ���̸�
		if(isAble(v,x,y)) {
			v[x][y]=true;
			//2ĭ �̵� = �ٷ� �� ĭ�� �ٸ� ���̹Ƿ�
			black(v,x,y+2,cnt+1);
			v[x][y]=false;
		}
		
		//���� �� ������ ���� �ʴ� ���
		black(v,x,y+2,cnt);
	}
	
	//���ĭ Ž��
	public static void white(boolean [][] v, int x, int y, int cnt) {
		whiteCnt = Math.max(whiteCnt, cnt);
		
		//���� ���� ��� �� Ž�� �� = ���� ������ �̵�(���� �ٲ� �� ���� ������׷� ��� ĭ ��ġ ����)
		if(y>=n) {
			x++;
			y=x%2==0?1:0;
		}
		
		if(x>=n) return;
		
		//��� ���� �� �ִ� ���̸�
		if(isAble(v,x,y)) {
			v[x][y]=true;
			//2ĭ �̵� = �ٷ� �� ĭ�� �ٸ� ���̹Ƿ�
			white(v,x,y+2,cnt+1);
			v[x][y]=false;
		}
		
		//���� �� ������ ���� �ʴ� ���
		white(v,x,y+2,cnt);
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		if(n<=10) {
			map = new int[n][n];
			//ü���� ��Ȳ �Է�(1=���� / 0=�Ұ���)
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					map[i][j]=sc.nextInt();
				}
			}
			//��� ĭ = ¦�� / ��� ĭ = Ȧ��
			boolean [][] blackVisit = new boolean[n][n];
			black(blackVisit,0,0,0);
			boolean [][] whiteVisit = new boolean[n][n];
			white(whiteVisit,0,1,0);
			//���� ���
			System.out.println(blackCnt+whiteCnt);
		}
	}
}
