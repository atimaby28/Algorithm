package level0.week2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class PG_level0_연속된수의합 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int num = Integer.parseInt(st.nextToken());
		int total = Integer.parseInt(st.nextToken());

		int[] result = solution(num, total);

		bw.write(result + "\n");

		bw.flush();
		bw.close();

	}

	public static int[] solution(int num, int total) {
		int[] answer = new int[num];

		int mid = total / num;
		int pos = num / 2;

		if (num % 2 != 0) {

			answer[pos] = mid;

			for (int i = 1; i < (answer.length / 2) + 1; i++) {
				answer[pos + i] = mid + i;
				answer[pos - i] = mid - i;
			}

		} else {
			for (int i = 0; i < answer.length / 2; i++) {
				answer[pos + i] = mid + 1 + i;
				answer[pos - 1 - i] = mid - i;
			}
		}

//		int check = num * (num + 1) / 2;
//		int start = (total - check) / num + 1;
//		
//		for (int i = 0; i < answer.length; i++) {
//			answer[i] = start + i;
//		}

		return answer;
	}

}
