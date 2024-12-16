package gold.two;

import java.io.*;
import java.util.Arrays;

public class BJ_1377_버블소트 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] nums = new int[n];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        int result = solution(nums);

        bw.write(result + "\n");

        bw.flush();

        br.close();
        bw.close();
    }

    private static int solution(int[] nums) {
        int answer = bubbleSort(nums);

        return answer;
    }

    private static int bubbleSort(int[] nums) {
        ArrayObject[] array = new ArrayObject[nums.length];

        for (int i = 0; i < nums.length; i++) {
            array[i] = new ArrayObject(i, nums[i]);
        }

        Arrays.sort(array);

        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if(max < array[i].index - i)
                max = array[i].index - i;
        }

        return max + 1;
    }



//    이 역시 O(n^2)
//    private static int bubbleSort(int[] nums) {
//        int answer = 0;
//
//        boolean changed;
//        for (int i = 0; i < nums.length - 1; i++) {
//            changed = false;
//            for (int j = 0; j < nums.length - 1; j++) {
//                if(nums[j] > nums[j + 1]) {
//                    changed = true;
//                    swap(nums, j, j + 1);
//                }
//            }
//            if(!changed) {
//                answer = i;
//                break;
//            }
//        }
//        return answer + 1;
//    }
//
//    private static void swap(int[] nums, int a, int b) {
//        int temp = nums[a];
//        nums[a] = nums[b];
//        nums[b] = temp;
//    }
}

class ArrayObject implements Comparable<ArrayObject> {
    int index;
    int value;

    public ArrayObject(int index, int value) {
        this.index = index;
        this.value = value;
    }

    @Override
    public int compareTo(ArrayObject o) {
        return Integer.compare(this.value, o.value);
    }

}