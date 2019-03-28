package test_190328;

import java.util.Arrays;
import java.util.Scanner;

//�� ���濡�� ��û�ϴ� ����, �̸� ������ �� ������ �־��� ��, ������ �ִ��� ������ Ȱ���ϵ��� �ϴ� ���Ѱ� ���ϱ�
public class B_2512 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		if(n<=10000) {
			int [] arr = new int[n];
			//��û ���� �Է�
			for(int i=0;i<arr.length;i++) {
				arr[i]=sc.nextInt();
			}
			//������ �� �ִ� �� ����
			int limit = sc.nextInt();
			//�������� ����
			Arrays.sort(arr);
			//�̺� Ž��
			int left = 1;
			int right = arr[arr.length-1];
			long sum = 0;
			int mid = 0;
			while(left<=right) {
				mid = (left+right)/2;
				sum = 0;
				for(int i=0;i<arr.length;i++) {
					if(arr[i]>mid) sum+=mid;
					else sum+=arr[i];
				}
				if(sum>limit) {
					right=mid-1;
				}else if(sum<limit) {
					left=mid+1;
				}else {
					right=mid;
					break;
				}
			}
			System.out.println(right);
		}	
	}
}
