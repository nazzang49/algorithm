package solution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

class Docu {
	int idx, value;
	
	public Docu(int idx, int value) {
		this.idx=idx;
		this.value=value;
	}
}

//인쇄하고자 하는 문서의 중요도, 사용자가 요청한 문서의 위치가 주어질 때 해당 문서가 몇 번째로 출력되는지 구하기
public class Q20 {

	public static void search(ArrayList<Docu> q, int x) {
		int k=1;
		while(!q.isEmpty()) {
			boolean flag = false;
			Docu d = q.get(0);
			for(int i=1;i<q.size();i++) {
				Docu d_com = q.get(i);
				//뒤 쪽에 우선순위가 높은 것이 하나라도 있으면 제일 마지막으로 이동
				if(d.value<d_com.value) {
					flag=true;
					d = q.remove(0);
					q.add(d);
					break;
				}
			}
			//출력이면
			if(!flag) {
				Docu m = q.remove(0);
				//요청한 문서이면
				if(m.idx==x) {
					System.out.println(k);
					System.exit(0);
				}
				k++;
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		//현재 대기중인 문서의 수
		int n = sc.nextInt();
		//요청 문서의 위치(대기 중인 배열의 idx)
		int m = sc.nextInt();
		ArrayList<Docu> list = new ArrayList<>();
		
		if(1<=n&&n<=100&&0<=m&&m<=n-1) {
			for(int i=0;i<n;i++) {
				int tmp = sc.nextInt();
				//중요도 입력(1~9 / 숫자 클수록 우선 취급)
				if(1<=tmp&&tmp<=9) {
					//최초 문서 대기 idx를 함께 저장
					list.add(new Docu(i, tmp));
				}
			}
			search(list, m);
		}
	}
}
