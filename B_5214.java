package test_190211;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//������ �մ� ������Ʃ�꿡 ���� ������ �־��� ��, 1������ n�� ������ �̵��� �� ���ľ� �ϴ� ������ �ּҰ� ���ϱ�
public class B_5214 {

	static int [] dis;
	static int n;
	//�� �� ���� ����
	static ArrayList<ArrayList<Integer>> connect = new ArrayList<>();
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		
		if(n<=100000&&m<=1000&&k<=1000) {
			//1������ n�� ������ ����(�ʱ�ȭ), n�� ���ĺ��� k�������� ���̿�(=������Ʃ��)
			dis = new int[n+k+1];
			Arrays.fill(dis, 100000);
			
			//���̿����� ������ ����Ʈ ����
			for(int i=0;i<=n+k;i++) {
				connect.add(new ArrayList<>());
			}
			
			//������Ʃ�� ���� �Է�
			for(int i=1;i<=k;i++) {
				//���� ��� ����(���� �������� ������, ���� ���θ� ǥ���ϱ� ���� ����)
				int dummy = n+i;
				for(int j=0;j<m;j++) {
					int node = sc.nextInt();
					connect.get(dummy).add(node);
					connect.get(node).add(dummy);
				}
			}
			
			//�̵� �� ���� �ּ� ����� ������ �ʾƵ� �Ǳ� ������ �켱���� ť ������� �ʾƵ� ��
			Queue<Integer> q = new LinkedList<>();
			//1���� = 1(��� ����)
			dis[1]=1;
			q.add(1);
			
			while(!q.isEmpty()) {
				int cur = q.poll();
				
				for(Integer next : connect.get(cur)) {
					if(dis[next]>dis[cur]+1) {
						//���� ��尡 ���� ���̸�(�ּҰ� ����)
						if(cur<=n) dis[next]=dis[cur]+1;
						//���� ��尡 ���� ���̸�(�״�� �������� ����)
						else dis[next]=dis[cur];
						q.add(next);
					}
				}
			}
			System.out.println(dis[n]==100000? -1:dis[n]);
		}
	}
}
