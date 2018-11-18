package test_181103;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//크로스워드 퍼즐 쳐다보기
public class B_3005 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		int c = sc.nextInt();
		char [][] map = new char [r][c];
		ArrayList<String> str = new ArrayList<>();
		
		if(2<=r&&r<=20&&2<=c&&c<=20) {
			//가로 방향 단어
			for(int i=0;i<map.length;i++) {
				String tmp = sc.next();
				String tmp1 = "";
				int cnt = 0;
				for(int j=0;j<map[i].length;j++) {
					map[i][j]=tmp.charAt(j);
					if(map[i][j]!='#') {
						tmp1+=map[i][j];
						cnt++;
					}else {
						cnt=0;
					}
				}
				if(cnt>=2) {
					str.add(tmp1);
				}
			}
			//세로 방향 단어
			for(int i=0;i<c;i++) {
				String tmp1 = "";
				int cnt = 0;
				for(int j=0;j<r;j++) {
					if(map[j][i]!='#') {
						tmp1+=map[j][i];
						cnt++;
					}else {
						cnt=0;
					}
				}
				if(cnt>=2) {
					str.add(tmp1);
				}
			}
			String [] answer = new String[str.size()];
			for(int i=0;i<answer.length;i++) {
				answer[i]=str.get(i);
			}
			Arrays.sort(answer);
			System.out.println(answer[0]);
		}
	}
}
