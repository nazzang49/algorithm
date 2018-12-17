package solution;

import java.util.ArrayList;
import java.util.Scanner;

//조건 성립하는 세변 저장하기 위해 필요한 클래스
class Set {
	int x, y, z;
	
	public Set(int x, int y, int z) {
		this.x=x;
		this.y=y;
		this.z=z;
	}
}

//사용자가 철사의 길이를 입력할 때, 해당 철사를 잘라 만들 수 있는 직각 삼각형 변의 길이 출력하기(여러 개일 경우 모두)
public class Q54 {

	static ArrayList<Set> list = new ArrayList<>();
	static int n;
	
	public static void dfs(int start, int [] arr, int cnt) {
		//세 변의 길이 골랐으면 직각 삼각형 여부 확인
		if(cnt==arr.length-1) {
			arr[2]=n-arr[0]-arr[1];
			//첫번째와 두번째 변 제곱의 합 = 세번째 변의 제곱(직각 삼각형 성립)
			if(Math.pow(arr[0], 2)+Math.pow(arr[1], 2)==Math.pow(arr[2], 2)) {
				list.add(new Set(arr[0], arr[1], arr[2]));
			}
		}else{
			cnt++;
			for(int i=start+1;i<n/2;i++) {
				arr[cnt-1]=i;
				dfs(i,arr,cnt);
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int [] arr = new int[3];
		
		if(1<=n&&n<=100000) {
			for(int i=1;i<n/2;i++) {
				arr[0]=i;
				dfs(i,arr,1);
			}
			//가능한 경우가 없으면
			if(list.size()==0) {
				System.out.println("가능한 경우가 없습니다.");
			}else {
				for(int i=0;i<list.size();i++) {
					Set s = list.get(i);
					System.out.println(s.x);
					System.out.println(s.y);
					System.out.println(s.z);
				}
			}
		}
	}
}
