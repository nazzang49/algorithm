package test_190117;

import java.util.Scanner;

//오민식이 여러명의 여자 중 사랑하는 여자를 선택하기 위해 l,o,v,e가 이름에 등장하는 횟수를 활용하여 규칙에 따라 점수를 부여할 시 최종 선택하게 되는 여성의 이름 출력하기
public class B_1296 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		//호스트는 오민식
		String host = "OHMINSIK";
		//가장 높은 점수 갱신
		int max = 0;
		//정답으로 출력할 이름
		String ans = "";
		
		if(1<=n&&n<=50) {
			for(int i=0;i<n;i++) {
				//이름 입력
				String str = sc.next();
				int l = 0;
				int o = 0;
				int v = 0;
				int e = 0;
				//오민식의 이름에 있는 love 알파벳 갯수 추출
				for(int j=0;j<host.length();j++) {
					if(host.charAt(j)=='L') {
						l++;
					}else if(host.charAt(j)=='O') {
						o++;
					}else if(host.charAt(j)=='V') {
						v++;
					}else if(host.charAt(j)=='E') {
						e++;
					}
				}
				//새로 입력된 여성분의 이름에 있는 love 알파벳 갯수 추출
				for(int j=0;j<str.length();j++) {
					if(str.charAt(j)=='L') {
						l++;
					}else if(str.charAt(j)=='O') {
						o++;
					}else if(str.charAt(j)=='V') {
						v++;
					}else if(str.charAt(j)=='E') {
						e++;
					}
				}
				//이름이 입력될 때마다 해당 여성과의 점수 비교
				int sum = ((l+o)*(l+v)*(l+e)*(o+v)*(o+e)*(v+e))%100;
				if(max<=sum) {
					if(max==sum&&ans.length()!=0) {
						//같을 때는 알파벳 순서 비교
						if(ans.length()<=str.length()) {
							for(int j=0;j<ans.length();j++) {
								//같은 위치에서 알파벳 순서가 빠르면
								if(ans.charAt(j)>str.charAt(j)) {
									ans = str;
									break;
								}else if(ans.charAt(j)<str.charAt(j)) {
									break;
								}
							}
						}
					}else {
						max = sum;
						ans = str;
					}
				}
			}
			System.out.println(ans);
		}
	}
}
