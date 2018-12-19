package solution;

//5천만 미만의 수 중 소수의 제곱 + 소수의 3승 + 소수의 4승으로 표현할 수 있는 모든 숫자의 개수 구하기
public class Q60 {

	static int cnt = 0;
	
	//소수인지 판별하는 메소드
	public static boolean check(int n) {
		boolean flag = false;
		for(int i=2;i<=n/2;i++) {
			if(n%i==0) {
				flag = true;
				break;
			}
		}
		//소수이면
		if(!flag) {
			return true;
		}
		return false;
	}
	
	public static void dfs(int [] sosoo, int count) {
		if(count<3) {
			long sum = 0;
			for(int i=0;i<count;i++) {
				sum+=Math.pow(sosoo[i], i+2);
			}
			//합계가 5천만 이하일 때만 dfs 진행
			if(!(sum>=50000000)) {
				count++;
				boolean flag = false;
				for(int i=2;i<=1000;i++) {
					flag = check(i);
					if(flag) {
						sosoo[count-1]=i;
						dfs(sosoo, count);
					}
				}
			}
		}else if(count==3) {
			long sum = 0;
			for(int i=0;i<count;i++) {
				sum+=Math.pow(sosoo[i], i+2);
			}
			if(sum<50000000) {
				cnt++;
			}
		}
	}
	
	public static void main(String[] args) {

		int [] sosoo = new int[3];
		boolean flag = false;
		
		for(int i=2;i<10000;i++) {
			flag = check(i);
			//소수이면
			if(flag) {
				sosoo[0]=i;
				dfs(sosoo,1);
			}
		}
		System.out.println(cnt);
	}
}
