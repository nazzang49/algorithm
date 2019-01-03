package solution1;

import java.util.Arrays;
import java.util.Scanner;

//���� ���� ��ġ, ��� �ҵ��� ������ �ʱ� �������� �־��� �� ��� ������ ��ģ �� ���� �ִ� �� �������� �ִ밪 ���ϱ�(1�� ��� �� ������ 1 ����)
public class Q124 {

	//�ִ밪 ���� ����
	static int max = Integer.MIN_VALUE;
	static boolean [] visited;
	static int k;
	static int n;
	static int [] x;
	
	public static void dfs(int start, int dis, int sum, int count) {
		if(count==n) {
			//���� �������� �հ� ��
			if(max<=sum) {
				max=sum;
			}
		}else {
			count++;
			for(int i=0;i<n;i++) {
				//�湮���� ���� ���̸�
				if(!visited[i]) {
					visited[i]=true;
					//���� ��ġ���� �����ϱ���� �ɸ� ��ü �̵� �Ÿ�
					dis+=Math.abs(x[i]-x[start]);
					if(k-dis>0) {
						//�⺻ ������ - ���� �̵� �Ÿ�(���� ��ġ�� �ִ� ���� ���� ������)
						sum+=(k-dis);
						dfs(i,dis,sum,count);
						sum-=(k-dis);
					}else {
						dfs(i,dis,sum,count);
					}
					dis-=Math.abs(x[i]-x[start]);
					visited[i]=false;
				}
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		
		if(0<=n&&n<=100&&1<=k&&k<=10000) {
			x = new int[n];
			visited = new boolean[n];
			//�� �ҵ��� ��ġ ������� �Է�
			for(int i=0;i<x.length;i++) {
				x[i]=sc.nextInt();
			}
			//�ҵ��� ��ġ �������� ����
			Arrays.sort(x);
			//0�������� ���
			for(int i=0;i<x.length;i++) {
				visited[i]=true;
				//��ü ���������� ù��° �ҿ��� �̵��ϴ� ���� �����ϴ� �� �ݿ�
				dfs(i,Math.abs(x[i]),k-Math.abs(x[i]),1);
				visited[i]=false;
			}
			System.out.println(max);
		}
	}
}
