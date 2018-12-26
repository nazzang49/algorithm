package solution;

import java.util.Arrays;
import java.util.Scanner;

//������ũ����� �ڽź��� �۰ų� ���� ������ ���Ÿ� �԰� ���̸� 1 ������Ű�µ�, �ʱ� ���̿� ������ ���̵��� �迭�� �־��� �� ���� ������ũ���� ���� ����ϱ�
public class Q89 {

	public static int result(int [] height, int k) {
		//���� ���� �������� ����
		Arrays.sort(height);
		for(int i=0;i<height.length;i++) {
			if(k>=height[i]) {
				k++;
			}
		}
		return k;
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		//���� ����
		int n = sc.nextInt();
		//������ũ������ �ʱ� ����
		int k = sc.nextInt();
		
		if(1<=n&&n<=1000&&1<=k&&k<=10000) {
			int [] height = new int[n];
			//���� ���� �Է�
			for(int i=0;i<n;i++) {
				int tmp = sc.nextInt();
				if(1<=tmp&&tmp<=10000) {
					height[i]=tmp;
				}
			}
			//Ž��
			int answer = result(height, k);
			System.out.println(answer);
		}
	}
}
