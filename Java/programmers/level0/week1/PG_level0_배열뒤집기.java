package level0.week1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class PG_level0_배열뒤집기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = null;
		
		int n = Integer.parseInt(br.readLine());

		int[] num_list = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < num_list.length; i++) {
			num_list[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] result = solution(num_list);
		
		bw.write(result + "\n");

		bw.flush();
		bw.close();
		
	}
	
    public static int[] solution(int[] num_list) {
        int[] answer = {};
        
        answer = new int[num_list.length];
        
        for (int i = 0; i < answer.length; i++) {
			answer[answer.length - 1 - i] = num_list[i];
		}
        
        return answer;
    }

}