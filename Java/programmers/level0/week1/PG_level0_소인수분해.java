package level0.week1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class PG_level0_소인수분해 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] result = solution(n);

		bw.write(result + "\n");

		bw.flush();
		bw.close();

	}
	
    public static int[] solution(int n) {
        int[] answer = {};
        
        Set<Integer> set = new TreeSet<Integer>();
        
        int target = n;
        int q = 1;
        for (int i = 2; i <= target; i++) {
			if(isPrime(i) && q <= target) {
				while(n % i == 0) {
					q *= i;
					n /= i;
					set.add(i);
				}
			} else {
				continue;
			}
		}
        
//        LinkedHashSet<Integer> primeNumbers = new LinkedHashSet<>();
//
//        int i = 2;
//        while (n != 0 && i <= n) {
//            if (n % i == 0) {
//                primeNumbers.add(i);
//                n /= i;
//            } else {
//                i++;
//            }
//        }
        
        answer = new int[set.size()];
        
        int i = 0;
        Iterator<Integer> iter = set.iterator();
        while(iter.hasNext()) {
        	answer[i++] = iter.next();
        }
        
        return answer;
    }

	private static boolean isPrime(int i) {
		boolean answer = true;
		for (int j = 2; j < i; j++) {
			if(i % j == 0) {
				 answer = false;
			} 
		}
		
		return answer;
		
	}

}
