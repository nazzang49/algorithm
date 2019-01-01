package solution;

import java.util.Scanner;

//어떤 가게에서의 햄버거, 음료, 사이드 메뉴, 디저트 선택 유무에 따라 얻게되는 총 칼로리 출력하기
public class Q113 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int [] burger = new int[4];
		int [] drink = new int[4];
		int [] side = new int[4];
		int [] dessert = new int[4];
		
		//각 메뉴의 칼로리 입력
		for(int i=0;i<4;i++) {
			burger[i]=sc.nextInt();
		}
		for(int i=0;i<4;i++) {
			drink[i]=sc.nextInt();
		}
		for(int i=0;i<4;i++) {
			side[i]=sc.nextInt();
		}
		for(int i=0;i<4;i++) {
			dessert[i]=sc.nextInt();
		}
		
		int sum = 0;
		sum+=burger[sc.nextInt()];
		sum+=drink[sc.nextInt()];
		sum+=side[sc.nextInt()];
		sum+=dessert[sc.nextInt()];
		
		System.out.println("Your total Calroie count is "+sum);
		
	}
}
