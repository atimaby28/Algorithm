package level0.week1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class PG_level0_배열의평균값 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = null;
		
		int n = Integer.parseInt(br.readLine());
		
		int[] numbers = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		double result = solution(numbers);

		bw.write(result + "\n");

		bw.flush();
		bw.close();

	}

    public static double solution(int[] numbers) {
        double answer = 0;
        
        for (int i = 0; i < numbers.length; i++) {
			answer += numbers[i];
		}
        
        return answer / numbers.length;
    }
	
}