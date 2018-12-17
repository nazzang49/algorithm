package solution;

import java.util.Scanner;

//끝말잇기를 하는 사람의 수, 인원별 언급한 단어의 배열이 주어질 때 가장 먼저 탈락하는 사람과 몇번째 차례에서 탈락하는지 구하기
public class Q50 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		//참여하는 인원
		int n = sc.nextInt();
		//단어 배열의 길이
		int k = sc.nextInt();
		//몇 번째 차례에 탈락하는지 확인
		int num = 0;
		//제일 먼저 탈락하는 사람의 idx
		int person = Integer.MAX_VALUE;
		int idx = Integer.MAX_VALUE;
		int tmp = 0;
		
		if(2<=n&&n<=10&&n<=k&&k<=100) {
			String [] words = new String[k+1];
			for(int i=1;i<words.length;i++) {
				String str = sc.next();
				if(2<=str.length()&&str.length()<=50) {
					words[i]=str;
				}
			}
			for(int i=1;i<words.length-1;i++) {
				//다시 1번에게 돌아오는 순간(차례+1)
				if(i%n==1) {
					num++;
				}
				for(int j=i+1;j<words.length;j++) {
					if(words[i].equals(words[j])) {
						tmp=j;
						break;
					}
				}
				//더 빨리 탈락하는 사람인 경우 답 변경
				if(person>=tmp&&tmp!=0) {
					person=tmp;
					idx=person%n;
					if(idx==0) {
						idx=n;
					}
				}
				tmp = 0;
			}
			if(idx==Integer.MAX_VALUE) num=0;
			System.out.println("idx : "+idx+", "+"num : "+num);
		}
	}
}
