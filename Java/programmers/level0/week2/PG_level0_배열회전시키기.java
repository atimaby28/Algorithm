package level0.week2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class PG_level0_배열회전시키기 {

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
		
		String direction = br.readLine();
		
		int[] result = solution(numbers, direction);

		bw.write(result + "\n");

		bw.flush();
		bw.close();

	}
	
    public static int[] solution(int[] numbers, String direction) {
        int[] answer = new int[numbers.length];
        
        int temp = 0;
        
        if(direction.equals("right")) {
        	temp = numbers[numbers.length - 1];
        	
            for (int i = 1; i < answer.length; i++) {
    			answer[i] = numbers[i - 1];
    		}
            
            answer[0] = temp;
            
        } else {
        	temp = numbers[0];
        	
            for (int i = 1; i < answer.length; i++) {
    			answer[i - 1] = numbers[i];
    		}
            
            answer[answer.length - 1] = temp;
        }
        
        return answer;
    }

}
