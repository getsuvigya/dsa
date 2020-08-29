package sorting;

public class MergeSortDemo {

    public static void main(String[] args) {
        int a[] = {19,31,4,9,6,10,1,1};
        MergeSortDemo mergeSortDemo = new MergeSortDemo();
        mergeSortDemo.mergeSort(a);
        mergeSortDemo.print(a);
    }

    public void mergeSort(int a[]){
        if(a.length==1){
            return;
        }
        int m = a.length/2;
        int firstHalf[] = new int[m];
        int secondHalf[] = new int [a.length-m];
        split(a,firstHalf,secondHalf);
        mergeSort(firstHalf);
        mergeSort(secondHalf);
        merge(a,firstHalf,secondHalf);

    }
    public void split(int a[], int firstHalf[],int secondHalf[]){
        int index = 0;
        int secondIndex = firstHalf.length;
        while(index<a.length){
            if(index<secondIndex) {
                firstHalf[index] = a[index];
            }else{
                secondHalf[index-secondIndex] = a[index];
            }
            index++;
        }
    }

    public void merge(int a[], int firstHalf[], int secondHalf[]){
        int mergeIndex=0;
        int firstIndex=0;
        int secondIndex=0;
        while(firstIndex<firstHalf.length && secondIndex<secondHalf.length){
            if(firstHalf[firstIndex]<secondHalf[secondIndex]){
                a[mergeIndex++] = firstHalf[firstIndex++];
            }else if(secondIndex<secondHalf.length){
                a[mergeIndex++] = secondHalf[secondIndex++];
            }
        }
        if(firstIndex<firstHalf.length){
            while (mergeIndex<a.length){
                a[mergeIndex++] = firstHalf[firstIndex++];
            }
        }
        if(secondIndex<secondHalf.length){
            while (mergeIndex<a.length){
                a[mergeIndex++] = secondHalf[secondIndex++];
            }
        }
    }
    private void print(int a[]){
        for(int i=0; i<a.length; i++){
            System.out.print(a[i]+"->");
        }
    }
}
