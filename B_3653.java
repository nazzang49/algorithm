package test_190123;

import java.util.ArrayList;
import java.util.Scanner;

//dvd n��, ������ �ϴ� ��ȭ�� ���� m���� �Էµ� ��, �ش��ϴ� ��ȣ�� dvd�� �� �� �� ���� �ִ� dvd ���� ����ϱ�
public class B_3653 {

	static ArrayList<Integer> ans = new ArrayList<>();
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		//�׽�Ʈ ���̽��� ������ �ִ� 100ȸ
		if(t<=100) {
			int k = 0;
			while(k<t) {
				int n = sc.nextInt();
				int m = sc.nextInt();
				if(1<=n&&n<=100000&&1<=m&&m<=100000) {
					ArrayList<Integer> dvd = new ArrayList<>();
					//dvd ��ȣ �Է�(���� ���� 1��)
					for(int i=n;i>=1;i--) {
						dvd.add(i);
					}
					for(int i=0;i<m;i++) {
						int tmp = sc.nextInt();
						for(int j=0;j<dvd.size();j++) {
							if(dvd.get(j)==tmp) {
								ans.add(dvd.size()-1-j);
								int out = dvd.remove(j);
								dvd.add(out);
								break;
							}
						}
					}
				}
				ans.add(-1);
				k++;
			}
			for(int i=0;i<ans.size();i++) {
				if(ans.get(i)==-1) {
					System.out.println();
					continue;
				}
				System.out.print(ans.get(i)+" ");
			}
		}
	}
}
