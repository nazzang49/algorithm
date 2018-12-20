package solution;

import java.util.ArrayList;
import java.util.Scanner;

//��� �� ������ �ڵ� ���� �ع� ��ΰ� ������ �� ���� �ּ� ������ �ع� ��� ���ϱ�(��ο� ���ԵǴ� �� �ڵ� ��ȣ ���)
public class Q67 {

	//�ּ� ������ �ع� ��ο� ���ԵǴ� �ڵ� ��ȣ ����
	static ArrayList<Integer> answer = new ArrayList<>();
	static boolean [] visited;
	static String [] str;
	static boolean chk = false;
	static int count = 0;
	
	//�ع� ������� Ȯ�����ִ� �޼ҵ�
	public static boolean hamming(int idx1, int idx2) {
		int cnt = 0;
		for(int i=0;i<str[0].length();i++) {
			if(str[idx1].charAt(i)==str[idx2].charAt(i)) {
				cnt++;
			}
		}
		//1�� ���ڸ� �ٸ� ���(�ع� ���)
		if(cnt==str[0].length()-1) {
			return true;
		}
		return false;
	}
	
	public static void dfs(int start, int end, ArrayList<Integer> list) {
		if(start==end) {
			chk=true;
			count++;
			if(count==1) {
				for(int i=0;i<list.size();i++) {
					answer.add(list.get(i));
				}
			}else {
				if(list.size()<=answer.size()) {
					answer.clear();
					for(int i=0;i<list.size();i++) {
						answer.add(list.get(i));
					}
				}
			}
		}else {
			for(int i=0;i<str.length;i++) {
				boolean flag = false;
				if(!visited[i]) {
					visited[i]=true;
					flag = hamming(start, i);
					//�ع� ����� ���
					if(flag) {
						list.add(i);
						dfs(i,end,list);
						list.remove(list.size()-1);
					}
					visited[i]=false;
				}
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		if(3<=n&&n<=1000&&2<=k&&k<=30) {
			str = new String[n];
			visited = new boolean[n];
			//�� ���̽��� �ӽ� ����Ǵ� �ڵ� ��ȣ
			ArrayList<Integer> list = new ArrayList<>();
			//�ڵ� �Է�
			for(int i=0;i<n;i++) {
				String tmp = sc.next();
				if(tmp.length()==k) {
					str[i]=tmp;
				}
			}
			//Ž�� ����
			int start = sc.nextInt();
			int end = sc.nextInt();
			//��� ������ �湮�� ������ ����
			visited[start-1]=true;
			list.add(start-1);
			dfs(start-1,end-1, list);
			
			//����� ���� �����ϸ�
			if(chk) {
				for(int i=0;i<answer.size();i++) {
					System.out.println(answer.get(i)+1);
				}
			}else {
				System.out.println(-1);
			}
		}
	}
}
