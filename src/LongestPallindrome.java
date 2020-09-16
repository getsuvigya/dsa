import java.util.LinkedList;
import java.util.List;

public class LongestPallindrome {
    public static void main(String[] args) {
        System.out.println(returnLongestPalindrome("Hellonitin"));
    }
    public static  String returnLongestPalindrome(String s){
        List<String> palindromes = new LinkedList<>();
        for(int windowSize = 1; windowSize<=s.length(); windowSize++){
            for(int i=0; i<=s.length()-windowSize;){
                String sub = s.substring(i,i+windowSize);
                if(checkIfPallindrome(sub)){
                    palindromes.add(sub);
                }
                i=i+windowSize;
            }
        }
        int max = 0;
        String maxString="";
        for(String s1 : palindromes){
            if(max<s1.length()){
                max = s1.length();
                maxString = s1;
            }
        }
        return maxString;

    }

    public static boolean checkIfPallindrome(String s){
        String reverse = new StringBuilder(s).reverse().toString();
        return reverse.equals(s);
    }
}
