package solution;

import java.util.ArrayList;
import java.util.Scanner;

//문제의 정답 배열, 세명의 학생이 문제의 답을 찍는 규칙이 주어질 때 가장 많이 맞힌 학생 구하기
public class Q1 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		//테스트 케이스 개수 제한
		if(1<=t&&t<=1000) {
			int k = 0;
			//케이스별 가장 많이 맞힌 학생의 정답 담을 배열
			String [] answer = new String[t];
			while(k<t) {
				int n = sc.nextInt();
				//문제의 수와 정답을 보여줄 배열
				int [] input = new int[n+1];
				for(int i=1;i<input.length;i++) {
					input[i]=sc.nextInt();
				}
				//각 학생별 맞춘 문제 번호를 담을 가변배열
				ArrayList<Integer> stu1 = new ArrayList<>();
				ArrayList<Integer> stu2 = new ArrayList<>();
				ArrayList<Integer> stu3 = new ArrayList<>();
				//각 학생들의 정답 확인
				for(int i=1;i<input.length;i++) {
					//1번 학생
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
					//2번 학생
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
					//3번 학생
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
				answer[k]="가장 많이 맞힌 학생은 ";
				//정답 개수 비교
				int max = Math.max(stu1.size(), Math.max(stu2.size(), stu3.size()));
				if(max==stu1.size()) {
					answer[k]+="1번 학생이며, 맞힌 문제는 ";
					for(int i=0;i<stu1.size();i++) {
						answer[k]+=stu1.get(i)+" ";
						if(i==stu1.size()-1) {
							answer[k]+="입니다.";
						}
					}
				}else if(max==stu2.size()) {
					answer[k]+="2번 학생이며, 맞힌 문제는 ";
					for(int i=0;i<stu2.size();i++) {
						answer[k]+=stu2.get(i)+" ";
						if(i==stu2.size()-1) {
							answer[k]+="입니다.";
						}
					}
				}else {
					answer[k]+="3번 학생이며, 맞힌 문제는 ";
					for(int i=0;i<stu3.size();i++) {
						answer[k]+=stu3.get(i)+" ";
						if(i==stu3.size()-1) {
							answer[k]+="입니다.";
						}
					}
				}
				stu1.clear();
				stu2.clear();
				stu3.clear();
				k++;
			}
			for(int i=0;i<answer.length;i++) {
				System.out.println((i+1)+"번째 테스트의 결과 : "+answer[i]);
			}
		}
	}
}
