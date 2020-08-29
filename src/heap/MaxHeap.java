package heap;

public class MaxHeap<T extends Comparable> extends Heap<T> {
    public MaxHeap(Class clazz){
        super(clazz);
    }
    public MaxHeap(Class clazz, int size){
        super(clazz, size);
    }
    @Override
    public void siftDown(int index) {
        int leftIndex = getLeftChildIndex(index);
        int rightIndex = getRightChildIndex(index);
        int greaterIndex = -1;
        if(leftIndex!=-1 && rightIndex!=-1){
            greaterIndex = getElementAtIndex(leftIndex).compareTo(getElementAtIndex(rightIndex))>0?leftIndex:rightIndex;
        }
        else if(leftIndex!=-1){
            greaterIndex = leftIndex;
        }
        else if(rightIndex!=-1){
            greaterIndex=rightIndex;
        }
        else if(greaterIndex==-1){
            return;
        }
        if((getElementAtIndex(greaterIndex).compareTo(getElementAtIndex(index)))>0){
            swap(greaterIndex,index);
            siftDown(greaterIndex);
        }
    }

    @Override
    public void siftUp(int index) {
        int parentIndex = getParentIndex(index);
        if(parentIndex!=-1 && (getElementAtIndex(parentIndex).compareTo(getElementAtIndex(index)))<0){
            swap(parentIndex,index);
            siftUp(parentIndex);
        }
    }

    public void insert(T element) throws HeapFullException {
        if(count>=array.length){
            throw new HeapFullException();
        }
        array[count]=element;
        siftUp(count);
        count++;
    }

    public T remove() throws HeapEmptyException {
        T element = getHighestPriorityElement();
        array[0]=array[count -1];
        count--;
        siftDown(0);
        return element;

    }

    public static void main(String[] args) throws HeapFullException, HeapEmptyException {
        MaxHeap<Integer> maxHeap = new MaxHeap<>(Integer.class,6);
        maxHeap.insert(25);
        maxHeap.insert(30);
        maxHeap.insert(4);
        maxHeap.insert(3);
        maxHeap.insert(16);
        maxHeap.insert(47);


        for (int i=0; i<maxHeap.array.length; i++){
            System.out.print(maxHeap.array[i]+" ->");
        }

        System.out.println("removing-------");
        System.out.println(maxHeap.remove());
        System.out.println(maxHeap.remove());
        System.out.println(maxHeap.remove());
        System.out.println(maxHeap.remove());
        System.out.println(maxHeap.remove());
        System.out.println(maxHeap.remove());
    }
}
