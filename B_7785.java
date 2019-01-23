package test_190123;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

//로그에 기록된 출입 기록의 수 n개가 주어질 때, 현재 회사에 남아 있는 인원을 사전 순으로 출력하기
public class B_7785 {

	public static boolean result(String str1, String str2) {
		int len = Math.min(str1.length(), str2.length());
		for(int i=0;i<len;i++) {
			//앞쪽에 있는 사원명이 사전 순으로 더 앞에 있다면 
			if(str1.charAt(i)<str2.charAt(i)) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		if(2<=n&&n<=Math.pow(10, 6)) {
			//로그 기록에 따라 남아 있는 명단 저장할 가변 배열
			ArrayList<String> list = new ArrayList<>();
			for(int i=0;i<n;i++) {
				//총 n개의 로그 기록 입력
				String [] str = br.readLine().split(" ");
				if(str[1].equals("enter")) {
					list.add(str[0]);
				}else {
					//명단에 있는 사람과 이름 비교
					for(int j=0;j<list.size();j++) {
						if(list.get(j).equals(str[0])) {
							list.remove(j);
							break;
						}
					}
				}
			}
			//사전 순으로 이름 재배열
			for(int i=0;i<list.size()-1;i++) {
				for(int j=i+1;j<list.size();j++) {
					if(result(list.get(i),list.get(j))) {
						String tmp = list.get(i);
						list.set(i, list.get(j));
						list.set(j, tmp);
					}
				}
			}
			//정답 출력
			for(int i=0;i<list.size();i++) {
				System.out.println(list.get(i));
			}
		}
	}
}
