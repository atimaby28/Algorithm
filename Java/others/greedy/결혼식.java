package greedy;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.StringTokenizer;

public class 결혼식 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());

        int[][] list = new int[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            list[i][0] = Integer.parseInt(st.nextToken());
            list[i][1] = Integer.parseInt(st.nextToken());
        }


        int result = solution(list);

        bw.write(result + "\n");

        bw.flush();
        bw.close();

    }

    private static int solution(int[][] list) {
        int answer = 0;

        ArrayList<Person> people = new ArrayList<>();

        for (int[] person : list) {
            people.add(new Person(person[0], 's'));
            people.add(new Person(person[1], 'e'));
        }

        Collections.sort(people);

        int departure = Integer.MIN_VALUE;

//        int cnt = 0;
//        for (Person person : people) {
//            if (departure < person.arrival) {
//                departure = person.departure;
//                cnt = 0;
//            } else {
//                cnt++;
//                answer = Math.max(answer, cnt);
//            }
//        }

        int cnt = 0;
        for (Person person : people) {

            System.out.println(person.time + " " + person.state);

            if (person.state == 's') cnt++;
            else cnt--;

            answer = Math.max(answer, cnt);
        }

        return answer;
    }
}

//class Person implements Comparable<Person> {
//    int arrival, departure;
//
//    Person(int arrival, int departure) {
//        this.arrival = arrival;
//        this.departure = departure;
//    }
//
//    @Override
//    public int compareTo(Person p) {
//        if (this.departure == p.departure) {
//            return Integer.compare(this.arrival, p.arrival);
//        } else {
//            return Integer.compare(this.departure, p.departure);
//        }
//    }
//
//}

class Person implements Comparable<Person> {
    int time;
    char state;

    Person(int time, char state) {
        this.time = time;
        this.state = state;
    }

    @Override
    public int compareTo(Person p) {
        if (this.time == p.time) {
            return Character.compare(this.state, p.state);
        } else {
            return Integer.compare(this.time, p.time);
        }
    }

}