package solution;

import java.util.Scanner;

//0~9������ ���ڰ� ���Ƿ� ����Ǿ� �ִ� �迭���� ���������� ��Ÿ���� ���� ���� �� �ϳ��� ����� ������ �� ���� �迭�� ���� ���ϱ�
public class Q17 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		if(1<=n&&n<=1000000) {
			int [] arr = new int[n];
			boolean [] visited = new boolean[10];
			for(int i=0;i<arr.length;i++) {
				int tmp = sc.nextInt();
				if(0<=tmp&&tmp<=9) {
					arr[i]=tmp;
				}
			}
			for(int i=0;i<arr.length;i++) {
				//�������� �����ϸ� 10���� ����
				if(visited[arr[i]]) {
					//�� ���� ���ڰ� �޶��� ��(visited �ʱ�ȭ)
					if(i!=arr.length-1) {
						if(arr[i]!=arr[i+1]) {
							visited[arr[i]]=false;
						}
					}
					arr[i]=10;
				}else {
					visited[arr[i]]=true;
				}
			}
			//�����ִ� �� ���
			for(int i=0;i<arr.length;i++) {
				if(arr[i]!=10) {
					System.out.print(arr[i]+" ");
				}
			}
		}
	}
}
