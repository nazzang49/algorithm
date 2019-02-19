package test_190219;

import java.util.ArrayList;
import java.util.Scanner;

//�����̵��� �� n, �׵��� ���� �ִ� ������ �� ������ ������ �־��� ��, �� �׽�Ʈ ���̽����� ���� �������� �Ǻ��ϴ� ���α׷� �ۼ��ϱ�
public class B_2912 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int c = sc.nextInt();
		
		if(n<=300000&&c<=10000) {
			//������ ��(1��~)
			int [] nanjang = new int[n+1];
			
			//���� �Է�
			for(int i=1;i<=n;i++) {
				nanjang[i]=sc.nextInt();
			}
			
			ArrayList<String> ans = new ArrayList<>();
			int k = sc.nextInt();
			while(k!=0) {
				//������ �ٸ� ������ ��(1��~)
				int [] cap = new int[c+1];
				int start = sc.nextInt();
				int end = sc.nextInt();
				int half = (end-start+1)/2+1;
				
				boolean flag = false;
				for(int i=start;i<=end;i++) {
					cap[nanjang[i]]++;
					if(cap[nanjang[i]]>=half) {
						flag = true;
						ans.add("yes "+nanjang[i]);
						break;
					}
				}
				if(!flag) {
					ans.add("no");
				}
				k--;
			}
			//���� ���
			for(int i=0;i<ans.size();i++) {
				System.out.println(ans.get(i));
			}
		}	
	}
}
