package solution;

import java.util.ArrayList;

//3797 소수와 같이 오른쪽에서 숫자를 하나씩 지우거나 왼쪽에서 숫자를 하나씩 지워나갈 때 그 수가 모두 소수인 경우 구하기(총 11개)
public class Q57 {

	//소수인지 판별하는 메소드
	public static boolean sosoo(long n) {
		if(n==1) {
			return false;
		}else {
			boolean flag = false;
			for(long i=2;i<=n/2;i++) {
				if(n%i==0) {
					flag=true;
					break;
				}
			}
			if(!flag) {
				return true;
			}
			return false;	
		}
	}

	//왼쪽부터 지워나가는
	public static boolean left(String left) {
		long tmp = 0;
		String str = "";
		boolean flag = false;
		for(int i=left.length()-1;i>=0;i--) {
			str=left.charAt(i)+str;
			tmp = Integer.parseInt(str);
			flag = sosoo(tmp);
			if(!flag) {
				return false;
			}
		}
		return true;
	}
	
	//오른쪽부터 지워나가는
	public static boolean right(String right) {
		long tmp = 0;
		String str = "";
		boolean flag = false;
		for(int i=0;i<right.length();i++) {
			str+=right.charAt(i);
			tmp = Integer.parseInt(str);
			flag = sosoo(tmp);
			if(!flag) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {

		ArrayList<Long> answer = new ArrayList<>();
		
		long k = 10;
		while(true) {
			boolean flag = false;
			for(long i=2;i<=k/2;i++) {
				if(k%i==0) {
					flag=true;
					break;
				}
			}
			//소수이면 탐색 실행
			if(!flag) {
				String str = String.valueOf(k);
				boolean flag_left = left(str);
				boolean flag_right = right(str);
				if(flag_left&&flag_right) {
					answer.add(k);
				}
			}
			if(answer.size()==10) {
				break;
			}
			k++;
		}
		//답 출력하기
		for(int i=0;i<answer.size();i++) {
			System.out.println(answer.get(i));
		}
	}
}
