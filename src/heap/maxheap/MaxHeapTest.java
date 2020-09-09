package heap.maxheap;

import heap.Heap;
import heap.HeapEmptyException;
import heap.HeapFullException;

public class MaxHeapTest<T extends Comparable> extends Heap<T> {
    public MaxHeapTest(Class clazz){
        super(clazz);
    }
    public MaxHeapTest(Class clazz, int size){
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

    public static boolean checkAllEqual(int a[]){
        boolean flag =true;
        int i=0;
        while(i<a.length-1){
            int j= i+1;
            if(a[i]!=a[j]){
                flag=false;
                break;
            }
            i++;
        }
        return flag;
    }

    public static void main(String[] args) throws HeapFullException, HeapEmptyException {
        MaxHeapTest<Integer> maxHeap = new MaxHeapTest<>(Integer.class,5);
        int a[] = {3,4,6,6,3};

        int moves =0;
        while(!checkAllEqual(a)){
            maxHeap.count=0;
            for(int i=0;i<a.length;i++){
                maxHeap.insert(a[i]);
            }
            moves=moves+1;
            for(int i=1;i<maxHeap.array.length;i++){
                maxHeap.array[i]=maxHeap.array[i]+1;
            }
            for(int i=0;i<maxHeap.array.length;i++){
                a[i]=maxHeap.array[i];
            }
        }
        System.out.println(moves);

    }
}
