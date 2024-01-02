package level0.week2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class PG_level0_삼각형의완성조건2 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st;
		
		int[] sides = new int[2];
		st = new StringTokenizer(br.readLine());
		
		sides[0] = Integer.parseInt(st.nextToken());
		sides[1] = Integer.parseInt(st.nextToken());
		
		int result = solution(sides);

		bw.write(result + "\n");

		bw.flush();
		bw.close();

	}
	
    public static int solution(int[] sides) {
        int answer = 0;
        
		int bigger = 0;
		int smaller = 0;
		
		if(sides[0] > sides[1]) {
			bigger = sides[0];
			smaller = sides[1];
		} else {
			bigger = sides[1];
			smaller = sides[0];
		}
		
		for (int i = bigger - smaller + 1; i <= bigger; i++) {
			answer++;
		}
		
		for (int i = bigger + 1; i < smaller + bigger; i++) {
			answer++;
		}
		
        return answer;
    }

}
