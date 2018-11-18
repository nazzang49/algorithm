package test;

import java.util.Scanner;

//HP, MP, 공격력, 방어력을 합친 최종 전투력 출력
public class B_12790 {

	public static int attack(int n1, int n2, int n3, int n4) {
		return n1+5*n2+2*n3+2*n4;
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] answer = new int[n];
		
		if(1<=n&&n<=1000) {
			for(int k=0;k<n;k++) {
				int [] ch = new int[8];
				for(int i=0;i<8;i++) {
					ch[i]=sc.nextInt();
				}
				int tmp1 = ch[0]+ch[4];
				int tmp2 = ch[1]+ch[5];
				int tmp3 = ch[2]+ch[6];
				int tmp4 = ch[3]+ch[7];
				
				if(tmp1<1) {
					tmp1 = 1;
				}
				if(tmp2<1) {
					tmp2 = 1;
				}
				if(tmp3<0) {
					tmp3 = 0;
				}
				answer[k]=attack(tmp1,tmp2,tmp3,tmp4);
			}
		}
		
		for(int i=0;i<answer.length;i++) {
			System.out.println(answer[i]);
		}
	}
}
