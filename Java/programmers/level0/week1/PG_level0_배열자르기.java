package level0.week1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class PG_level0_배열자르기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = null;
		
		int n = Integer.parseInt(br.readLine());
		
		int[] numbers = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < args.length; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		
		int num1 = Integer.parseInt(st.nextToken());
		int num2 = Integer.parseInt(st.nextToken());
		
		int[] result = solution(numbers, num1, num2);

		bw.write(result + "\n");

		bw.flush();
		bw.close();

	}
	
    public static int[] solution(int[] numbers, int num1, int num2) {
        int[] answer = new int[num2 - num1];
        
        int k = 0;
        for (int i = num1; i <= num2; i++) {
			answer[k++] = numbers[i];
		}
        
//        for (int i = num1; i <= num2; i++) {
//            answer[i -num1] = numbers[i];
//        }
        
        return answer;
    }

}