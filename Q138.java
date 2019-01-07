package solution;

import java.util.ArrayList;
import java.util.Scanner;

//최대 힙 개념을 활용하여 입력 받는 자연수를 규칙에 맞게 출력하기
public class Q138 {

	static ArrayList<Integer> answer = new ArrayList<>();
	
	public static ArrayList<Integer> heap(ArrayList<Integer> arr) {
		//오름차순 정렬
		for(int i=0;i<arr.size()-1;i++) {
			for(int j=i+1;j<arr.size();j++) {
				if(arr.get(i)>=arr.get(j)) {
					int tmp = arr.get(i);
					arr.set(i, arr.get(j));
					arr.set(j, tmp);
				}
			}
		}
		//가장 큰 수 배열에서 제거
		answer.add(arr.remove(arr.size()-1));
		return arr;
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		if(1<=n&&n<=100000) {
			ArrayList<Integer> arr = new ArrayList<>();
			
			for(int i=0;i<n;i++) {
				int tmp = sc.nextInt();
				if(tmp==0) {
					arr.add(tmp);
					arr = heap(arr);
				}else {
					arr.add(tmp);
				}
			}
			//정답 출력
			for(int i=0;i<answer.size();i++) {
				System.out.println(answer.get(i));
			}
		}
	}
}
