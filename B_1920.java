package test_190328;

import java.util.Arrays;
import java.util.Scanner;

//N���� ������ �־��� ��, �� �ȿ� X��� ������ �����ϴ��� �˾Ƴ��� ���α׷� �ۼ��ϱ�
public class B_1920 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		//������ ���� ���� ���� �ֱ� ������ �̺�Ž���� ����
		if(n<=100000) {
			int [] arr = new int[n];
			//���� �Է�
			for(int i=0;i<arr.length;i++) {
				arr[i]=sc.nextInt();
			}
			//�������� ����
			Arrays.sort(arr);
			int m = sc.nextInt();
			int [] ans = new int[m];
			for(int i=0;i<m;i++) {
				//ã���� �ϴ� �� �Է�
				int find = sc.nextInt();
				//�̺�Ž�� ����
				int left = 0;
				int right = arr.length-1;
				int mid = 0;
				while(left<=right) {
					mid = (left+right)/2;
					//ã���� �ϴ� ���� �迭�� ���ʿ� ������
					if(arr[mid]>find) {
						right=mid-1;
					}
					//ã���� �ϴ� ���� �迭�� �����ʿ� ������
					else if(arr[mid]<find) {
						left=mid+1;
					}
					//ã���� �ϴ� ���� �����ϸ�
					else {
						ans[i]=1;
						break;
					}
				}
			}
			//���� ���
			for(int i=0;i<ans.length;i++) System.out.println(ans[i]);
		}	
	}
}
