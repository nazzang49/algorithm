package test_190125;

import java.util.Scanner;

//���̰� ���� �� �ܾ �־��� ��, �� �ܾ ���Ե� ��� ������ ���ĺ� �Ÿ� ���ϱ�
public class B_5218 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		//�ִ� �׽�Ʈ ���̽� ���� = 100
		if(n<100) {
			int k = 0;
			String [] ans = new String[n];
			while(k<n) {
				//���� �迭 �ʱ�ȭ
				ans[k]="Distances: ";
				String A = sc.next();
				String B = sc.next();
				
				for(int i=0;i<A.length();i++) {
					if(A.charAt(i)<=B.charAt(i)) {
						ans[k]+=Math.abs(A.charAt(i)-B.charAt(i))+" ";	
					}else {
						ans[k]+=B.charAt(i)-A.charAt(i)+26+" ";
					}
				}
				
				k++;
			}
			for(int i=0;i<ans.length;i++) {
				System.out.println(ans[i]);
			}
		}	
	}
}
