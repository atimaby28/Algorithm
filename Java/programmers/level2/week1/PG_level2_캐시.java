package level2.week1;

import java.io.*;
import java.util.*;

public class PG_level2_캐시 {

    public static final int CACHE_HIT = 1;
    public static final int CACHE_MISS = 5;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        int cacheSize = Integer.parseInt(br.readLine());

        int k = Integer.parseInt(br.readLine());

        String[] cities = new String[k];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < cities.length; i++) {
            cities[i] = st.nextToken();
        }

        int result = solution(cacheSize, cities);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int solution(int cacheSize, String[] cities) {
        int answer = -1;

        ArrayList<String> cache = new ArrayList<>();


        if(cacheSize != 0) {

            cache.add(cities[0]);
            answer = CACHE_MISS;

            for (int i = 1; i < cities.length; i++) {
                boolean flag = false;
                for (int j = 0; j < cache.size(); j++) {
                    if(cities[i].toLowerCase().equals(cache.get(j).toLowerCase())) {
                        answer += CACHE_HIT;
                        cache.remove(cache.get(j));
                        cache.add(cities[i]);
                        flag = true;
                        break;
                    }
                }
                if(!flag) {
                    cache.add(cities[i]);
                    answer += CACHE_MISS;
                }
                if(cache.size() == cacheSize + 1) {
                    cache.remove(0);
                }
            }
        } else {
            answer = cities.length * CACHE_MISS;
        }

        return answer;
    }
}
