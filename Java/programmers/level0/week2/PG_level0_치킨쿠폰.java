package level0.week2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class PG_level0_치킨쿠폰 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int chicken = Integer.parseInt(br.readLine());
		
		int result = solution(chicken);

		bw.write(result + "\n");

		bw.flush();
		bw.close();

	}
	
    public static int solution(int chicken) {
        int answer = 0;
        
        int service = 0;
        int coupon = 0;
        while(chicken >= 10) {
        	
        	service += chicken / 10;
        	coupon += chicken % 10;
        	
        	chicken = chicken / 10;
        	
        }
        
        if(((coupon + chicken) / 10) + ((coupon + chicken) % 10) >= 10) {
        	service += 1;
        }
        
        answer = service + ((coupon + chicken) / 10);
        
//        int coupon = chicken;
//        int service = 0;
//        
//        while (coupon >= 10) {
//            service += coupon / 10;
//            coupon = coupon % 10 + coupon / 10;
//        }
        
        return answer;
    }

}
