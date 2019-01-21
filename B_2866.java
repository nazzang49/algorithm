package test_190121;

import java.util.ArrayList;
import java.util.Scanner;

//문자열이 2차원 배열로 주어질 때, 각 열별로 0행~마지막 행까지 내려오며 문자를 이어 생성된 단어들이 서로 중복되지 않으면 카운트 값 +1 증가시키기 
public class B_2866 {

	public static boolean result(ArrayList<String> list) {
		for(int i=0;i<list.size()-1;i++) {
			for(int j=i+1;j<list.size();j++) {
				//형성된 단어가 중복되는 경우
				if(list.get(i).equals(list.get(j))) {
					return false;
				}
			}
		}
		return true;
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		int c=  sc.nextInt();
		int cnt = 0;
		
		if(2<=r&&r<=1000&&2<=c&&c<=1000) {
			String [] words = new String[r];
			//단어 입력
			for(int i=0;i<r;i++) {
				words[i]=sc.next();
			}
			ArrayList<String> list = new ArrayList<>();
			//탐색 실행
			for(int i=1;i<words.length;i++) {
				int idx = 0;
				while(idx<c) {
					String tmp = "";
					int count = i;
					while(count<words.length) {
						tmp+=words[count].charAt(idx);
						count++;
					}
					//형성된 단어 저장
					list.add(tmp);
					//다음 열로 이동
					idx++;
				}
				//중복되지 않는 경우
				if(result(list)) {
					cnt++;
				}
				list.clear();
			}
			System.out.println(cnt);
		}
	}
}
