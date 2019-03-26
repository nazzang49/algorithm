package test_190326;

import java.util.Scanner;

//������ ����� �� �ִ� ������ ������ �־��� ��, ������ �����Ͽ� ���� �� �ִ� �ּҰ� and �ִ밪 ����ϱ�
public class B_14888 {

	static int n;
	static int [] arr;
	//����� �� �ִ� ������ ����(��,��,��,��)
	static int [] op;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	
	public static void dfs(int num, int idx, int chance) {
		//��� ��ȣ �� ����� ���(�ּҰ�, �ִ밪 ����)
		if(chance==0) {
			min=Math.min(min, num);
			max=Math.max(max, num);
			return;
		}
		for(int i=0;i<4;i++) {
			//����� �� �ִ� �������̸�
			if(op[i]!=0) {
				op[i]--;
				//����
				if(i==0) {
					num+=arr[idx];
					dfs(num,idx+1,chance-1);
					num-=arr[idx];
				}
				//����
				else if(i==1) {
					num-=arr[idx];
					dfs(num,idx+1,chance-1);
					num+=arr[idx];
				}
				//����
				else if(i==2) {
					int tmp = num;
					num*=arr[idx];
					dfs(num,idx+1,chance-1);
					num=tmp;
				}
				//������
				else {
					//�������� �ϴ� ���� �����̸�(����� �ٲ� �� ���� �� �ٽ� ������ ����)
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
			//���� �Է�
			for(int i=0;i<n;i++) {
				arr[i]=sc.nextInt();
			}
			//������ ���� �Է�
			for(int i=0;i<4;i++) {
				op[i]=sc.nextInt();
			}
			//DFS Ž��
			for(int i=0;i<4;i++) {
				//����� �� �ִ� �������̸�
				if(op[i]!=0) {
					op[i]--;
					//����
					if(i==0) {
						dfs(arr[0]+arr[1],2,n-2);
					}
					//����
					else if(i==1) {
						dfs(arr[0]-arr[1],2,n-2);
					}
					//����
					else if(i==2) {
						dfs(arr[0]*arr[1],2,n-2);
					}
					//������
					else {
						//�������� �ϴ� ���� �����̸�(����� �ٲ� �� ���� �� �ٽ� ������ ����)
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
