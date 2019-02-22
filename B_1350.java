package test_190201;

import java.util.Scanner;

//파일의 사이즈, 클러스터 용량이 주어질 때, 실제 사용한 클러스터 용량 출력하기
public class B_1350 {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		//파일의 최대 갯수 = 1000
		if(n<=1000) {
			int [] file = new int[n];
			//파일 용량 입력
			for(int i=0;i<file.length;i++) {
				file[i]=sc.nextInt();
			}
			//클러스터 용량 입력
			int k = sc.nextInt();
			long size = 0;
			//탐색 실행
			for(int i=0;i<n;i++) {
				if(file[i]%k==0) size+=file[i];
				else size+=(file[i]/k+1)*k;
			}
			System.out.println(size);
		}
	}
}
