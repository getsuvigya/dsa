public class Factorial {
    public static void main(String[] args) {
        System.out.println(printFactorial(5));
    }

    public static int printFactorial(int n){
        if(n>1){
            return n*printFactorial(n-1);
        }else{
            return 1;
        }
    }
}
