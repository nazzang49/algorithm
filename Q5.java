package solution;

import java.util.ArrayList;
import java.util.Scanner;

class Pos {
	int start, end;
	
	public Pos(int start, int end) {
		this.start=start;
		this.end=end;
	}
}

//고속도로를 이용하는 차량의 경로가 주어질 때 모든 차량이 반드시 한번은 카메라를 만나도록 하기 위한 최소 대수 구하기
public class Q5 {

	public static int camera(int [][] car) {
		ArrayList<Pos> list = new ArrayList<>();
		int cnt = 1;
		//카메라가 설치되는 범위(초기값 저장)
		list.add(new Pos(car[0][0], car[0][1]));
		for(int i=1;i<car.length;i++) {
			for(int j=0;j<list.size();j++) {
				Pos p = list.get(j);
				//현재 경로가 카메라 설치 범위에 포함될 때
				if(p.start<=car[i][0]&&car[i][1]<=p.end) {
					list.set(j, new Pos(car[i][0], car[i][1]));
				}
				//일부분만 겹칠 때1
				else if(car[i][0]<p.start&&p.start<=car[i][1]) {
					list.set(j, new Pos(p.start, car[i][1]));
				}
				//일부분만 겹칠 때2
				else if(car[i][0]<p.end&&p.end<=car[i][1]) {
					list.set(j, new Pos(car[i][1], p.end));
				}
				//완전히 벗어나는 경우
				else if(car[i][1]<p.start||p.end<car[i][0]) {
					list.add(new Pos(car[i][0], car[i][0]));
					cnt++;
				}
			}
		}
		return cnt;
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		//차량의 대수는 10000대 이하
		if(1<=n&&n<=10000) {
			int [][] car = new int[n][2];
			for(int i=0;i<car.length;i++) {
				int start = sc.nextInt();
				int end = sc.nextInt();
				//차량의 입장, 퇴장 지점
				if(-30000<=start&&start<=30000&&-30000<=end&&end<=30000) {
					car[i][0]=start;
					car[i][1]=end;
				}else {
					System.out.println("입력 규칙을 확인하세요.");
					System.exit(0);
				}
			}
			int cnt = camera(car);
			System.out.println(cnt);
		}
	}
}
