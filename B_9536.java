package test_190118;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

//ù �ٿ� �ٸ� ������ �Ҹ��� ���� ������ ���� �Ҹ�, ��°�ٺ��� �ٸ� �������� �����Ҹ��� �ϳ��� �־��� �� ������ �����Ҹ� ����ϱ�
public class B_9536 {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		//���� ����� �迭
		String [] ans = new String[t];
		
		int k = 0;
		while(k<t) {
			//�ٸ� ������ �Ҹ��� ���� ������ �����Ҹ�
			String str = br.readLine();
			String [] arr = str.split(" ");
			while(true) {
				ans[k]="";
				String other = br.readLine();
				//������ �����Ҹ� ���� ���� �ԷµǸ� ������ �����Ҹ� ���
				if(other.substring(0, 4).equals("what")) {
					for(int i=0;i<arr.length;i++) {
						ans[k]+=arr[i]+" ";
					}
					break;
				}
				for(int i=0;i<arr.length;i++) {
					if(!arr[i].equals(other.split(" ")[2])) {
						ans[k]+=arr[i]+" ";
					}
				}
				arr = ans[k].split(" ");
			}
			k++;
		}
		for(int i=0;i<ans.length;i++) {
			System.out.println(ans[i]);
		}
	}
}
