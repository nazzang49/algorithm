package solution;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthSeparatorUI;

//�� ����� ���� �� �ִ� ���� �̸��� ������ 2���� �迭�� �־��� ��, ������ �ߺ� ���� ���� ������ ������ �� ���ϱ�
public class Q38 {

	//��� ������ ��
	static int cnt = 0;
	static boolean [] visited;
	static String [][] clothes;
	
	public static void dfs(int start, int count, ArrayList<String> list) {
		//������ ������ ���ձ��� ���� ���
		for(int i=start;i<clothes.length;i++) {
			if(!visited[i]) {
				boolean flag = false;
				visited[i]=true;
				for(int j=0;j<list.size();j++) {
					//�ߺ��Ǵ� ��찡 �߻��ϸ�
					if(clothes[i][1].equals(list.get(j))) {
						flag = true;
						break;
					}
				}
				//�ߺ����� �ʴ� ���ο� �����̸�(���� ����+1, list�� �߰�)
				if(!flag) {
					list.add(clothes[i][1]);	
					cnt++;
					dfs(i,count+1,list);
					list.remove(list.size()-1);
				}
				visited[i]=false;
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		if(1<=n&&n<=30) {
			clothes = new String[n][2];
			visited = new boolean[n];
			ArrayList<String> list = new ArrayList<>();
			//�Է�
			for(int i=0;i<n;i++) {
				String tmp1 = sc.next();
				String tmp2 = sc.next();
				if(1<=tmp1.length()&&tmp1.length()<=20&&1<=tmp2.length()&&tmp2.length()<=20) {
					clothes[i][0]=tmp1;
					clothes[i][1]=tmp2;
				}
			}
			//Ž��
			for(int i=0;i<clothes.length;i++) {
				if(!visited[i]) {
					visited[i]=true;
					//�Ѱ��� ������ �ʸ� �Դ� ���
					cnt++;
					list.add(clothes[i][1]);
					dfs(i,1,list);
					list.clear();
					visited[i]=false;
				}
			}
			System.out.println(cnt);
		}
	}
}
