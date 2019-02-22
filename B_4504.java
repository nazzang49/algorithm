package test_181109;

import java.util.ArrayList;
import java.util.Scanner;

//입력값과 자연수 목록이 주어졌을 때, 입력값의 배수 찾기
public class B_4504 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Integer> tmpList = new ArrayList<>();
		ArrayList<String> wordsList = new ArrayList<>();
		
		if(0<n&&n<1000) {
			while(true) {
				int tmp = sc.nextInt();
				if(tmp==0) {
					for(int i=0;i<tmpList.size();i++) {
						System.out.println(tmpList.get(i)+wordsList.get(i));
					}
					System.exit(0);
				}
				if(tmp%n==0) {
					tmpList.add(tmp);
					wordsList.add(" is a multiple of "+n);
				}else {
					tmpList.add(tmp);
					wordsList.add(" is NOT a multiple of "+n);
				}
			}
		}
	}
}
