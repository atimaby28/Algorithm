package level0.week1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class PG_level0_아이스아메리카노 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int money = Integer.parseInt(br.readLine());
		
		int[] result = solution(money);

		bw.write(result + "\n");

		bw.flush();
		bw.close();

	}
	
    public static int[] solution(int money) {
        int[] answer = new int[2];
        
        answer[0] = money / 5500;
        answer[1] = money % 5500;
        
        return answer;
    }

}