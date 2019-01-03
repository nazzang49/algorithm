package solution1;

import java.util.Scanner;

//ü���� ���� �ִ� ����Ʈ�� ���� ��ǥ�� �־��� �� �̵��� �� �ִ� ����� �� ���ϱ�(�ִ� 8)
public class Q125 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String point = sc.next();
		
		//����Ʈ�� �̵��� �� �ִ� �ִ� ����� �� = 8
		int [][] move = {{2,1},{2,-1},{-2,1},{-2,-1},{1,2},{-1,2},{1,-2},{-1,-2}};
		int cnt = 0;
		
		for(int i=0;i<8;i++) {
			int nx = point.charAt(1)-'0'+move[i][0]-1;
			int ny = (int)(point.charAt(0)-'a')+move[i][1];
			
			if(!(nx<0||ny<0||nx>=8||ny>=8)) {
				cnt++;
			}
			
		}
		System.out.println(cnt);
	}
}
