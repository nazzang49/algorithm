package test_190125;

import java.util.Scanner;

//길이가 같은 두 단어가 주어질 때, 각 단어에 포함된 모든 글자의 알파벳 거리 구하기
public class B_5218 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		//최대 테스트 케이스 갯수 = 100
		if(n<100) {
			int k = 0;
			String [] ans = new String[n];
			while(k<n) {
				//정답 배열 초기화
				ans[k]="Distances: ";
				String A = sc.next();
				String B = sc.next();
				
				for(int i=0;i<A.length();i++) {
					if(A.charAt(i)<=B.charAt(i)) {
						ans[k]+=Math.abs(A.charAt(i)-B.charAt(i))+" ";	
					}else {
						ans[k]+=B.charAt(i)-A.charAt(i)+26+" ";
					}
				}
				
				k++;
			}
			for(int i=0;i<ans.length;i++) {
				System.out.println(ans[i]);
			}
		}	
	}
}
