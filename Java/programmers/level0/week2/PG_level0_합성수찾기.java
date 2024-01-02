package level0.week2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class PG_level0_합성수찾기 {

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
        
        for (int i = 4; i <= n; i++) {
        	if(isCompNum(i)) {
        		answer++;
        	}
		}
        
        return answer;
    }

	public static boolean isCompNum(int i) {
		boolean answer = false;
		
		int three = 0;
		for (int j = 1; j <= i; j++) {
			if(i % j == 0 && three < 3) {
				three++;
			}
		}
		
		if(three >= 3) {
			answer = true;
		}
		
		return answer;
	}
	
//    public int solution(int n) {
//        int count = 0;
//
//        for(int i = 4; i <= n; i++) {
//            if(isComposite(i)) {
//                count++;
//            }
//        }
//
//        return count;
//    }
//
//    boolean isComposite(int number) {
//        for(int i = 2; i < number / 2 + 1; i++) {
//            if(number % i == 0) {
//                return true;
//            }
//        }
//
//        return false;
//    }

}
