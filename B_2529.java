package test_190212;

import java.util.Scanner;

//< 와 > 두 가지 기호가 k개 임의 순섣대로 주어질 때, 해당 순서를 만족하는 0~9까지의 숫자를 차례대로 골라 형성할 수 있는 k+1자리 문자열 중 최대값과 최소값 출력하기
public class B_2529 {
	
	static int k;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	//이미 사용한 숫자인지 확인할 배열
	static boolean [] v;
	//부호 순서대로 담을 배열
	static String [] op;
	static String maxStr = "";
	static String minStr = "";
	
	//DFS + 백트래킹
	public static void dfs(int now, int count, String str) {
		if(count+1==k) {
			int strInt = Integer.parseInt(str);
			//최대값과 최소값 갱신
			if(max<strInt) {
				max = strInt;
				maxStr=str;
			}
			if(min>strInt) {
				min = strInt;
				minStr=str;
			}
			return;
		}
		count++;
		String tmp = str;
		for(int i=0;i<=9;i++) {
			//아직 사용하지 않은 숫자이고, 부등호 규칙 만족하는 경우
			if(!v[i]) {
				if(op[count].equals(">")&&now>i) {
					v[i]=true;
					tmp+=String.valueOf(i);
					dfs(i,count,tmp);
					//백트래킹
					tmp=str;
					v[i]=false;
				}else if(op[count].equals("<")&&now<i) {
					v[i]=true;
					tmp+=String.valueOf(i);
					dfs(i,count,tmp);
					//백트래킹
					tmp=str;
					v[i]=false;
				}
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		k = sc.nextInt();
		
		if(k<=9) {
			//0~9까지 숫자 사용 가능
			v = new boolean[10];
			//부호 입력
			op = new String[k];
			for(int i=0;i<k;i++) {
				op[i]=sc.next();
			}
			//DFS 탐색 실행
			for(int i=0;i<=9;i++) {
				v[i]=true;
				dfs(i,-1,String.valueOf(i));
				v[i]=false;
			}
			//정답 출력(문자열로)
			System.out.println(maxStr);
			System.out.println(minStr);
		}
	}
}
