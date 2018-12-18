package solution;

import java.util.ArrayList;
import java.util.Scanner;

//어떠한 자연수의 각 자리 숫자를 제곱해서 모두 더하는 과정에서 이전에 등장했던 숫자가 다시 등장할 때, 그 수가 89로 귀결되는 자연수 구하기
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
