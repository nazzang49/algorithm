package test_190219;

import java.util.ArrayList;
import java.util.Scanner;

//난장이들의 수 n, 그들이 쓰고 있는 모자의 색 정보가 정수로 주어질 때, 각 테스트 케이스별로 예쁜 사진인지 판별하는 프로그램 작성하기
public class B_2912 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int c = sc.nextInt();
		
		if(n<=300000&&c<=10000) {
			//난장이 수(1번~)
			int [] nanjang = new int[n+1];
			
			//정보 입력
			for(int i=1;i<=n;i++) {
				nanjang[i]=sc.nextInt();
			}
			
			ArrayList<String> ans = new ArrayList<>();
			int k = sc.nextInt();
			while(k!=0) {
				//색상이 다른 모자의 수(1번~)
				int [] cap = new int[c+1];
				int start = sc.nextInt();
				int end = sc.nextInt();
				int half = (end-start+1)/2+1;
				
				boolean flag = false;
				for(int i=start;i<=end;i++) {
					cap[nanjang[i]]++;
					if(cap[nanjang[i]]>=half) {
						flag = true;
						ans.add("yes "+nanjang[i]);
						break;
					}
				}
				if(!flag) {
					ans.add("no");
				}
				k--;
			}
			//정답 출력
			for(int i=0;i<ans.size();i++) {
				System.out.println(ans.get(i));
			}
		}	
	}
}
