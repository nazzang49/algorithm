package solution;

import java.util.Scanner;

//���簢�� ������ ü����, ���� ����(�����¿�, �밢�� �̵� ����)�� �־��� �� �� ���� ���θ� ������ �� ������ ��ġ�ϴ� ����� �� ���ϱ�
public class Q45 {

	//1-n���� ��� �湮�ߴ��� üũ�� �迭
	static boolean [] chk;
	static int n;
	//��� ����� ��
	static int cnt;
	
	public static void dfs(int start, int ok) {
		//������ �����ϸ� �� �湮���� ���
		if(ok==n) {
			cnt++;
		}else {
			for(int i=0;i<n;i++) {
				if(i!=start+1&&i!=start-1) {
					if(!chk[i]) {
						chk[i]=true;
						ok++;
						dfs(i,ok);
						ok--;
						chk[i]=false;
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		if(1<=n&&n<=12) {
			chk = new boolean[n];
			for(int i=0;i<chk.length;i++) {
				if(!chk[i]) {
					chk[i]=true;
					dfs(i,1);
					chk[i]=false;
				}
			}
			System.out.println(cnt);
		}
	}
}
