package test_190212;

import java.util.Scanner;

//< �� > �� ���� ��ȣ�� k�� ���� ������� �־��� ��, �ش� ������ �����ϴ� 0~9������ ���ڸ� ���ʴ�� ��� ������ �� �ִ� k+1�ڸ� ���ڿ� �� �ִ밪�� �ּҰ� ����ϱ�
public class B_2529 {
	
	static int k;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	//�̹� ����� �������� Ȯ���� �迭
	static boolean [] v;
	//��ȣ ������� ���� �迭
	static String [] op;
	static String maxStr = "";
	static String minStr = "";
	
	//DFS + ��Ʈ��ŷ
	public static void dfs(int now, int count, String str) {
		if(count+1==k) {
			int strInt = Integer.parseInt(str);
			//�ִ밪�� �ּҰ� ����
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
			//���� ������� ���� �����̰�, �ε�ȣ ��Ģ �����ϴ� ���
			if(!v[i]) {
				if(op[count].equals(">")&&now>i) {
					v[i]=true;
					tmp+=String.valueOf(i);
					dfs(i,count,tmp);
					//��Ʈ��ŷ
					tmp=str;
					v[i]=false;
				}else if(op[count].equals("<")&&now<i) {
					v[i]=true;
					tmp+=String.valueOf(i);
					dfs(i,count,tmp);
					//��Ʈ��ŷ
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
			//0~9���� ���� ��� ����
			v = new boolean[10];
			//��ȣ �Է�
			op = new String[k];
			for(int i=0;i<k;i++) {
				op[i]=sc.next();
			}
			//DFS Ž�� ����
			for(int i=0;i<=9;i++) {
				v[i]=true;
				dfs(i,-1,String.valueOf(i));
				v[i]=false;
			}
			//���� ���(���ڿ���)
			System.out.println(maxStr);
			System.out.println(minStr);
		}
	}
}
