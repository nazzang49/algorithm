package test_190122;

import java.util.ArrayList;
import java.util.Scanner;

//1부터 49까지의 숫자 중 n개를 골라 만든 부분집합에서 6개의 수를 고르는 모든 경우의 수 출력하기
public class B_6603 {

	//부분집합의 크기
	static int n;
	static int [] arr;
	
	public static void dfs(int start, ArrayList<Integer> list) {
		//6개를 모두 골랐다면
		if(list.size()==6) {
			System.out.println();
			for(int i=0;i<list.size();i++) {
				System.out.print(list.get(i)+" ");
			}
		}else {
			for(int i=start+1;i<arr.length;i++) {
				list.add(arr[i]);
				dfs(i, list);
				//백트래킹
				list.remove(list.size()-1);
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		while(true) {
			n = sc.nextInt();
			//0이 입력되면 탐색 종료
			if(n==0) {
				break;
			}
			ArrayList<Integer> list = new ArrayList<>();
			arr = new int[n];
			//부분집합 입력
			for(int i=0;i<arr.length;i++) {
				arr[i]=sc.nextInt();
			}
			//경우의 수 탐색
			for(int i=0;i<arr.length;i++) {
				list.add(arr[i]);
				dfs(i, list);
				list.clear();
			}
			System.out.println();
		}
	}
}
