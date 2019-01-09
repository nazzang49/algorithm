package solution;

import java.util.Scanner;

//���� ���� n���� �־����� ��, ������ ��� ���� GCD �� ���ϴ� ���α׷� �ۼ��ϱ�
public class Q147 {

	//�� ���� �ִ� ����� ���ϴ� ��Ŭ���� �޼ҵ�
	public static int GCD(int a, int b) {
		if(a<b) {
			int tmp = a;
			a=b;
			b=tmp;
		}
		return a%b==0? b:GCD(a%b,b);
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int [] answer = new int[t];
		
		int k = 0;
		while(k<t&&t<=100) {
			int n = sc.nextInt();
			int [] arr = new int[n];
			//n���� �ڿ��� �Է�
			for(int i=0;i<n;i++) {
				arr[i]=sc.nextInt();
			}
			int sum = 0;
			//�� ���� �ִ����� �� ���ϱ�
			for(int i=0;i<n-1;i++) {
				for(int j=i+1;j<n;j++) {
					sum+=GCD(arr[i],arr[j]);
				}
			}
			answer[k]=sum;
			k++;
		}
		for(int i=0;i<answer.length;i++) {
			System.out.println(answer[i]);
		}
	}
}
