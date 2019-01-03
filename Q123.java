package solution1;

import java.util.ArrayList;
import java.util.Scanner;

//�Ϻ��� ���� n, ����̰� �ѹ��� ���� �� �ִ� �Ϻ��� ���� k�� �־��� �� �Ϻ��� ���� �� �ִ� ��� ����� ���� ���ϰ� ����ϱ�
public class Q123 {

	static int n;
	static int k;
	static ArrayList<ArrayList<Integer>> answer = new ArrayList<>();
	
	public static void dfs(int sum, ArrayList<Integer> list) {
		if(sum==n) {
			for(int i=0;i<list.size();i++) {
				System.out.print(list.get(i)+" ");
			}
			System.out.println();
		}else if(sum<n){
			for(int i=1;i<=k;i++) {
				sum+=i;
				list.add(i);
				dfs(sum,list);
				sum-=i;
				list.remove(list.size()-1);
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		ArrayList<Integer> list = new ArrayList<>();
		
		if(0<=k&&k<=n&&n<=10) {
			for(int i=1;i<=k;i++) {
				list.add(i);
				dfs(i, list);
				list.remove(list.size()-1);
			}
		}
	}
}
