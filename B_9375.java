package test_181203;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//해빈이가 입을 수 있는 패션 아이템의 종류가 주어질 때 알몸이 아닌 상태로 돌아다닐 수 있는 일수 구하기
public class B_9375 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int n = 0;
		int [] answer = new int[t];
		//조합 가능한 경우의 수
		int cnt = 0;
		
		if(0<=t&&t<=30) {
			int k=0;
			while(k<t) {
				n=sc.nextInt();
				//최소 주어지는 아이템의 개수만큼 착용 가능
				cnt=n;
				String [] cate = new String[n];
				//중복되는 아이템 종류의 개수 저장
				ArrayList<Integer> list = new ArrayList<>();
				for(int i=0;i<n*2;i++) {
					String str = sc.next();
					if(i%2==1) {
						cate[i/2]=str;
					}
				}
				Arrays.sort(cate);
				
				int tmp = 1;
				boolean flag = false;
				for(int i=0;i<cate.length-1;i++) {
					//아이템 종류가 달라지는 순간 중복 개수 저장
					if(!cate[i].equals(cate[i+1])) {
						list.add(tmp);
						tmp=1;
						flag=true;
					}else {
						tmp++;
					}
				}
				//모두 같은 종류가 아닌 경우 마지막 종류의 중복 개수 저장
				if(flag) {
					list.add(tmp);
				}
				//변수 재활용
				tmp=1;
				for(int i=0;i<list.size();i++) {
					tmp*=list.get(i);
				}
				if(flag) {
					answer[k]=cnt+tmp;	
				}else {
					answer[k]=cnt;
				}
				//횟수 초기화
				cnt=0;
				list.clear();
				k++;
			}
			for(int i=0;i<answer.length;i++) {
				System.out.println(answer[i]);
			}
		}
	}
}
