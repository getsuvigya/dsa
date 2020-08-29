package heap;

public class MinHeapDemo {
    public static void main(String[] args) throws HeapFullException, HeapEmptyException {
        MinHeap<Integer> minHeap = new MinHeap<>(Integer.class);
        minHeap.insert(25);
        minHeap.insert(30);
        minHeap.insert(4);
        minHeap.insert(3);
        minHeap.insert(16);
        minHeap.insert(47);


        for (int i=0; i<minHeap.array.length; i++){
            System.out.println(minHeap.array[i]);
        }

        System.out.println("removing-------");
        System.out.println(minHeap.remove());
        System.out.println(minHeap.remove());
        System.out.println(minHeap.remove());
        System.out.println(minHeap.remove());
        System.out.println(minHeap.remove());
        System.out.println(minHeap.remove());
    }
}
