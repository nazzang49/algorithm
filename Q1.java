package solution;

import java.util.ArrayList;
import java.util.Scanner;

//������ ���� �迭, ������ �л��� ������ ���� ��� ��Ģ�� �־��� �� ���� ���� ���� �л� ���ϱ�
public class Q1 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		//�׽�Ʈ ���̽� ���� ����
		if(1<=t&&t<=1000) {
			int k = 0;
			//���̽��� ���� ���� ���� �л��� ���� ���� �迭
			String [] answer = new String[t];
			while(k<t) {
				int n = sc.nextInt();
				//������ ���� ������ ������ �迭
				int [] input = new int[n+1];
				for(int i=1;i<input.length;i++) {
					input[i]=sc.nextInt();
				}
				//�� �л��� ���� ���� ��ȣ�� ���� �����迭
				ArrayList<Integer> stu1 = new ArrayList<>();
				ArrayList<Integer> stu2 = new ArrayList<>();
				ArrayList<Integer> stu3 = new ArrayList<>();
				//�� �л����� ���� Ȯ��
				for(int i=1;i<input.length;i++) {
					//1�� �л�
					if(i%5==1) {
						if(input[i]==1) {
							stu1.add(i);
						}
					}else if(i%5==2) {
						if(input[i]==2) {
							stu1.add(i);
						}
					}else if(i%5==3) {
						if(input[i]==3) {
							stu1.add(i);
						}
					}else if(i%5==4) {
						if(input[i]==4) {
							stu1.add(i);
						}
					}else if(i%5==0) {
						if(input[i]==5) {
							stu1.add(i);
						}
					}
					//2�� �л�
					if(i%8==1) {
						if(input[i]==2) {
							stu2.add(i);
						}
					}else if(i%8==2) {
						if(input[i]==1) {
							stu2.add(i);
						}
					}else if(i%8==3) {
						if(input[i]==2) {
							stu2.add(i);
						}
					}else if(i%8==4) {
						if(input[i]==3) {
							stu2.add(i);
						}
					}else if(i%8==5) {
						if(input[i]==2) {
							stu2.add(i);
						}
					}else if(i%8==6) {
						if(input[i]==4) {
							stu2.add(i);
						}
					}else if(i%8==7) {
						if(input[i]==2) {
							stu2.add(i);
						}
					}else if(i%8==0) {
						if(input[i]==5) {
							stu2.add(i);
						}
					}
					//3�� �л�
					if(i%10==1||i%10==2) {
						if(input[i]==3) {
							stu3.add(i);
						}
					}else if(i%10==3||i%10==4) {
						if(input[i]==1) {
							stu3.add(i);
						}
					}else if(i%10==5||i%10==6) {
						if(input[i]==2) {
							stu3.add(i);
						}
					}else if(i%10==7||i%10==8) {
						if(input[i]==4) {
							stu3.add(i);
						}
					}else if(i%10==9||i%10==0) {
						if(input[i]==5) {
							stu3.add(i);
						}
					}
				}
				answer[k]="���� ���� ���� �л��� ";
				//���� ���� ��
				int max = Math.max(stu1.size(), Math.max(stu2.size(), stu3.size()));
				if(max==stu1.size()) {
					answer[k]+="1�� �л��̸�, ���� ������ ";
					for(int i=0;i<stu1.size();i++) {
						answer[k]+=stu1.get(i)+" ";
						if(i==stu1.size()-1) {
							answer[k]+="�Դϴ�.";
						}
					}
				}else if(max==stu2.size()) {
					answer[k]+="2�� �л��̸�, ���� ������ ";
					for(int i=0;i<stu2.size();i++) {
						answer[k]+=stu2.get(i)+" ";
						if(i==stu2.size()-1) {
							answer[k]+="�Դϴ�.";
						}
					}
				}else {
					answer[k]+="3�� �л��̸�, ���� ������ ";
					for(int i=0;i<stu3.size();i++) {
						answer[k]+=stu3.get(i)+" ";
						if(i==stu3.size()-1) {
							answer[k]+="�Դϴ�.";
						}
					}
				}
				stu1.clear();
				stu2.clear();
				stu3.clear();
				k++;
			}
			for(int i=0;i<answer.length;i++) {
				System.out.println((i+1)+"��° �׽�Ʈ�� ��� : "+answer[i]);
			}
		}
	}
}
