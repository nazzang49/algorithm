package solution;

import java.util.Scanner;

//������ ������ ����ġ�� �־��� ��, �賶�� �뷮�� �ʰ����� �����鼭 ���� �ִ��� ����ġ�� ���� �� �ִ� ��� ���ϱ�
public class Q69 {

	//�ִ밪 ������ ����
	static int max = Integer.MIN_VALUE;
	static int weight_final;
	static int [] weight;
	static int [] value;
	
	public static void dfs(int start, int total, int sum) {
		//���� ���԰� �賶�� �뷮���� ���� ���
		if(total<=weight_final) {
			for(int i=start+1;i<weight.length;i++) {
				total+=weight[i];
				sum+=value[i];
				if(total>weight_final) {
					sum-=value[i];
					if(sum>=max) {
						max=sum;
					}
				}else {
					if(i==weight.length-1) {
						if(sum>=max) {
							max=sum;
						}	
					}else {
						dfs(i,total,sum);
						total-=weight[i];
						sum-=value[i];	
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		weight_final = sc.nextInt();
		
		if(1<=n&&n<=1000&&1<=weight_final&&weight_final<=10000) {
			weight = new int[n];
			value = new int[n];
			//�Է�
			for(int i=0;i<n;i++) {
				int tmp1 = sc.nextInt();
				int tmp2 = sc.nextInt();
				if(1<=tmp1&&tmp1<=weight_final) {
					weight[i]=tmp1;
					value[i]=tmp2;
				}
			}
			//Ž��
			for(int i=0;i<n;i++) {
				dfs(i, weight[i], value[i]);
			}
			System.out.println(max);
		}
	}
}
