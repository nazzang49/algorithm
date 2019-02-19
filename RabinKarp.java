package test_190219;

//라빈 카프 알고리즘(문자열 매칭 알고리즘) = 각 문자의 아스키 값을 활용해 구한 해시값을 비교하며 일치하는 위치 탐색하는 알고리즘
//ex) a -> 97*2^n 과 같은 형태의 총합과 패턴 문자열의 총합이 같아지는 구간 확인
public class RabinKarp {

	public static void findString(String parent, String pattern) {
		int parentSize = parent.length();
		int patternSize = pattern.length();
		int parentHash = 0;
		int patternHash = 0;
		//power = 제곱 수
		int power = 1;
		for(int i=0;i<parentSize-patternSize;i++) {
			//처음이면 해시값 산출
			if(i==0) {
				for(int j=0;j<patternSize;j++) {
					//오른쪽이 기준 ex) 98*2^1+97*2^0
					parentHash+=parent.charAt(patternSize-1-j)*power;
					patternHash+=pattern.charAt(patternSize-1-j)*power;
					//2의 n승 증가
					if(j<patternSize-1) power*=2;
				}
			}
			//두 번째부터 해시값 갱신(가장 왼쪽에 있는 수치값 -, 가장 오른쪽 수치값 신규 추가 +)
			else {
				parentHash = 2*(parentHash-parent.charAt(i-1)*power)+parent.charAt(patternSize-1+i);
			}
			//현재 형성된 부분 문자열의 해시값 = 패턴 문자열의 해시값(각 문자 비교 -> 해시값이 같아도 문자 구성은 다를 수 있기에)
			if(parentHash==patternHash) {
				boolean flag = false;
				for(int j=0;j<patternSize;j++) {
					//하나라도 다르면 성립 X
					if(parent.charAt(i+j)!=pattern.charAt(j)) {
						flag = true;
						break;
					}
				}
				if(!flag) {
					System.out.println(i+1+"번째 자리에서 성립합니다.");
				}
			}
		}
	}
	
	public static void main(String[] args) {

		String parent = "ababacabacaabacaaba";
		String pattern = "abacaaba";
		
		findString(parent,pattern);	
	}
}
