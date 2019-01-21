package test_190121;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//듣지 못한 사람의 명단, 보지 못한 사람의 명단이 주어질 때 듣도 보도 못한 사람의 명단 사전 순으로 출력하기
public class B_1764 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int idx = 0;
		
		if(1<=n&&n<=500000&&1<=m&&m<=500000) {
			String [] d = new String[n];
			String [] b = new String[m];
			//각각의 명단 입력하기
			for(int i=0;i<n;i++) {
				d[i]=sc.next();
			}
			for(int i=0;i<m;i++) {
				b[i]=sc.next();
			}
			int cnt = 0;
			ArrayList<String> ans = new ArrayList<>();
			//명단 사전 순으로 정리
			Arrays.sort(b);
			Arrays.sort(d);
			for(int i=0;i<b.length;i++) {
				for(int j=idx;j<d.length;j++) {
					//듣도 보도 못한 사람의 명단이면
					if(b[i].equals(d[j])) {
						cnt++;
						ans.add(b[i]);
						idx=j+1;
						break;
					}
				}
			}
			System.out.println(cnt);
			String [] finalAns = new String[ans.size()];
			//사전 순으로 정렬
			for(int i=0;i<ans.size();i++) { 
				finalAns[i]=ans.get(i);
			}
			Arrays.sort(finalAns);
			//정답 출력
			for(int i=0;i<finalAns.length;i++) {
				System.out.println(finalAns[i]);
			}
		}
	}
}
