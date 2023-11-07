package level0.week2;

public class PG_level0_삼각형의완성조건_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public static int solution(int[] sides) {
        int answer = 0;
        
		int bigger = 0;
		int smaller = 0;
		
		if(sides[0] > sides[1]) {
			bigger = sides[0];
			smaller = sides[1];
		} else {
			bigger = sides[1];
			smaller = sides[0];
		}
		
		for (int i = bigger - smaller + 1; i <= bigger; i++) {
			answer++;
		}
		
		for (int i = bigger + 1; i < smaller + bigger; i++) {
			answer++;
		}
		
        return answer;
    }

}
