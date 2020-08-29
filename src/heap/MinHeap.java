package heap;

public class MinHeap<T extends Comparable> extends Heap<T> {
    public MinHeap(Class clazz){
        super(clazz);
    }
    public MinHeap(Class clazz, int size){
        super(clazz, size);
    }

    public void siftDown(int index){
        int leftIndex = getLeftChildIndex(index);
        int rightIndex = getRightChildIndex(index);
        int smallerIndex = -1;
        if(leftIndex!=-1 && rightIndex!=-1){
            smallerIndex = getElementAtIndex(leftIndex).compareTo(getElementAtIndex(rightIndex))<0?leftIndex:rightIndex;
        }
        else if(leftIndex!=-1){
            smallerIndex = leftIndex;
        }
        else if(rightIndex!=-1){
            smallerIndex = rightIndex;
        }
        if(smallerIndex==-1){
            return;
        }
        if(getElementAtIndex(smallerIndex).compareTo(getElementAtIndex(index))<0){
            swap(smallerIndex,index);
            siftDown(smallerIndex);
        }
    }

    public void siftUp(int index){
        int parentIndex = getParentIndex(index);
        if(parentIndex!=-1 && getElementAtIndex(index).compareTo(getElementAtIndex(parentIndex))< 0){
            swap(parentIndex,index);
            siftUp(parentIndex);
        }
    }

    public void insert(T element) throws HeapFullException {
        if(count>=array.length){
            throw new HeapFullException();
        }
        array[count] = element;
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
}
