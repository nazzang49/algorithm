package test_190128;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//카테고리가 중복되지 않도록 가지고 있는 패션 아이템을 조합할 수 있는 모든 경우의 수 출력하기
public class B_9375 {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		if(t<=100) {
			int k = 0;
			//테스트 케이스별 정답 출력할 배열
			int [] ans = new int[t];
			while(k<t) {
				int n = Integer.parseInt(br.readLine());
				String [] item = new String[n];
				//1개씩 입는 경우로 초기화
				ans[k]=n;
				//카테고리만 배열에 저장
				for(int i=0;i<n;i++) {
					item[i]=br.readLine().split(" ")[1];
				}
				//경우의 수 탐색 실행
				for(int i=0;i<item.length-1;i++) {
					for(int j=i+1;j<item.length;j++) {
						if(!item[i].equals(item[j])) {
							ans[k]++;
						}
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
