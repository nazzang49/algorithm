package test_190121;

import java.util.ArrayList;
import java.util.Scanner;

//������ �ε������� ���� ���ڰ� �ݺ��ؼ� �����ϴ� �׷� �ܾ n���� �������� ������ ���, ������ �ܾ ���� ���� ���ڿ� ����ϱ�
public class B_1317 {

	static boolean [] visited;
	static String [] words;
	static ArrayList<String> ans = new ArrayList<>();
	
	public static boolean result(String str) {
		int [] alpha = new int[26];
		alpha[str.charAt(0)-'a']++;
		for(int i=1;i<str.length();i++) {
			//�̹� ������ ���� �ִµ� ���� ���ڰ� ���� ���ڿ� ���� �ʴٸ�(�׷�ܾ� X)
			if(alpha[str.charAt(i)-'a']!=0&&str.charAt(i-1)!=str.charAt(i)) {
				return false;
			}
		}
		return true;
	}
	
	//��� ������ ����� �� ����
	public static void dfs(int count, String str) {
		//��� �ܾ ������ ���
		if(count==words.length) {
			if(!ans.isEmpty()) {
				System.out.println("�ϳ��� ���� ����� �� �����ϴ�.");
				System.exit(0);
			}
			ans.add(str);
		}else {
			String tmp = str;
			count++;
			for(int i=0;i<words.length;i++) {
				str+=words[i];
				//������� �ʾҰ�, ����ؼ� �׷�ܾ� ���°� �����Ǵ� ���
				if(!visited[i]&&result(str)) {
					visited[i]=true;
					dfs(count,str);
					visited[i]=false;
				}
				//�ٽ� �ʱ�ȭ
				str=tmp;
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		if(1<=n&&n<=100) {
			//n���� ������ �ܾ� �Է�
			words = new String[n];
			visited = new boolean[n];
			for(int i=0;i<n;i++) {
				words[i]=sc.next();
			}
			//Ž�� ����
			for(int i=0;i<n;i++) {
				visited[i]=true;
				dfs(1, words[i]);
				//��Ʈ��ŷ
				visited[i]=false;
			}
			if(!ans.isEmpty()) {
				System.out.println(ans.get(0));	
			}else {
				System.out.println("���ǿ� �´� �ܾ ������ �� �����ϴ�.");
			}
		}
	}
}
