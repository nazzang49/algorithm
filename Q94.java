package solution1;

import java.util.Scanner;

//���ҿ� ���� �Ϸ絿�� �Դ� ����� ���� a,b�̸� ������ Ȯ���� ���ҿ� ���� �� �ջ��� n, �Ϸ絿�� �Һ�� ����� ���� w�� �� ���ҿ� ���� ������ ����ϱ�
public class Q94 {

	//������ ����� �� ������ ����
	static int count = 0;
	//���ҿ� ���� ������
	static int yeomso = 0;
	static int yang = 0;
	static int w;
	static int a;
	static int b;
	static int n;
	
	//a�� ����, b�� ��
	public static void dfs(int y1, int y2) {
		if(y1*a+y2*b==w&&y1+y2==n) {
			//�ּ� 1�������� �����ؾ���(�̹� ���� ����� ����� �ߺ����� �ʵ��� ��ġ)
			if(!(y1==0||y2==0)&&!(yeomso==y1&&yang==y2)) {
				count++;
				yeomso = y1;
				yang = y2;
				//2���� �̻� ������ ��찡 ������
				if(count>=2) {
					System.out.println(-1);
					System.exit(0);
				}
			}
		}else if(y1+y2<n) {
			for(int i=0;i<2;i++) {
				if(i==0) {
					y1++;
					dfs(y1,y2);
					y1--;
				}else {
					y2++;
					dfs(y1,y2);
					y2--;
				}
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		a = sc.nextInt();
		b = sc.nextInt();
		n = sc.nextInt();
		w = sc.nextInt();
		
		if(1<=a&&a<=1000&&1<=b&&b<=1000&&2<=n&&n<=1000&&2<=w&&w<=1000000) {
			dfs(0,0);
			if(yeomso==0&&yang==0) {
				System.out.println(-1);
				System.exit(0);
			}
			System.out.println(yeomso);
			System.out.println(yang);
		}
	}
}
