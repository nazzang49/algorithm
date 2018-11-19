package test_181118;

import java.util.Scanner;

//오렌지, 사과, 파인애플 주스 양과 무알콜 칵테일을 만드는 제조비가 주어질 때,
//최대한 많은 칵테일을 제조할 시 각 주스의 남는 양 구하기
public class B_2896 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int [] fruit = new int[3];
		int [] ratio = new int[3];
		float [] answer = new float[3];
		int min = Integer.MAX_VALUE;
		
		for(int i=0;i<3;i++) {
			fruit[i] = sc.nextInt();
		}
		for(int i=0;i<3;i++) {
			ratio[i] = sc.nextInt();
		}
		
		//기준이 될 인덱스 추출
		int idx = 0;
		//마지막 제조 비율
		float tmp = 0;
		
		for(int i=0;i<fruit.length;i++) {
			if(min>fruit[i]-ratio[i]) {
				min=fruit[i]-ratio[i];
				idx=i;
			}
		}
		
		//변수 재활용
		//어느 하나의 주스가 소진될 때의 몫과 마지막 비율
		min = fruit[idx]/ratio[idx];
		tmp = fruit[idx]%ratio[idx];
		tmp = tmp/ratio[idx];
		System.out.println(tmp);
		answer[idx]=0;
		
		if(idx==0) {
			answer[1]=fruit[1]-min*ratio[1]-tmp*ratio[1];
			answer[2]=fruit[2]-min*ratio[2]-tmp*ratio[2];
		}else if(idx==1) {
			answer[0]=fruit[0]-min*ratio[0]-tmp*ratio[0];
			answer[2]=fruit[2]-min*ratio[2]-tmp*ratio[2];
		}else if(idx==2) {
			answer[1]=fruit[1]-min*ratio[1]-tmp*ratio[1];
			answer[2]=fruit[2]-min*ratio[2]-tmp*ratio[2];
		}
		
		for(int j=0;j<answer.length;j++) {
			if(answer[j]==0) {
				System.out.print(0+" ");
				continue;
			}
			System.out.printf("%.6f",answer[j]);
			System.out.print(" ");
		}
		
	}

}
