package solution;

import java.util.Scanner;

//�ڸ��� ���� �˰���(�� �ڸ����� ���� �������� �������� ����) �ۼ��ϱ�
public class Q120 {
	
	public static int result(int n) {
		String str = String.valueOf(n);
		String tmp = "";
		int sum = 0;
		
		for(int i=0;i<str.length();i++) {
			tmp+=str.charAt(i);
			sum+=Integer.parseInt(tmp);
			tmp="";
		}
		
		return sum;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		if(1<=n&&n<=1000) {
			int [] arr = new int[n];
			int [] answer = new int[n];
			
			//���� �Է�
			for(int i=0;i<n;i++) {
				int tmp = sc.nextInt();
				if(1<=tmp&&tmp<=1000) {
					arr[i]=tmp;
					answer[i]=result(arr[i]);
				}
			}
			
			//�������� ����(by ����)
			for(int i=0;i<n;i++) {
				for(int j=0;j<n-1;j++) {
					if(answer[j]>answer[j+1]) {
						int tmp1 = answer[j];
						answer[j]=answer[j+1];
						answer[j+1]=tmp1;
						
						int tmp2 = arr[j];
						arr[j]=arr[j+1];
						arr[j+1]=tmp2;
					}
				}
			}
			
			for(int i=0;i<n;i++) {
				System.out.println(arr[i]);
			}
		}
	}
}
