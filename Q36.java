package solution;

import java.util.Scanner;

//각 문자열의 인덱스 n번째 글자를 기준으로 오름차순 정렬하기
public class Q36 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		if(1<=n&&n<=50) {
			String [] str = new String[n];
			//입력
			for(int i=0;i<str.length;i++) {
				String tmp = sc.next();
				if(1<=tmp.length()&&tmp.length()<=100) {
					str[i]=tmp;
				}
			}
			//탐색
			for(int i=0;i<str.length-1;i++) {
				for(int j=i+1;j<str.length;j++) {
					if(str[i].charAt(k)>str[j].charAt(k)) {
						String tmp = str[i];
						str[i]=str[j];
						str[j]=tmp;
					}else if(str[i].charAt(k)==str[j].charAt(k)) {
						int m = 0;
						while(m<str[i].length()||m<str[j].length()) {
							//비교하고자 하는 위치의 문자가 같으면 가장 앞에서부터 차례대로 비교하며 순서 결정
							if(str[i].charAt(m)>str[j].charAt(m)) {
								String tmp = str[i];
								str[i]=str[j];
								str[j]=tmp;
								break;
							}
							m++;
						}
					}
				}
			}
			//결과 출력
			for(int i=0;i<str.length;i++) {
				System.out.println(str[i]);
			}
		}
	}
}
