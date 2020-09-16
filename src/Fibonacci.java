public class Fibonacci {
    public static void main(String[] args) {
        printFibonacci(10);
    }

    public static void printFibonacci(int n){
        int n1=0; int n2=1;
        for(int i=0;i<n;i++){
            System.out.println(n1);
            int sum = n1+n2;
            n1=n2;
            n2=sum;
        }
    }
}
