package test_190125;

import java.util.HashMap;
import java.util.Scanner;

//�򹮰� ��ȣ�� ���ð� �־��� ��, ��Ģ�� ã�Ƴ��� �Էµ� ��ȣ���� �� ã�� ���α׷� �ۼ��ϱ�
public class B_9322 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		//�ִ� �׽�Ʈ ���̽� ���� = 100
		if(t<=100) {
			int k = 0;
			String [] ans = new String[t];
			while(k<t) {
				ans[k]="";
				//�ԷµǴ� �ܾ��� ����
				int n = sc.nextInt();
				
				//��ȣ���� �� ���ڰ� �򹮿��� ��� ��ġ�ϴ��� �ε��� ������ �迭
				HashMap<Integer, Integer> map = new HashMap<>();
				
				//�� ���� ���ڿ� �迭 �Է�
				String [] str1 = new String[n];
				String [] str2 = new String[n];
				
				for(int i=0;i<n;i++) {
					str1[i]=sc.next();
				}
				for(int i=0;i<n;i++) {
					str2[i]=sc.next();
				}
				
				boolean [] visited = new boolean[n];
				for(int i=0;i<n;i++) {
					for(int j=0;j<n;j++) {
						if(!visited[j]&&str1[i].equals(str2[j])) {
							visited[j]=true;
							map.put(i, j);
							break;
						}
					}
				}
				
				//��ȣ�� �Է�
				for(int i=0;i<n;i++) {
					str1[i]=sc.next();
				}
				//��ȣ�� �ؼ�
				for(int i=0;i<n;i++) {
					ans[k]+=str1[map.get(i)]+" ";
				}
				k++;
			}
			for(int i=0;i<ans.length;i++) {
				System.out.println(ans[i]);
			}
		}
	}
}
