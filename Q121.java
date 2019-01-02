package solution;

import java.util.ArrayList;
import java.util.Scanner;

class Pos {
	int x, y;
	
	public Pos(int x, int y) {
		this.x=x;
		this.y=y;
	}
}

//����� ĵ�� ���� n, �ڼ� û�ұ��� ���� m, û�ұ� ���� ���� �ð� s, �� û�ұⰡ 1�д� ĵ�� ������̴� �ӵ� v�� �־��� �� ó���� �� �ִ� �ִ� ĵ�� ���� ����ϱ�
//Ư�� û�ұ� - Ư�� ����� ĵ�� ���� �Ÿ� > s*v => û�� �Ұ���
public class Q121 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int s = sc.nextInt();
		int v = sc.nextInt();
		
		int cnt = 0;
				
		ArrayList<Pos> can = new ArrayList<>();
		ArrayList<Pos> cleaner = new ArrayList<>();
		boolean [] visited = new boolean[n];
		
		if(1<=n&&n<=100&&1<=m&&m<=100&&1<=s&&s<=100&&1<=v&&v<=100) {
			//ĵ�� û�ұ� ��ǥ �Է�
			for(int i=0;i<n;i++) {
				can.add(new Pos(sc.nextInt(), sc.nextInt()));
			}
			for(int i=0;i<m;i++) {
				cleaner.add(new Pos(sc.nextInt(), sc.nextInt()));
			}
			//Ž�� ����(û�ұ� ��ǥ�� ��������)
			for(int i=0;i<m;i++) {
				Pos cleaner_p = cleaner.get(i);
				//�ּ� �Ÿ����� Ȯ���� ����
				double min = Integer.MAX_VALUE;
				int idx = 0;
				for(int j=0;j<n;j++) {
					if(!visited[j]) {
						Pos can_p = can.get(j);
						//ĵ�� û�ұ��� �Ÿ�
						double dis = Math.sqrt(Math.pow(cleaner_p.x-can_p.x, 2)+Math.pow(cleaner_p.y-can_p.y, 2));
						if(min>=dis) {
							min=dis;
							idx=j;
						}	
					}
				}
				//�ּҰŸ� > �ð�x�Ÿ�(ĵ ó�� �Ұ�)
				if(min>s*v) {
					continue;
				}else {
					visited[idx]=true;
					cnt++;
				}
			}
			System.out.println(cnt);
		}
	}
}
