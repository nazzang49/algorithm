package solution;

import java.util.ArrayList;
import java.util.Scanner;

//���� �ѷ� �ɾ� �ִ� ����� �� n��° �ο��� �ݺ� �����ϴ� �����۽� ���� ���ϱ�
public class Q135 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		if(1<=m&&m<=n&&n<=5000) {
			ArrayList<Integer> list = new ArrayList<>();
			StringBuilder sb = new StringBuilder();
			
			//�ڿ��� �Է�
			for(int i=1;i<=n;i++) {
				list.add(i);
			}
			
			int idx = 0;
			while(!list.isEmpty()) {
				idx+=m-1;
				//�ε����� �迭 ũ�� �Ѿ��(�ε��� ����)
				if(idx>=list.size()) {
					idx%=list.size();
				}
				sb.append(list.remove(idx)+" ");
			}
			System.out.println(sb.toString());
		}
	}
}
