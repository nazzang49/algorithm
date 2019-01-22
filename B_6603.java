package test_190122;

import java.util.ArrayList;
import java.util.Scanner;

//1���� 49������ ���� �� n���� ��� ���� �κ����տ��� 6���� ���� ���� ��� ����� �� ����ϱ�
public class B_6603 {

	//�κ������� ũ��
	static int n;
	static int [] arr;
	
	public static void dfs(int start, ArrayList<Integer> list) {
		//6���� ��� ����ٸ�
		if(list.size()==6) {
			System.out.println();
			for(int i=0;i<list.size();i++) {
				System.out.print(list.get(i)+" ");
			}
		}else {
			for(int i=start+1;i<arr.length;i++) {
				list.add(arr[i]);
				dfs(i, list);
				//��Ʈ��ŷ
				list.remove(list.size()-1);
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		while(true) {
			n = sc.nextInt();
			//0�� �ԷµǸ� Ž�� ����
			if(n==0) {
				break;
			}
			ArrayList<Integer> list = new ArrayList<>();
			arr = new int[n];
			//�κ����� �Է�
			for(int i=0;i<arr.length;i++) {
				arr[i]=sc.nextInt();
			}
			//����� �� Ž��
			for(int i=0;i<arr.length;i++) {
				list.add(arr[i]);
				dfs(i, list);
				list.clear();
			}
			System.out.println();
		}
	}
}
