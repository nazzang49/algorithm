package test_190328;

import java.util.Arrays;
import java.util.Scanner;

//나무의 수 n, 필요한 나무 m미터, 각 나무의 높이가 주어질 때, m미터 이상을 가져가기 위한 절단기 높이 최댓값 구하기
public class B_2805 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		if(n<=1000000&&m<=2000000000) {
			int [] namu = new int[n];
			//나무 높이 입력
			for(int i=0;i<n;i++) {
				namu[i]=sc.nextInt();
			}
			//오름차순 정렬
			Arrays.sort(namu);
			//이분탐색
			int left = 1;
			int right = namu[namu.length-1];
			//절단기 최대 높이
			int h = 0;
			long sum = 0;
			while(left<=right) {
				h = (left+right)/2;
				sum = 0;
				for(int i=0;i<namu.length;i++) {
					//나무의 높이 > 절단기 높이 = 잘린 부분 누적
					if(namu[i]>h) sum+=(namu[i]-h);
					if(sum>m) break;
				}
				//더 많이 자른 경우 = 절단기 높이 높게
				if(sum>m) {
					left=h+1;
				}
				//더 적게 자른 경우 = 절단기 높이 낮게
				else if(sum<m) {
					right=h-1;
				}
				//딱 맞게 자른 경우
				else {
					right=h;
					break;
				}
			}
			System.out.println(right);
		}	
	}
}
