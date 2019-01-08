package solution;

import java.util.Arrays;
import java.util.Scanner;

//���� ������ ������ �� �Ÿ��� �ִ밡 �ǵ��� �ϴ� ����� ����ϱ�
public class Q144 {

	static int [] x;
	static int c;
	static int max = Integer.MIN_VALUE;
	
	public static void dfs(int now, int [] dis, int count) {
		//������ ��� ��ġ���� ��
		if(count==c) {
			Arrays.sort(dis);
			if(max<=dis[0]) {
				max=dis[0];
			}
		}else {
			count++;
			for(int i=now+1;i<x.length;i++) {
				dis[count-2]=x[i]-x[now];
				dfs(i,dis,count);
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		c = sc.nextInt();
		
		if(2<=n&&n<=200000&&2<=c&&c<=200000) {
			x = new int[n];
			int [] dis = new int[c-1];
			//���� ��ġ �Է�
			for(int i=0;i<n;i++) {
				x[i]=sc.nextInt();
			}
			//���� ��ġ �������� ����
			Arrays.sort(x);
			for(int i=0;i<x.length;i++) {
				dfs(i,dis,1);
			}
			System.out.println(max);
		}
	}
}
