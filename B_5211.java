package test_190121;

import java.util.Scanner;

//��� ���ǰ��� ���谡 ���ڿ��� �־��� ��, �ش� ���谡 ���������� ���������� �Ǻ��ϴ� ���α׷� �ۼ��ϱ�
public class B_5211 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		if(5<=str.length()&&str.length()<100) {
			int [] alpha = new int[7];
			//'|'������ �������� ���� ����(�׳� |�� ������ ��ȣ�� �ν����� ����)
			//(�ٸ� ���) StringTokenzier st = new StringTokenizer(str,"|");
			//StringTokenizer�� ���ڿ� ���̿� �ִ� ���� ���� X
			//split�޼ҵ�� ���ڿ� ���̿� �ִ� ���� ���� O
			String [] music = str.split("\\|");
			for(int i=0;i<music.length;i++) {
				//���� ���ĺ��� ���� ����
				alpha[music[i].charAt(0)-'A']++;
			}
			int ga = 0;
			int da = 0;
			for(int i=0;i<alpha.length;i++) {
				if(i==0||i==3||i==4) {
					ga+=alpha[i];
				}else {
					da+=alpha[i];
				}
			}
			if(ga>da) {
				System.out.println("A-minor");
			}else if(ga<da) {
				System.out.println("C-major");
			}
			//�߽����� ������ ���� ��� ���� ������ ������ ���� ��
			else {
				char tmp = music[music.length-1].charAt(0);
				if(tmp=='C'||tmp=='F'||tmp=='G') {
					System.out.println("C-major");
				}else {
					System.out.println("A-minor");
				}
			}
		}
	}
}
