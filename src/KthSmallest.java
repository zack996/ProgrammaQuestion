import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallest {
    public static void main(String[] args) {
        int [][] matrix = {{1,2,3},{4,5,6},{4,5,6}};
        int k = 5;

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, (o1, o2) -> o2-o1);
        int columns = matrix[0].length;
        for (int[] ints : matrix) {
            for (int j = 0; j < columns; j++) {
                if (k != 0) {
                    k--;
                    maxHeap.add(ints[j]);
                } else if (maxHeap.peek() > ints[j]) {
                    maxHeap.poll();
                    maxHeap.add(ints[j]);
                }
            }
        }
        System.out.println(maxHeap.peek());


    }
}
