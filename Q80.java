package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

//�Ҽ��� �ٰŸ�, who, where, what�� ���� ������ �Է����� �־��� ��, �̿��� �Ҽ��� �ϼ��ϱ�
//where�� who��, what�� who�� where�� ��ü �� �� ����
public class Q80 {

	//�ϼ��� �ٰŸ� ������ ���ʷ� ������ ���� �迭
	static ArrayList<String> answer = new ArrayList<>();
	static String who;
	static String where;
	static String what;
	
	//�̿��� �ٰŸ��� �ϼ���ų �޼ҵ�
	public static void result(ArrayList<String> tmp) {
		String [] strArr = new String[tmp.size()];
		for(int i=0;i<tmp.size();i++) {
			strArr[i]=tmp.get(i);
			//������ �������� �ܾ� ����
			String [] tmpArr = strArr[i].split(" ");
			for(int j=0;j<tmpArr.length;j++) {
				//�ܾ '����'�� ���
				if((3<=tmpArr[j].length()&&tmpArr[j].length()<=4)
						&&tmpArr[j].substring(0, 3).equals("WHO")) {
					//������ ���� ���
					if(tmpArr[j].length()!=3) {
						tmpArr[j]=who+".";
						continue;
					}
					tmpArr[j]=who;
				}
				//�ܾ '���'�� ���
				else if((5<=tmpArr[j].length()&&tmpArr[j].length()<=6)
						&&tmpArr[j].substring(0, 5).equals("WHERE")) {
					//������ ���� ���
					if(tmpArr[j].length()!=5) {
						tmpArr[j]=where+".";
						continue;
					}
					tmpArr[j]=where;
				}
				//�ܾ '����'�� ���
				else if((4<=tmpArr[j].length()&&tmpArr[j].length()<=5)
						&&tmpArr[j].substring(0, 4).equals("WHAT")) {
					//������ ���� ���
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
			//���� ���� ����
			answer.add(answer_str);
		}
	}
	
	//BR�� �Է��� ���� ����� ���� �������ش�
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int k = 0;
		//�Էµ� �̿��� �ٰŸ��� ������ �迭
		ArrayList<String> tmp = new ArrayList<>();
		//�ִ� ���� ������ 100�� ����
		while(k<=100) {
			String str = br.readLine();
			//�ٰŸ� �Է� ����
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
		//���� ���
		for(int i=0;i<answer.size();i++) {
			System.out.println(answer.get(i));
		}
	}
}
