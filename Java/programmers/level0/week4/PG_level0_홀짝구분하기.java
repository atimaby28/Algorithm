package level0.week4;

import java.util.*;
public class PG_level0_홀짝구분하기 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if (n % 2 != 0) {
            System.out.println(n + " is odd");
        } else {
            System.out.println(n + " is even");
        }
    }

}
