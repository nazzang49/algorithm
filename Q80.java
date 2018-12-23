package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

//소설의 줄거리, who, where, what에 대한 정보가 입력으로 주어질 때, 미완의 소설을 완성하기
//where는 who를, what은 who와 where로 대체 할 수 있음
public class Q80 {

	//완성된 줄거리 문장을 차례로 저장할 정답 배열
	static ArrayList<String> answer = new ArrayList<>();
	static String who;
	static String where;
	static String what;
	
	//미완의 줄거리를 완성시킬 메소드
	public static void result(ArrayList<String> tmp) {
		String [] strArr = new String[tmp.size()];
		for(int i=0;i<tmp.size();i++) {
			strArr[i]=tmp.get(i);
			//공백을 기준으로 단어 구분
			String [] tmpArr = strArr[i].split(" ");
			for(int j=0;j<tmpArr.length;j++) {
				//단어가 '누구'인 경우
				if((3<=tmpArr[j].length()&&tmpArr[j].length()<=4)
						&&tmpArr[j].substring(0, 3).equals("WHO")) {
					//온점이 붙은 경우
					if(tmpArr[j].length()!=3) {
						tmpArr[j]=who+".";
						continue;
					}
					tmpArr[j]=who;
				}
				//단어가 '어디'인 경우
				else if((5<=tmpArr[j].length()&&tmpArr[j].length()<=6)
						&&tmpArr[j].substring(0, 5).equals("WHERE")) {
					//온점이 붙은 경우
					if(tmpArr[j].length()!=5) {
						tmpArr[j]=where+".";
						continue;
					}
					tmpArr[j]=where;
				}
				//단어가 '무엇'인 경우
				else if((4<=tmpArr[j].length()&&tmpArr[j].length()<=5)
						&&tmpArr[j].substring(0, 4).equals("WHAT")) {
					//온점이 붙은 경우
					if(tmpArr[j].length()!=4) {
						tmpArr[j]=what+".";
						continue;
					}
					tmpArr[j]=what;
				}
			}
			String answer_str = "";
			for(int j=0;j<tmpArr.length;j++) {
				answer_str+=tmpArr[j]+" ";
			}
			//정답 문장 저장
			answer.add(answer_str);
		}
	}
	
	//BR로 입력할 때는 입출력 예외 선언해준다
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int k = 0;
		//입력된 미완의 줄거리를 저장할 배열
		ArrayList<String> tmp = new ArrayList<>();
		//최대 문장 개수는 100개 이하
		while(k<=100) {
			String str = br.readLine();
			//줄거리 입력 종료
			if(str.equals("0")) {
				break;
			}
			tmp.add(str);
			k++;
		}
		who = br.readLine();
		where = br.readLine();
		what = br.readLine();
		if(where.equals("WHO")) {
			where = who;
		}
		if(what.equals("WHO")) {
			what = who;
		}
		if(what.equals("WHERE")) {
			what = where;
		}
		result(tmp);
		//정답 출력
		for(int i=0;i<answer.size();i++) {
			System.out.println(answer.get(i));
		}
	}
}
