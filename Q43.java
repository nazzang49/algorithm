package solution;

import java.util.Scanner;

//begin word�� target word�� �־��� �� ���ڿ��� �̷���� �迭�� Ȱ���Ͽ� �ܾ� ��ȯ �� ���ľ��ϴ� ���� �ּ� �ܰ� ���ϱ�
public class Q43 {

	static boolean [] visited;
	static String [] words;
	static String begin;
	static String target;
	//��ȯ�� �ɸ��� �ܰ� �� ���� �ּ� �ܰ�
	static int min = Integer.MAX_VALUE;
	
	public static void dfs(int start, String now, int cnt) {
		if(now.equals(target)) {
			if(min>=cnt) {
				min=cnt;
			}
		}else {
			for(int i=start;i<words.length;i++) {
				//���� �湮���� ���� ���ڿ��̸�
				if(!visited[i]) {
					visited[i]=true;
					//begin�� �迭�� ��� ���ڿ��� ���� ���� ���� ������ ����
					int tmp = 0;
					for(int j=0;j<words[i].length();j++) {
						if(now.charAt(j)!=words[i].charAt(j)) {
							tmp++;
						}
					}
					//�ٸ� ���� ������ 1���̰�(��ȯ ����)
					if(tmp==1) {
						cnt++;
						dfs(i,words[i],cnt);
						//���� ������ ��� ������ cnt ������ ���� dfs�� ����Ǿ�� �ϹǷ� cnt-- ���� 
						cnt--;
					}
					visited[i]=false;
				}
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		//�ܰ躰 ��ȯ�� �����ϵ��� �־����� ���ڿ� �迭
		int n = sc.nextInt();
		begin = sc.next();
		target = sc.next();
		
		if(3<=n&&n<=50) {
			words = new String[n];
			visited = new boolean[n];
			//�Է�
			for(int i=0;i<words.length;i++) {
				String str = sc.next();
				if(3<=str.length()&&str.length()<=10) {
					words[i]=str;
				}else {
					System.out.println("�Է� ��Ģ�� Ȯ���ϼ���.");
					System.exit(0);
				}
			}
			//Ž�� ����(DFS)
			dfs(0,begin,0);
			if(min==0) {
				System.out.println("��ȯ�Ұ�");
				System.exit(0);
			}else {
				System.out.println(min);
			}
		}
	}
}
