package sorting.heapsort;

public class HeapSort {
    static int array[];

    public static int getLeftChildIndex(int index, int endIndex){
        int leftIndex= 2*index+1;
        if(leftIndex>endIndex){
            return -1;
        }
        return leftIndex;
    }

    public static int getRightChildIndex(int index, int endIndex){
        int rightIndex= 2*index+2;
        if(rightIndex>endIndex){
            return -1;
        }
        return rightIndex;
    }

    public static void swap(int index1, int index2){
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static int getParentIndex(int index, int endIndex){
        if(index<0 || index>endIndex){
            return -1;
        }
        return (index-1)/2;
    }

    public static void siftDown(int index, int endIndex){
        int leftIndex = getLeftChildIndex(index, endIndex);
        int rightIndex = getRightChildIndex(index, endIndex);
        if(leftIndex!=-1 && array[leftIndex]>array[index]){
            swap(leftIndex,index);
            siftDown(leftIndex,endIndex);
        }
        if(rightIndex!=-1 && array[rightIndex]>array[index]){
            swap(rightIndex,index);
            siftDown(rightIndex,endIndex);
        }
    }

    public static void heapify(int endIndex){
        int index = getParentIndex(endIndex,endIndex);
        if(index>=0){
            siftDown(index,endIndex);
            index--;
        }
    }

    public static void heapSort(){
        heapify(array.length-1);
        int endIndex = array.length-1;
        while (endIndex>0){
            swap(0,endIndex);
            endIndex--;
            siftDown(0,endIndex);
        }
    }
}
