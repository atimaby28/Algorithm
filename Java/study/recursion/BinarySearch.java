package recursion;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class BinarySearch {

    public static void main(String[] args) {

        String[] data = {"l", "f", "a", "o", "b", "w", "j", "m", "x", "r"};

        // 이진탐색은 우선 정렬되어야 한다.
        Arrays.sort(data);

        // data = {"a", "b", "f", "j", "l", "m", "o", "r", "w", "x"};

        int targetVal = binSearch(data, 0, data.length - 1, "b");

        System.out.println(targetVal);

    }

    private static int binSearch(String[] data, int begin, int end, String target) {
        if(begin > end) {
            return -1;
        }

        int middle = (begin + end) / 2;

        int compResult = target.compareTo(data[middle]);

        if(compResult == 0) {
            return middle;
        } else if(compResult < 0) {
            return binSearch(data, begin, middle - 1, target);
        } else {
            return binSearch(data, middle + 1, end, target);
        }

    }


}
