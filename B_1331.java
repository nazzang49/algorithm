package test_181114;

import java.util.Scanner;

//6X6 ũ���� ü���ǿ��� ����Ʈ�� �Է°��� ���� ��� ������ Ž���� �� �ߺ� ���� �������� �� valid ���
public class B_1331 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		boolean [][] visited = new boolean[6][6];
		
		//36�� �Է°� �غ�
		for(int i=0;i<visited.length;i++) {
			for(int j=0;j<visited.length;j++) {
				String tmp = sc.next();
				if(tmp.charAt(0)-'A'>5||tmp.charAt(1)-'1'>5) {
					System.out.println("�Է°� ��Ģ�� �ٽ� Ȯ�����ּ���.");
					System.exit(0);
				}else {
					//���� �湮 X ������ ���
					if(!visited[tmp.charAt(0)-'A'][tmp.charAt(1)-'1']) {
						visited[tmp.charAt(0)-'A'][tmp.charAt(1)-'1']=true;
					}
					//�̹� �湮 O ������ ���(�ùٸ� Ž�� ���� = ���α׷� ����)
					else {
						System.out.println("Invalid");
						System.exit(0);
					}
				}
			}
		}
		System.out.println("Valid");
	}
}
