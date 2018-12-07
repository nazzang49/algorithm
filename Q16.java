package solution;

import java.util.Scanner;

//바로 앞 번호 혹은 뒷 번호의 학생에게만 체육복을 빌려줄 수 있을 때, 전체 학생 중 체육 수업을 들을 수 있는 학생 수 구하기
public class Q16 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		//전체 학생 수
		int n = sc.nextInt();
		//체육복 없는 학생 수
		int k = sc.nextInt();
		//체육복 여벌 있는 학생 수
		int m = sc.nextInt();
		
		if(2<=n&&n<=30&&2<=k&&k<=n&&1<=m&&m<=n) {
			int [] chk = new int[n+1];
			for(int i=1;i<=k;i++) {
				//체육복 없는
				chk[sc.nextInt()]=1;
			}
			for(int i=1;i<=m;i++) {
				//여벌 있는
				chk[sc.nextInt()]=2;
			}
			for(int i=1;i<chk.length;i++) {
				if(i==1) {
					if(chk[i]==2&&chk[i+1]==1) {
						chk[i+1]=0;
					}
				}else if(i==chk.length-1) {
					if(chk[i]==2&&chk[i-1]==1) {
						chk[i-1]=0;
					}
				}else {
					if(chk[i]==2&&chk[i-1]==1) {
						chk[i-1]=0;
					}else if(chk[i]==2&&chk[i+1]==1) {
						chk[i+1]=0;
					}
				}
			}
			int sum = 0;
			for(int i=1;i<chk.length;i++) {
				if(chk[i]==0||chk[i]==2) {
					sum++;
				}
			}
			System.out.println(sum);
		}
	}
}
