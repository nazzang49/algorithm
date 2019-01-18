package test_190118;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

//첫 줄에 다른 동물의 소리와 섞인 여우의 울음 소리, 둘째줄부터 다른 동물들의 울음소리가 하나씩 주어질 때 여우의 울음소리 출력하기
public class B_9536 {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		//정답 출력할 배열
		String [] ans = new String[t];
		
		int k = 0;
		while(k<t) {
			//다른 동물의 소리와 섞인 여우의 울음소리
			String str = br.readLine();
			String [] arr = str.split(" ");
			while(true) {
				ans[k]="";
				String other = br.readLine();
				//여우의 울음소리 묻는 질문 입력되면 여우의 울음소리 출력
				if(other.substring(0, 4).equals("what")) {
					for(int i=0;i<arr.length;i++) {
						ans[k]+=arr[i]+" ";
					}
					break;
				}
				for(int i=0;i<arr.length;i++) {
					if(!arr[i].equals(other.split(" ")[2])) {
						ans[k]+=arr[i]+" ";
					}
				}
				arr = ans[k].split(" ");
			}
			k++;
		}
		for(int i=0;i<ans.length;i++) {
			System.out.println(ans[i]);
		}
	}
}
