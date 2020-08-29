package sorting;

public class BubbleSortDemo {
    public static void main(String[] args) {
        int a[] = {19,31,4,9,6,10,1,1};

        BubbleSortDemo bubbleSortDemo = new BubbleSortDemo();
        bubbleSortDemo.bubbleSort(a);
    }

    public void bubbleSort(int a[]){
        for(int i=0;i<a.length;i++){
            boolean swap = false;
            for(int j=a.length-1; j>i; j--){
                if(a[j]<a[j-1]){
                    swap(a,j,j-1);
                    swap=true;
                }
            }
            System.out.println();
            print(a);
            if(!swap){
                break;
            }
        }
    }

    private void swap(int a[], int i, int j){
        int temp = a[i];
        a[i]=a[j];
        a[j]=temp;
    }

    private void print(int a[]){
        for(int i=0; i<a.length; i++){
            System.out.print(a[i]+"->");
        }
    }
}
