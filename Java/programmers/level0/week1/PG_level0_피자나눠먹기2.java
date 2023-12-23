package level0.week1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class PG_level0_피자나눠먹기2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		int result = solution(n);
		
		bw.write(result + "\n");

		bw.flush();
		bw.close();
		
	}
	
    public static int solution(int n) {
        int answer = 0;
        
        for (int i = 1; i <= 100; i++) {
			if((6 * i) % n == 0) {
				answer = i;
				break;
			}
		}
        
        return answer;
    }
    
//    public int GCD(int num1, int num2) {
//        if (num1 % num2 == 0)
//            return num2;
//        return GCD(num2, num1 % num2);
//    }
//
//    public int LCM(int num1, int num2) {
//        return num1 * num2 / GCD(num1, num2);
//    }
//
//    public int solution(int n) {
//        return LCM(n, 6) / 6;
//    }

}
