package test_190228;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

//친구 관계가 주어질 때, 입력으로 주어지는 두 사람의 친구 네트워크 인원 수 출력하기
public class B_4195 {

	static int n;
	static HashMap<String, Integer> parent;
	static int [] depth = new int[100001];
	static int [] d = new int[100001];
	static ArrayList<Integer> ans = new ArrayList<>();
	
	public static int getParent(int s) {
		if(d[s]==s) return s;
		else return getParent(d[s]);
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		if(t<=1000) {
			while(t!=0) {
				n = sc.nextInt();
				parent = new HashMap<>();
				Arrays.fill(depth, 1);
				//부모 배열 초기화
				for(int i=1;i<d.length;i++) {
					d[i]=i;
				}
				//새로 등장할 때마다 인원수 증가
				int person = 1;
				//친구 관계 입력
				for(int i=1;i<=n;i++) {
					String s1 = sc.next();
					String s2 = sc.next();
					//이미 입력된 키값이 아닌 경우에만 신규 입력
					if(!parent.containsKey(s1)) {
						parent.put(s1, person++);
					}
					if(!parent.containsKey(s2)) {
						parent.put(s2, person++);
					}
					int idx1 = getParent(parent.get(s1));
					int idx2 = getParent(parent.get(s2));
					//부모 같지 않으면(=합치기)
					if(idx1!=idx2) {
						d[idx2]=idx1;
						depth[idx1]+=depth[idx2];
						ans.add(depth[idx1]);
					}
				}
				t--;
			}
			//정답 출력
			for(int i=0;i<ans.size();i++) {
				System.out.println(ans.get(i));
			}
		}	
	}
}
