package solution;

import java.util.ArrayList;
import java.util.Scanner;

//조각난 종이에 각각 적힌 0-9까지의 숫자들을 보고 조합하여 만들 수 있는 소수 출력하기
public class Q35 {

	//총 소수 개수
	static int cnt = 0;
	//중복 판별할 배열
	static ArrayList<Integer> list = new ArrayList<>();
	//방문여부
	static boolean [] visited;
	static String str;
	
	//소수인지 판별하는 메소드
	public static void sosoo(int n) {
		boolean flag = false;
		if(n>=2) {
			for(int i=2;i<=n/2;i++) {
				if(n%i==0) {
					flag=true;
					break;
				}
			}
			//소수이면
			if(!flag) {
				for(int i=0;i<list.size();i++) {
					//이미 확인된 소수이면
					if(list.get(i)==n) {
						flag=true;
						break;
					}
				}
				if(!flag) {
					System.out.println(n);
					cnt++;
					list.add(n);
				}
			}
		}
	}
	
	public static void dfs(String tmp) {
		if(!(str.length()==tmp.length())) {
			for(int i=0;i<str.length();i++) {
				if(!visited[i]) {
					visited[i]=true;
					tmp+=str.charAt(i);
					int num = Integer.parseInt(tmp);
					sosoo(num);
					dfs(tmp);
					visited[i]=false;
				}
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		str = sc.next();
		
		if(1<=str.length()&&str.length()<=7) {
			visited = new boolean[str.length()];
			//011은 11과 같은 것으로 취급
			for(int i=0;i<str.length();i++) {
				String tmp = "";
				if(!visited[i]) {
					visited[i]=true;
					tmp+=str.charAt(i);
					int num = Integer.parseInt(tmp);
					sosoo(num);
					dfs(tmp);
					visited[i]=false;
				}
			}
			System.out.println(cnt);
		}
	}
}
