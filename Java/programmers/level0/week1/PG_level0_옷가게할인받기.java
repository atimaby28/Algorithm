package level0.week1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class PG_level0_옷가게할인받기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		int result = solution(n);

		bw.write(result + "\n");

		bw.flush();
		bw.close();

	}
	
    public static int solution(int price) {
        int answer = 0;
        
        if(price >= 100000 && price < 300000) {
        	answer = (int) (price * 0.95);
        } else if(price >= 300000 && price < 500000) {
        	answer = (int) (price * 0.9);
        } else if (price >= 500000) {
        	answer = (int) (price * 0.8);
        } else {
        	answer = price;
        }
        
        return answer;
    }

}