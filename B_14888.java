package test_190326;

import java.util.Scanner;

//수열과 사용할 수 있는 연산자 갯수가 주어질 때, 적절히 조합하여 만들 수 있는 최소값 and 최대값 출력하기
public class B_14888 {

	static int n;
	static int [] arr;
	//사용할 수 있는 연산자 갯수(덧,뺄,곱,나)
	static int [] op;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	
	public static void dfs(int num, int idx, int chance) {
		//모든 부호 다 사용한 경우(최소값, 최대값 갱신)
		if(chance==0) {
			min=Math.min(min, num);
			max=Math.max(max, num);
			return;
		}
		for(int i=0;i<4;i++) {
			//사용할 수 있는 연산자이면
			if(op[i]!=0) {
				op[i]--;
				//덧셈
				if(i==0) {
					num+=arr[idx];
					dfs(num,idx+1,chance-1);
					num-=arr[idx];
				}
				//뺄셈
				else if(i==1) {
					num-=arr[idx];
					dfs(num,idx+1,chance-1);
					num+=arr[idx];
				}
				//곱셈
				else if(i==2) {
					int tmp = num;
					num*=arr[idx];
					dfs(num,idx+1,chance-1);
					num=tmp;
				}
				//나눗셈
				else {
					//나누고자 하는 수가 음수이면(양수로 바꾼 뒤 연산 후 다시 음수로 변경)
					if(num<0) {
						int tmp = num;
						num*=-1;
						num/=arr[idx];
						dfs(num*-1,idx+1,chance-1);
						num=tmp;
					}else {
						int tmp = num;
						num/=arr[idx];
						dfs(num,idx+1,chance-1);
						num=tmp;
					}
				}
				op[i]++;
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		if(n<=11) {
			arr = new int[n];
			op = new int[4];
			//정수 입력
			for(int i=0;i<n;i++) {
				arr[i]=sc.nextInt();
			}
			//연산자 갯수 입력
			for(int i=0;i<4;i++) {
				op[i]=sc.nextInt();
			}
			//DFS 탐색
			for(int i=0;i<4;i++) {
				//사용할 수 있는 연산자이면
				if(op[i]!=0) {
					op[i]--;
					//덧셈
					if(i==0) {
						dfs(arr[0]+arr[1],2,n-2);
					}
					//뺄셈
					else if(i==1) {
						dfs(arr[0]-arr[1],2,n-2);
					}
					//곱셈
					else if(i==2) {
						dfs(arr[0]*arr[1],2,n-2);
					}
					//나눗셈
					else {
						//나누고자 하는 수가 음수이면(양수로 바꾼 뒤 연산 후 다시 음수로 변경)
						if(arr[0]<0) {
							int tmp = -arr[0];
							tmp/=arr[1];
							dfs(tmp*-1,2,n-2);
						}else {
							dfs(arr[0]/arr[1],2,n-2);
						}
					}
					op[i]++;
				}
			}
			System.out.println(min);
			System.out.println(max);
		}
	}
}
