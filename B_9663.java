package test_190221;

import java.util.Scanner;

//NxN ũ�� ü���� ���� �� N���� ���� ��, ���� ������ �� ���� �����ǿ� ��ġ��Ű�� ����� �� ����ϱ�
public class B_9663 {

	static int n;
	//Ư�� �࿡�� ����� �� �ε��� ������ �迭
	static int [] rowCol;
	//Ư�� �� ��� ���� ������ �迭
	static int [] col;
	static int cnt = 0;
	
	//���� +1�ϸ� Ž��
	public static void dfs(int row) {
		//������ ����� �����ϸ�(����� �� +1)
		if(row==n) {
			cnt++;
			return;
		}
		//loop = �ݺ��� ������ ������ �� ����ϴ� ��ɾ�
		//1) �� Ž��
		loop : for(int i=0;i<n;i++) {
			if(col[i]==1) {
				//�ٽ� loop�� ó������ �ݺ��ϰڴٴ� �ǹ�
				continue loop;
			}
			//2) �밢�� Ž��(���� �����, �밢�� = ����)
			for(int j=0;j<row;j++) {
				if(Math.abs(row-j)==Math.abs(i-rowCol[j])) {
					//�ٽ� loop�� ó������ �ݺ��ϰڴٴ� �ǹ�
					continue loop;
				}
			}
			//�ΰ��� Ž�� ��� ������ ��츸 �ش� �ڸ� ����� ������ ó��
			rowCol[row]=i;
			col[i]=1;
			//���� �� Ž��
			dfs(row+1);
			col[i]=0;
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		if(n<=15) {
			col = new int[n+1];
			rowCol = new int[n+1];
			dfs(0);
			System.out.println(cnt);
		}else {
			System.out.println("�Է� ������ Ȯ���ϼ���.");
			System.exit(0);
		}
	}
}
