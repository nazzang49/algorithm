package test_190211;

import java.util.ArrayList;
import java.util.Scanner;

//�Է����� �־����� ��� �ο��� ģ�� ���踦 ����� ��, ���� ������ ����� �������� ����ϱ�
public class B_1058 {

	static int n;
	static boolean [][] line;
	static boolean [] v;
	
	public static int dfs(int num) {
		int cnt = 0;
		//���� ģ���� �ο�
		ArrayList<Integer> direct = new ArrayList<>();
		for(int i=0;i<n;i++) {
			if(!v[i]&&line[num][i]) {
				cnt++;
				v[i]=true;
				direct.add(i);
			}
		}
		//�ǳ� �ǳ� �ƴ� �ο�
		for(int i=0;i<direct.size();i++) {
			for(int j=0;j<n;j++) {
				if(!v[j]&&line[direct.get(i)][j]) {
					cnt++;
				}
			}
		}
		return cnt;
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int max = Integer.MIN_VALUE;
		
		if(n<=50) {
			//A�� B�� ģ���̸�, B�� A�� ģ��(ģ�� ���� �Է�)
			line = new boolean[n][n];
			v = new boolean[n];
			for(int i=0;i<n;i++) {
				String str = sc.next();
				for(int j=0;j<n;j++) {
					//ģ���̸�
					if(str.charAt(j)=='Y') {
						line[i][j]=line[j][i]=true;
					}
				}
			}
			//���� ģ���� �ο� ����
			for(int i=0;i<n;i++) {
				v[i]=true;
				int cnt = dfs(i);
				if(cnt>max) {
					max=cnt;
				}
				v=new boolean[n];
			}
			System.out.println(max);
		}
	}
}
