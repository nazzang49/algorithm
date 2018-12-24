package solution;

import java.util.Scanner;

//�ѱ����� �տ� �� �ִ� ����� ���� �־����� �ּ� a Ȥ�� b�� ������ �� ��ġ�Ⱑ �����ϴٸ� ���� �� �տ� ���µ����� �ɸ��� �ּҽð� ���ϱ� 
public class Q82 {

	//�ɸ��� �ּ� �ð�
	static int cnt = Integer.MAX_VALUE;
	static int m;
	static int k;
	
	public static void dfs(int n, int time) {
		//���� �� �տ� ���� �Ǹ�
		if(n==0) {
			if(time<=cnt) {
				cnt=time;
			}
		}else if(n>0) {
			time++;
			n--;
			for(int i=0;i<2;i++) {
				if(i==0) {
					n-=m;
					dfs(n,time);
					n+=m;
				}else {
					n-=k;
					dfs(n,time);
					n+=k;
				}
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		m = sc.nextInt();
		k = sc.nextInt();
		
		if(0<=n&&n<=1000000&&0<=m&&m<=n&&0<=k&&k<=n) {
			dfs(n,0);
			System.out.println(cnt);
		}
	}
}
