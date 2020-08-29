package heap;

import java.lang.reflect.Array;
import java.util.Arrays;

public abstract class Heap<T extends Comparable> {
    protected static int max_size = 50;
    protected int count=0;
    public T[] array;

    public Heap(Class clazz){
        this(clazz, max_size);
    }

    public Heap(Class clazz, int maxSize){
        array = (T[])Array.newInstance(clazz, maxSize);
    }

    public boolean isFull(){
        return array.length==count;
    }

    public boolean isEmpty(){
        return count == 0;
    }

    public T getElementAtIndex(int index){
        return array[index];
    }

    public int getCount(){
        return count;
    }

    public T getHighestPriorityElement()throws HeapEmptyException{
        if(count==0){
            throw new HeapEmptyException();
        }

        return array[0];
    }

    public int getLeftChildIndex(int index){
        int leftIndex = 2*index+1;
        if(leftIndex<0 || leftIndex>=count){
            return -1;
        }
        return leftIndex;
    }

    public int getRightChildIndex(int index){
        int rightIndex = 2*index+2;
        if(rightIndex<0 || rightIndex>=count){
            return -1;
        }
        return rightIndex;
    }

    public int getParentIndex(int index){
        int parentIndex = (index-1)/2;
        if(parentIndex<0 || parentIndex>=count){
            return -1;
        }
        return parentIndex;
    }

    public void swap(int index1, int index2){
        T temp = getElementAtIndex(index1);
        array[index1]=array[index2];
        array[index2]=temp;
    }
    public abstract void siftDown(int index);
    public abstract void siftUp(int index);

}
