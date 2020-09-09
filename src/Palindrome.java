public class Palindrome {
    public static void main(String[] args) throws Exception {
        String s = "nitin";
        System.out.println(checkPalindrome(s));
        System.out.println(checkPalindromeWithoutApi(s));
    }

    public static boolean checkPalindrome(String s){
        StringBuilder stringBuilder = new StringBuilder(s);
        String reverseString = stringBuilder.reverse().toString();
        if(s.equals(reverseString)){
            return true;
        }
        return false;
    }

    public static boolean checkPalindromeWithoutApi(String s) throws Exception {
        char[] inputArray = s.toCharArray();
        Stack<Character> stack = new Stack<>(s.length());
        for (int i =0; i<inputArray.length;i++){
            stack.push(inputArray[i]);
        }

        char [] reverseArray = new char[s.length()];
        int i=0;
        while (!stack.isEmpty()){
            reverseArray[i]=stack.pop();
            i++;
        }
        for(int j=0; j<inputArray.length; j++){
            if(reverseArray[j]!=inputArray[j]){
                return false;
            }
        }
        return true;
    }
}

class Stack<T>{
    Element<T> top;
    int maxSize = 10;
    int count=0;
    public Stack(int size){
        this.maxSize=size;
    }
    public void push(T data) throws Exception {
        if(count==maxSize){
            throw new Exception("StackOverflow");
        }
        Element<T> e = new Element<>(data,top);
        top = e;
        count++;
    }

    public T pop() throws Exception {
        if(count==0){
            throw new Exception("Stack underflow exception");
        }
        T data  = top.data;
        top=top.next;
        count--;
        return data;
    }

    public T peek() throws Exception {
        if(count==0){
            throw new Exception("Stack underflow exception");
        }
        T data  = top.data;
        return data;
    }

    public boolean isEmpty(){
        if(count==0){
            return true;
        }
        return false;
    }
}

class Element<T>{
    T data;
    Element<T> next;

    public Element(T data, Element<T> top){
        this.data=data;
        this.next = top;
    }
}