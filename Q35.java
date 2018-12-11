package solution;

import java.util.ArrayList;
import java.util.Scanner;

//������ ���̿� ���� ���� 0-9������ ���ڵ��� ���� �����Ͽ� ���� �� �ִ� �Ҽ� ����ϱ�
public class Q35 {

	//�� �Ҽ� ����
	static int cnt = 0;
	//�ߺ� �Ǻ��� �迭
	static ArrayList<Integer> list = new ArrayList<>();
	//�湮����
	static boolean [] visited;
	static String str;
	
	//�Ҽ����� �Ǻ��ϴ� �޼ҵ�
	public static void sosoo(int n) {
		boolean flag = false;
		if(n>=2) {
			for(int i=2;i<=n/2;i++) {
				if(n%i==0) {
					flag=true;
					break;
				}
			}
			//�Ҽ��̸�
			if(!flag) {
				for(int i=0;i<list.size();i++) {
					//�̹� Ȯ�ε� �Ҽ��̸�
					if(list.get(i)==n) {
						flag=true;
						break;
					}
				}
				if(!flag) {
					System.out.println(n);
					cnt++;
					list.add(n);
				}
			}
		}
	}
	
	public static void dfs(String tmp) {
		if(!(str.length()==tmp.length())) {
			for(int i=0;i<str.length();i++) {
				if(!visited[i]) {
					visited[i]=true;
					tmp+=str.charAt(i);
					int num = Integer.parseInt(tmp);
					sosoo(num);
					dfs(tmp);
					visited[i]=false;
				}
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		str = sc.next();
		
		if(1<=str.length()&&str.length()<=7) {
			visited = new boolean[str.length()];
			//011�� 11�� ���� ������ ���
			for(int i=0;i<str.length();i++) {
				String tmp = "";
				if(!visited[i]) {
					visited[i]=true;
					tmp+=str.charAt(i);
					int num = Integer.parseInt(tmp);
					sosoo(num);
					dfs(tmp);
					visited[i]=false;
				}
			}
			System.out.println(cnt);
		}
	}
}
