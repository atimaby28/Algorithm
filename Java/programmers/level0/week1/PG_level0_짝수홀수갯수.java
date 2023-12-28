package level0.week1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class PG_level0_짝수홀수개수 {

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
        int[] answer = new int[2];
        
        for (int i = 0; i < num_list.length; i++) {
			if(num_list[i] % 2 == 0) {
				answer[0]++;
			} else {
				answer[1]++;
			}
		}
        
        return answer;
    }
}