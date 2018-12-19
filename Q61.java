package solution;

import java.util.ArrayList;
import java.util.Scanner;

//�� ȸ���� ���۽ð��� ����ð��� �־��� ��, �ִ��� ���� ȸ�Ǹ� �����ϵ��� �ϴ� ����� ȸ�� ��ȣ�� ������� ����ϱ�
public class Q61 {

	//������ �Ǵ� ȸ�� ��ȣ ���� �迭
	static ArrayList<Integer> answer = new ArrayList<>();
	static boolean [] visited;
	static int [] start;
	static int [] end;
	
	public static void dfs(int num, ArrayList<Integer> tmp) {
		//������ ȸ�ǰ� ������ �ð�
		int end_bfo = end[num];
		for(int i=1;i<start.length;i++) {
			//�湮���� �ʾҰ�, ���� �ð��� ���� ���� �ð����� ũ�ų� ���� ���(=ȸ�� ����)
			if(!visited[i]&&start[i]>=end_bfo) {
				visited[i]=true;
				tmp.add(i);
				dfs(i, tmp);
				tmp.remove(tmp.size()-1);
				visited[i]=false;
			}
		}
		
		//���̽��� ������ ��� ȸ�� ������ ���� ���
		if(tmp.size()>=answer.size()) {
			answer.clear();
			for(int i=0;i<tmp.size();i++) {
				answer.add(tmp.get(i));
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		//ȸ�� ����
		int n = sc.nextInt();
		
		if(5<=n&&n<=500) {
			start = new int[n+1];
			end = new int[n+1];
			visited = new boolean[n+1];
			//�� ���̽��� ȸ�� ��ȣ ���� �迭
			ArrayList<Integer> tmp = new ArrayList<>();
			
			//�Է�
			for(int i=1;i<start.length;i++) {
				int tmp1 = sc.nextInt();
				int tmp2 = sc.nextInt();
				if(tmp1<=500&&tmp2<=500) {
					start[i]=tmp1;
					end[i]=tmp2;
				}
			}
			//����
			for(int i=1;i<start.length;i++) {
				if(!visited[i]) {
					visited[i]=true;
					tmp.add(i);
					dfs(i,tmp);
					tmp.clear();
					visited[i]=false;
				}
			}
			System.out.println(answer.size());
			for(int i=0;i<answer.size();i++) {
				System.out.println(answer.get(i));
			}
		}
	}
}
