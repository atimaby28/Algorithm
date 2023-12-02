package level0.week2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class PG_level0_잘라서배열로저장하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String my_str = br.readLine();

		int n = Integer.parseInt(br.readLine());

		String[] result = solution(my_str, n);

		bw.write(result + "\n");

		bw.flush();
		bw.close();

	}

	public static String[] solution(String my_str, int n) {
		String[] answer = {};
		
		Queue<Object> que = new LinkedList<Object>();

		int len = 0;
		if (my_str.length() % 2 == 0) {
			len = my_str.length() / n + 1;
		} else {
			len = my_str.length() / n;
		}

		answer = new String[len];

		for (int i = 0; i < my_str.length(); i++) {
			que.offer(my_str.charAt(i));
		}
		
		System.out.println(que);
		
		int k = 0;
		while(que.size() != 0) {
			answer[k] =  "";
			for (int i = 0; i < n; i++) {
				if(que.size() == 0) {
					break;
				}
				answer[k] += que.poll();
			}
			k++;
		}

		
		return answer;
	}

}
