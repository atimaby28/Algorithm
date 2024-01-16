package priority;

public class priorityQueue {
    public static int n = 100;
    public static int[] Arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};

    public static void main(String[] args) {
        Heap heap = new Heap();
        for (int i = 0; i < Arr.length; i++)
            heap.push(Arr[i]);

        for (int i = 0; i < Arr.length; i++) {
            System.out.print(heap.pop() + " ");
        }
    }

    public static class Heap {
        int[] heap = new int[n];
        int hCnt = 0;

        public Heap() {
        }

        public void push(int x) {
            heap[++hCnt] = x;
            int idx = hCnt;
            while (idx > 1 && heap[idx / 2] < heap[idx]) {
                if (idx == 1 || heap[idx / 2] > heap[idx])
                    break;
                swap(heap, idx / 2, idx);
//                int tmp = heap[idx / 2];
//                heap[idx / 2] = heap[idx];
//                heap[idx] = tmp;
                idx /= 2;
            }
        }

        public int pop() {
            int pop = heap[1];
            heap[1] = heap[hCnt--];
            int idx = 1;
            int next;
            while (true) {
                next = idx * 2;
                if (next < hCnt && heap[next] < heap[next + 1])
                    next++;
                if (next > hCnt || heap[next] < heap[idx])
                    break;

                swap(heap, idx, next);
//                int tmp = heap[idx];
//                heap[idx] = heap[next];
//                heap[next] = tmp;
                idx = next;
            }
            return pop;
        }
    }

    public static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
