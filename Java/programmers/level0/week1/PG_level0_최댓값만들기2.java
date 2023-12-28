package level0.week1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PG_level0_최댓값만들기2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = null;
		
		int k = Integer.parseInt(br.readLine());
		
		int[] numbers = new int[k];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		int result = solution(numbers);
		
		bw.write(result + "\n");
		
		bw.flush();
		bw.close();

	}
	
    public static int solution(int[] numbers) {
        int answer = 0;
        
        Arrays.sort(numbers);
        
        answer = numbers[0] * numbers[1] > numbers[numbers.length - 2] * numbers[numbers.length - 1] ? numbers[0] * numbers[1] : numbers[numbers.length - 2] * numbers[numbers.length - 1];
        
        return answer;
    }

}
