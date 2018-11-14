package test_181106;

import java.util.Scanner;

//피터팬 프레임
public class B_3054 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String n = sc.next();
		String [] line1 = new String [1000];
		String [] line2 = new String [1000];
		String [] line3 = new String [1000];
		String [] line4 = new String [1000];
		String [] line5 = new String [1000];
		
		if(1<=n.length()&&n.length()<=15) {
			n=' '+n;
			for(int i=1;i<n.length();i++) {
				//피터팬 프레임
				if(i%3!=0) {
					line1[i]="..#.";
					line2[i]=".#.#";
					line3[i]="#."+n.charAt(i)+".";
					line4[i]=".#.#";
					line5[i]="..#.";
				}
				//웬디 프레임
				else {
					line1[i]="..*.";
					line2[i]=".*.*";
					line3[i]="*."+n.charAt(i)+".";
					line4[i]=".*.*";
					line5[i]="..*.";
				}
				//마지막 문자인 경우
				if(i==n.length()-1) {
					//마지막 문자가 피터팬 프레임이면
					if(i%3!=0) {
						line1[i]+=".";
						line2[i]+=".";
						line3[i]+="#";
						line4[i]+=".";
						line5[i]+=".";
					}
					//마지막 문자가 웬디 프레임이면
					else {
						line1[i]+=".";
						line2[i]+=".";
						line3[i]+="*";
						line4[i]+=".";
						line5[i]+=".";
					}
				}
			}
			for(int i=1;i<n.length();i++) {
				System.out.print(line1[i]);
			}
			System.out.println();
			for(int i=1;i<n.length();i++) {
				System.out.print(line2[i]);
			}
			System.out.println();
			for(int i=1;i<n.length();i++) {
				System.out.print(line3[i]);
			}
			System.out.println();
			for(int i=1;i<n.length();i++) {
				System.out.print(line4[i]);
			}
			System.out.println();
			for(int i=1;i<n.length();i++) {
				System.out.print(line5[i]);
			}
			System.out.println();
		}
	}
}
