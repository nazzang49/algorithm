package test_190328;

import java.util.Arrays;
import java.util.Scanner;

//������ �� n, �ʿ��� ���� m����, �� ������ ���̰� �־��� ��, m���� �̻��� �������� ���� ���ܱ� ���� �ִ� ���ϱ�
public class B_2805 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		if(n<=1000000&&m<=2000000000) {
			int [] namu = new int[n];
			//���� ���� �Է�
			for(int i=0;i<n;i++) {
				namu[i]=sc.nextInt();
			}
			//�������� ����
			Arrays.sort(namu);
			//�̺�Ž��
			int left = 1;
			int right = namu[namu.length-1];
			//���ܱ� �ִ� ����
			int h = 0;
			long sum = 0;
			while(left<=right) {
				h = (left+right)/2;
				sum = 0;
				for(int i=0;i<namu.length;i++) {
					//������ ���� > ���ܱ� ���� = �߸� �κ� ����
					if(namu[i]>h) sum+=(namu[i]-h);
					if(sum>m) break;
				}
				//�� ���� �ڸ� ��� = ���ܱ� ���� ����
				if(sum>m) {
					left=h+1;
				}
				//�� ���� �ڸ� ��� = ���ܱ� ���� ����
				else if(sum<m) {
					right=h-1;
				}
				//�� �°� �ڸ� ���
				else {
					right=h;
					break;
				}
			}
			System.out.println(right);
		}	
	}
}
