package test_190325;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//l���� ���ڰ� �־��� ��, c���� ���ڸ� ��� ���� ������ ��� ��ȣ ����ϱ�(�ּ� 1�� ���� ����)
public class B_1759 {

	static int c;
	static int l;
	static boolean [] v;
	static char [] arr;
	
	public static void dfs(int cur, ArrayList<Character> list) {
		if(list.size()==c) {
			boolean flag = false;
			for(int i=0;i<list.size();i++) {
				char tmp = list.get(i);
				if(tmp=='a'||tmp=='i'||tmp=='o'||tmp=='u'||tmp=='e') {
					flag=true;
					break;
				}
			}
			//���� �Ѱ� �̻��϶��� ���
			if(flag) {
				//���
				for(int i=0;i<list.size();i++) {
					System.out.print(list.get(i));
				}
				System.out.println("");
			}
			return;
		}
		for(int i=cur+1;i<l;i++) {
			if(!v[i]) {
				v[i]=true;
				list.add(arr[i]);
				dfs(i,list);
				//��Ʈ��ŷ
				list.remove(list.size()-1);
				v[i]=false;
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		c = sc.nextInt();
		l = sc.nextInt();
		
		if(3<=c&&c<=l&&l<=15) {
			//���� �Է�
			String tmp = "";
			for(int i=0;i<l;i++) {
				tmp+=sc.next();
			}
			v = new boolean[l];
			ArrayList<Character> list = new ArrayList<>();
			arr = tmp.toCharArray();
			//���������� ����
			Arrays.sort(arr);
			//DFS Ž��
			for(int i=0;i<arr.length;i++) {
				v[i]=true;
				list.add(arr[i]);
				dfs(i,list);
				list.remove(list.size()-1);
				v[i]=false;
			}
		}	
	}
}
