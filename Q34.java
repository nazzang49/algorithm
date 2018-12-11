package solution;

import java.util.ArrayList;
import java.util.Scanner;

class Answer {
	int plays, idx;
	
	public Answer(int plays, int idx) {
		this.plays=plays;
		this.idx=idx;
	}
}

class Genre {
	String genre;
	int total;
	
	public Genre(String genre, int total) {
		this.genre=genre;
		this.total=total;
	}
}

class Track {
	String genre;
	int play;
	int idx;
	
	public Track(String genre, int play, int idx) {
		this.genre=genre;
		this.play=play;
		this.idx=idx;
	}
}

//장르의 종류, 장르별 트랙 재생 횟수가 배열로 주어질 때 장르별 가장 많은 재생 횟수를 가지는 두 개의 음악 출력하기
public class Q34 {

	//특정 장르 내 트랙별 재생횟수 및 idx
	static ArrayList<Track> list = new ArrayList<>();
	//장르별 총 재생횟수
	static ArrayList<Genre> group = new ArrayList<>();
	//정답
	static ArrayList<Answer> answer = new ArrayList<>();
	//최종
	static ArrayList<Integer> last = new ArrayList<>();
	
	public static void result(String [] genres, int [] plays) {
		boolean [] visited = new boolean[genres.length];
		//장르별 재생횟수(1순위 비교)
		int total = 0;
		int cnt = 0;
		
		while(cnt<genres.length) {
			String str = "";
			for(int i=0;i<genres.length;i++) {
				if(!visited[i]) {
					str=genres[i];
					total+=plays[i];
					cnt++;
					list.add(new Track(genres[i], plays[i], i));
					break;
				}
			}
			for(int i=0;i<genres.length;i++) {
				if(!visited[i]&&str.equals(genres[i])) {
					visited[i]=true;
					total+=plays[i];
					cnt++;
					list.add(new Track(genres[i], plays[i], i));
				}
			}
			//장르별 총 재생횟수 저장
			group.add(new Genre(str, total));
			total=0;
		}
		//총 재생횟수에 맞게 오름차순 정렬
		for(int i=0;i<group.size()-1;i++) {
			Genre g = group.get(i);
			for(int j=i+1;j<group.size();j++) {
				Genre g_com = group.get(j);
				if(g.total<=g_com.total) {
					String str = g.genre;
					int tmp = g.total;
					group.set(i, group.get(j));
					group.set(j, new Genre(str, tmp));
				}
			}
		}
		for(int i=0;i<group.size();i++) {
			Genre g = group.get(i);
			for(int j=0;j<list.size();j++) {
				Track t = list.get(j);
				if(g.genre.equals(t.genre)) {
					answer.add(new Answer(t.play, t.idx));
				}
			}
			if(answer.size()>=2) {
				for(int m=0;m<answer.size()-1;m++) {
					Answer a = answer.get(m);
					for(int k=m+1;k<answer.size();k++) {
						Answer a_com = answer.get(k);
						if(a.plays<a_com.plays) {
							int tmp1 = a.plays;
							int tmp2 = a.idx;
							answer.set(m, answer.get(k));
							answer.set(k, new Answer(tmp1, tmp2));
						}
						//재생 횟수가 같을 때는 트랙번호 비교(낮은게 먼저)
						else if(a.plays==a_com.plays) {
							if(a.idx>a_com.idx) {
								int tmp1 = a.plays;
								int tmp2 = a.idx;
								answer.set(i, answer.get(k));
								answer.set(k, new Answer(tmp1, tmp2));
							}
						}
					}
				}
			}
			//재생 횟수가 많은 상위 2개만 저장
			for(int j=0;j<2;j++) {
				Answer a = answer.get(j);
				if(answer.size()>=2) {
					last.add(a.idx);
				}else {
					last.add(a.idx);
					break;
				}
			}
			answer.clear();
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		if(1<=n&&n<=10000) {
			//장르 배열
			String [] genres = new String[n];
			//트랙별 재생 횟수
			int [] plays = new int[n];
			//입력
			for(int i=0;i<n;i++) {
				String str = sc.next();
				int tmp = sc.nextInt();
				genres[i] = str;
				plays[i] = tmp;
			}
			//실행
			result(genres,plays);
			for(int i=0;i<last.size();i++) {
				System.out.println(last.get(i));
			}
		}
	}
}
