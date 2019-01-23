package test_190123;

import java.util.Arrays;
import java.util.Scanner;

//n�� �������� ���� �ִ� ��ǥ x, ��ġ�ϰ��� �ϴ� ������ ���� c�� �־��� �� �ִ��� ���� ������ �������̸� ����� �� ���� ������ �� �Ÿ��� �ִ밪 ���ϱ�
public class B_2110 {

	static int [] x;
	static int c;
	
	public static boolean result(int mid) {
		int cnt = 1;
		int last = x[0];
		for(int i=1;i<x.length;i++) {
			//�� �� ��(=���� ������)�Ÿ��� ���ذŸ� �̻��̸�(=��ġ ����)
			if(x[i]-last>=mid) {
				cnt++;
				last=x[i];
			}
		}
		
		//������ ���ذŸ����� �Էµ� �����ŭ ������ ��ġ ���� ���� ��ȯ
		//true�� ���ذŸ� ���� up
		//false�� ���ذŸ� ���� down
		return cnt>=c;
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		c = sc.nextInt();
		
		if(2<=n&&n<=200000&&2<=c&&c<=n) {
			x = new int[n];
			//���� ��ǥ �Է�
			for(int i=0;i<x.length;i++) {
				x[i]=sc.nextInt();
			}
			Arrays.sort(x);
			//�̺�Ž��
			//�ִܰŸ�
			int left = 1;
			//���亯��
			int ans = 1;
			//����Ÿ�
			int right = x[x.length-1]-x[0];
			while(left<=right) {
				//�ݺ� �� ���� �����Ǵ� ���� ������ �� ���ذŸ�
				int mid = (left+right)/2;
				if(result(mid)) {
					left=mid+1;
					ans=Math.max(ans, mid);
				}else {
					right=mid-1;
				}
			}
			System.out.println(ans);
		}
	}
}
