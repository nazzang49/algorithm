package test_190128;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//ī�װ��� �ߺ����� �ʵ��� ������ �ִ� �м� �������� ������ �� �ִ� ��� ����� �� ����ϱ�
public class B_9375 {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		if(t<=100) {
			int k = 0;
			//�׽�Ʈ ���̽��� ���� ����� �迭
			int [] ans = new int[t];
			while(k<t) {
				int n = Integer.parseInt(br.readLine());
				String [] item = new String[n];
				//1���� �Դ� ���� �ʱ�ȭ
				ans[k]=n;
				//ī�װ��� �迭�� ����
				for(int i=0;i<n;i++) {
					item[i]=br.readLine().split(" ")[1];
				}
				//����� �� Ž�� ����
				for(int i=0;i<item.length-1;i++) {
					for(int j=i+1;j<item.length;j++) {
						if(!item[i].equals(item[j])) {
							ans[k]++;
						}
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
