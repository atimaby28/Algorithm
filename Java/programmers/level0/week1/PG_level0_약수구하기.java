package level0.week1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class PG_level0_약수구하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		int[] result = solution(n);

		bw.write(result + "\n");

		bw.flush();
		bw.close();

	}

	public static int[] solution(int n) {
		int[] answer = {};

		ArrayList<Integer> arrlist = new ArrayList<Integer>();

		for (int i = 1; i <= n; i++) {
			if (n % i == 0) {
				arrlist.add(i);
			}
		}

		answer = new int[arrlist.size()];

		for (int i = 0; i < arrlist.size(); i++) {
			answer[i] = arrlist.get(i);
		}

		return answer;
	}

//	public int[] solution(int n) {
//            int[] answer = new int[n];
//
//            int cnt = 0;
//            for (int i = 1; i <= n; i++) {
//                if (n % i == 0) {
//                    //answer[cnt] = i;
//                    cnt++;
//                }
//            }
//
//            answer = new int[cnt];
//
//            cnt = 0;
//            for (int i = 1; i <= n; i++) {
//                if (n % i == 0) {
//                    answer[cnt] = i;
//                    cnt++;
//                }
//            
//
//            return answer;
//        }
//	}

}
