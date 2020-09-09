package heap.maxheap;

public class MaxHeap {
 private int array[];
 public MaxHeap(int array[]){
     this.array = array;
 }

     public int getLeftChildIndex(int index, int endIndex){
         if(index>endIndex){
             return -1;
         }
         int leftIndex = 2*index+1;
         if(leftIndex>endIndex){
             return -1;
         }
         return leftIndex;
     }


    public int getRightChildIndex(int index, int endIndex){
        if(index>endIndex){
            return -1;
        }
        int rightIndex= 2*index+2;
        if(rightIndex>endIndex){
            return -1;
        }
        return rightIndex;
    }


    public int getParentIndex(int index, int endIndex){
        if(index<=0 || index>endIndex){
            return -1;
        }
        return (index-1)/2;
    }

    public int getElementByIndex(int index){
        return array[index];
    }

    public void swap(int index1, int index2){
     int temp = array[index1];
     array[index1] = array[index2];
     array[index2] = temp;
    }
    public void siftDown(int index, int endIndex){
     int leftIndex = getLeftChildIndex(index, endIndex);
     int rightIndex = getRightChildIndex(index, endIndex);
     if(leftIndex!=-1 && array[leftIndex]>array[index]){
         swap(leftIndex, index);
         siftDown(leftIndex,endIndex);
     }
     if(rightIndex!=-1 && rightIndex<=endIndex && array[rightIndex]>array[index]){
         swap(rightIndex, index);
         siftDown(rightIndex,endIndex);
     }
    }
    public void heapify(int endIndex){
     int index = getParentIndex(endIndex,endIndex);
     while(index>0){
         siftDown(index,endIndex);
         index--;
     }
    }
    public void heapsort(){
     heapify(array.length-1);
     int endIndex = array.length-1;
     while (endIndex>0){
         swap(0,endIndex);
         endIndex--;
         siftDown(0,endIndex);
     }
    }

    public static void main(String[] args) {
     int array[] = {3,4,6,6,3};
        MaxHeap heap = new MaxHeap(array);
        heap.heapsort();
        for (int i=0; i<array.length; i++){
            System.out.println(array[i]);
        }
    }
}
