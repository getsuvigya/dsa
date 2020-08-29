package sorting;

public class QuicksortDemo {
    int k=0;
    public static void main(String[] args) {
        int a[] = {19,31,4,9,6,10,1};
        QuicksortDemo quicksortDemo = new QuicksortDemo();
        quicksortDemo.quickSort(a,0,a.length-1);
        for (int i=0; i<a.length; i++) {
            System.out.println(a[i]);
        }
    }
    public void quickSort(int a[], int p, int q){
        if(p<q){
            int m = partition(a,p,q);
            quickSort(a,p,m-1);
            quickSort(a,m+1,q);
        }
    }
    public int partition(int a[], int p, int q){
      k++;
            int x =a[p];
            int i= p;
            for(int j=p+1; j<=q; j++){
                if(a[j]<=x){
                    i=i+1;
                    swap(a, i,j);
                }
            }
            swap(a,i,p);
            return i;
    }

    private void swap(int a[], int i, int j){
        int temp = a[i];
        a[i]=a[j];
        a[j]=temp;
    }
}
