package test_190126;

import java.util.Scanner;

//4���� ��Ϲ����� n�ذ� s���� 8���� ��Ϸ� ������ ä ���� �ϳ��� ��ϸ� �����ϰ� ���� ��, ȸ�� Ƚ��, ȸ�� ������ �־��� �� 12�� ������ �� ������ ���� ���� �� �ִ� ������ �հ� ����ϱ�
public class B_14891 {
	
	static int [][] circle = new int[4][8];
	static boolean [] visited = new boolean[4];

	//���� �հ� �޼ҵ�
	public static int cal() {
		int sum = 0;
		if(circle[0][0]==1) sum+=1;
		if(circle[1][0]==1) sum+=2;
		if(circle[2][0]==1) sum+=4;
		if(circle[3][0]==1) sum+=8;
		return sum;
	}
	
	//ȸ�� �޼ҵ�
	public static void turn(int idx, int dir) {
		if(dir==1) {
			int tmp = circle[idx][7];
			for(int i=1;i<8;i++) {
				circle[idx][i]=circle[idx][i-1];
			}
			circle[idx][0]=tmp;
		}else {
			int tmp = circle[idx][0];
			for(int i=0;i<7;i++) {
				circle[idx][i]=circle[idx][i+1];
			}
			circle[idx][7]=tmp;
		}
	}
	
	//ȸ�� ���� �޼ҵ�
	public static void lotation(int idx, int dir) {
		
		if(idx>=4||idx<0) return;
		
		//���� �˻�
		if(idx-1>=0&&circle[idx][6]!=circle[idx-1][2]&&!visited[idx-1]) {
			visited[idx-1]=true;
			lotation(idx-1,dir*-1);
			visited[idx-1]=false;
			turn(idx-1,dir*-1);
		}
		
		//������ �˻�
		if(idx+1<=3&&circle[idx][2]!=circle[idx+1][6]&&!visited[idx+1]) {
			visited[idx+1]=true;
			lotation(idx+1,dir*-1);
			visited[idx+1]=false;
			turn(idx+1,dir*-1);
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		//��� ���� �Է�
		for(int i=0;i<4;i++) {
			String str = sc.next();
			for(int j=0;j<8;j++) {
				circle[i][j]=str.charAt(j)-'0';
			}
		}
		
		//ȸ�� Ƚ�� �Է�(1ȸ�� = 1ĭ�� �̵�)
		int k = sc.nextInt();
		if(1<=k&&k<=100) {
			for(int i=0;i<k;i++) {
				//ȸ���ϰ��� �ϴ� ��Ϲ��� ��ȣ
				int idx = sc.nextInt();
				//ȸ�� ����
				int dir = sc.nextInt();
				
				System.out.println();
				
				visited[idx-1]=true;
				lotation(idx-1,dir);
				//��Ʈ��ŷ
				visited[idx-1]=false;
				turn(idx-1,dir);

				for(int l=0;l<4;l++) {
					for(int j=0;j<8;j++) {
						System.out.print(circle[l][j]);
					}
					System.out.println();
				}
				
			}
			System.out.println();
			System.out.println(cal());
		}
	}
}
