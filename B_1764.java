package test;

import java.util.ArrayList;
import java.util.Scanner;

//듣도 못한 사람과 보도 못한 사람의 명단이 주어졌을 때 듣도 보도 못한 사람의 명단을 출력
public class B_1764 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		String [] n_arr = new String[n];
		String [] m_arr = new String[m];
		ArrayList<String> answer = new ArrayList<>();
		
		if(1<=n&&n<=500000&&1<=m&&m<=500000) {
			for(int i=0;i<n_arr.length;i++) {
				n_arr[i]=sc.next();
			}
			for(int i=0;i<m_arr.length;i++) {
				m_arr[i]=sc.next();
			}
			for(int i=0;i<n_arr.length;i++) {
				for(int j=0;j<m_arr.length;j++) {
					if(n_arr[i].equals(m_arr[j])) {
						answer.add(n_arr[i]);
					}
				}
			}

			System.out.println(answer.size());

			for(int i=0;i<answer.size();i++) {
				System.out.println(answer.get(i));
			}
		}
	}
}
