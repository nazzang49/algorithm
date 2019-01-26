package test_190126;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Q {
	int idx, point;
	
	public Q(int idx, int point) {
		this.idx=idx;
		this.point=point;
	}
}

//프린터기의 가장 앞에 있는 문서와 그 외 문서들의 중요도를 비교하여 출력하거나 가장 마지막 순서로 보내는 프로그램 작성하기 
public class B_1966 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		int k = 0;
		int [] ans = new int[t];
		while(k<t) {
			//문서 갯수
			int n = sc.nextInt();
			//현재 문서 위치
			int m = sc.nextInt();
			
			Queue<Q> q = new LinkedList<>();
			//문서 순서별 중요도 입력
			for(int i=0;i<n;i++) {
				q.add(new Q(i, sc.nextInt()));
			}
			
			int cnt = 0;
			while(!q.isEmpty()) {
				//가장 앞에 있는 문서 추출
				Q q1 = q.poll();
				Iterator<Q> it = q.iterator();
				boolean flag = false;
				while(it.hasNext()) {
					//뒤에 있는 문서의 중요도가 크면(현재 문서 뒤로 이동)
					if(q1.point<it.next().point) {
						flag=true;
						q.add(q1);
						break;
					}
				}
				//뒤에 있는 문서의 중요도가 같거나 작으면(현재 문서 출력)
				if(!flag) {
					cnt++;
					//답을 알고자 하는 문서이면
					if(q1.idx==m) {
						ans[k]=cnt;
						break;
					}
				}
			}
			k++;
		}
		for(int i=0;i<ans.length;i++) {
			System.out.println(ans[i]);
		}
	}
}
