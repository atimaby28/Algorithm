package level3.week1;

public class PG_level3_기지국설치 {
    public static void main(String[] args) {

    }

    public static int solution(int n, int[] stations, int w) {
        int answer = 0;
        int coverage = 2 * w + 1;
        int start = 1;

        for (int station : stations) {
            int leftCoverage = station - w;
            if (start < leftCoverage) {
                int gap = leftCoverage - start;
                answer += (gap + coverage - 1) / coverage;
            }
            start = station + w + 1;
        }

        if (start <= n) {
            int gap = n - start + 1;
            answer += (gap + coverage - 1) / coverage;
        }

        return answer;
    }
}
