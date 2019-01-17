package test_190117;

import java.util.Scanner;

//9개의 카약이 결승선에서 얼마나 떨어져 있는지 문자로 주어질 때, 각 팀의 등수 출력하기
public class B_2890 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		//1번부터 9번까지의 카약이 결승선에 얼마나 가까운지를 저장할 배열
		int [] kayak = new int[10];
		int [] ans = new int[10];
		int max = 0;
	
		if(1<=n&&n<=50&&1<=m&&m<=50) {
			//현재 카약들의 위치 입력
			for(int i=0;i<n;i++) {
				String str = sc.next();
				//왼쪽부터 .의 갯수(많을수록 결승선에 가까운 것=등수 높음)
				int cnt = 0;
				for(int j=1;j<str.length();j++) {
					if(str.charAt(j)=='.') {
						cnt++;
					}
					//숫자가 등장하면(카약의 번호=출력 인덱스)
					else {
						if(str.charAt(j)=='F') {
							break;
						}
						kayak[str.charAt(j)-'0']=cnt;
						if(max<=cnt) {
							max=cnt;
						}
						break;
					}
				}
			}
			int rank = 1;
			//가장 결승선에 가까운 카약부터 등수부여(동일 순위 부여 가능)
			for(int i=max;i>=0;i--) {
				for(int j=1;j<kayak.length;j++) {
					if(kayak[j]==i) {
						ans[j]=rank;
					}
				}
				rank++;
			}
			//정답 출력
			for(int i=1;i<ans.length;i++) {
				System.out.println(ans[i]);
			}
		}
	}
}
