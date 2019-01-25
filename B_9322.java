package test_190125;

import java.util.HashMap;
import java.util.Scanner;

//평문과 암호문 예시가 주어질 때, 규칙을 찾아내어 입력된 암호문의 평문 찾는 프로그램 작성하기
public class B_9322 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		//최대 테스트 케이스 갯수 = 100
		if(t<=100) {
			int k = 0;
			String [] ans = new String[t];
			while(k<t) {
				ans[k]="";
				//입력되는 단어의 갯수
				int n = sc.nextInt();
				
				//암호문의 각 문자가 평문에서 어디에 위치하는지 인덱스 저장할 배열
				HashMap<Integer, Integer> map = new HashMap<>();
				
				//두 개의 문자열 배열 입력
				String [] str1 = new String[n];
				String [] str2 = new String[n];
				
				for(int i=0;i<n;i++) {
					str1[i]=sc.next();
				}
				for(int i=0;i<n;i++) {
					str2[i]=sc.next();
				}
				
				boolean [] visited = new boolean[n];
				for(int i=0;i<n;i++) {
					for(int j=0;j<n;j++) {
						if(!visited[j]&&str1[i].equals(str2[j])) {
							visited[j]=true;
							map.put(i, j);
							break;
						}
					}
				}
				
				//암호문 입력
				for(int i=0;i<n;i++) {
					str1[i]=sc.next();
				}
				//암호문 해석
				for(int i=0;i<n;i++) {
					ans[k]+=str1[map.get(i)]+" ";
				}
				k++;
			}
			for(int i=0;i<ans.length;i++) {
				System.out.println(ans[i]);
			}
		}
	}
}
