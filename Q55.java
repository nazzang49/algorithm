package solution;

import java.util.ArrayList;
import java.util.Scanner;

//��� �ڿ����� �� �ڸ� ���ڸ� �����ؼ� ��� ���ϴ� �������� ������ �����ߴ� ���ڰ� �ٽ� ������ ��, �� ���� 89�� �Ͱ�Ǵ� �ڿ��� ���ϱ�
public class Q55 {

	static ArrayList<Integer> answer = new ArrayList<>();
	
	public static boolean dfs(int n) {
		if(n==89) {
			return true;
		}else if(n==1) {
			return false;
		}else {
			String str = String.valueOf(n);
			int sum = 0;
			int tmp = 0;
			for(int i=0;i<str.length();i++) {
				tmp = str.charAt(i)-'0';
				sum+=Math.pow(tmp, 2);
			}
			return dfs(sum);
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		boolean flag = false;
		for(int i=1;i<10000000;i++) {
			flag = dfs(i);
			if(flag) {
				answer.add(i);
			}
		}
		
		for(int i=0;i<answer.size();i++) {
			System.out.println(answer.get(i));
		}
	}
}
