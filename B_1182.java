package test_190326;

import java.util.Scanner;

//�־��� �������� �κ� ������ ���� S�� �Ǵ� ����� �� ���ϱ�
public class B_1182 {

	static int n;
	static int s;
	static int [] arr;
	static int cnt = 0;
	
	public static void dfs(int cur, int sum) {
		if(sum==s) {
			cnt++;
		}
		for(int i=cur+1;i<n;i++) {
			sum+=arr[i];
			dfs(i,sum);
			//��Ʈ��ŷ
			sum-=arr[i];
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		s = sc.nextInt();
		
		if(n<=20&&Math.abs(s)<=1000000) {
			arr = new int[n];
			//���� �Է�
			for(int i=0;i<arr.length;i++) {
				arr[i]=sc.nextInt();
			}
			//Ž��
			for(int i=0;i<n;i++) {
				dfs(i,arr[i]);
			}
			System.out.println(cnt);
		}	
	}
}
