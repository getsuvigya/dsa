package slidingwindow;

public class MaxSumOfKElements {
    public static void main(String[] args) {
        int[] a={1, 4, 2, 10, 23, 3, 1, 0, 20};
        System.out.println(maxSumOfKElements(a,4));
        System.out.println("With Sliding window: "+maxSumBySlidingWindow(a,4));
    }

    public static int maxSumOfKElements(int a[], int k){
        int max=0;
        for(int i=0; i<=a.length-k; i++){
            int x = sum(a,i,k);
            if(max<x){
                max=x;
            }
        }
        return max;
    }

    public static int sum(int a[], int i, int kElements){
        int count=1;
        int sum=0;
        while(count<=kElements){
            sum=sum+a[i];
            i++;
            count++;
        }
        System.out.println("sum is :"+sum);
        return sum;
    }

    public static int maxSumBySlidingWindow(int a[],int k){
        int windowSum=0;
        for(int i=0; i<k; i++){
            windowSum = windowSum+a[i];
        }
        int maxSum = windowSum;
        for(int i=k; i<a.length; i++){
            windowSum = windowSum+a[i]-a[i-k];
            if(maxSum<windowSum){
                maxSum=windowSum;
            }
        }
        return maxSum;
    }
}
