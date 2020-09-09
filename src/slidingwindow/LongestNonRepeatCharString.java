package slidingwindow;

import java.util.HashSet;
import java.util.Set;

public class LongestNonRepeatCharString {
    public static void main(String[] args) {
        String s="ab";
        System.out.println("Max length "+lengthOfLongestNonRepeatCharString(s));
    }

    public static int lengthOfLongestNonRepeatCharString(String s){
        Set<Integer> charSet = new HashSet<>();
        int l=0,r=0;
        int maxLength=0;
        if(s.length()==1 || s.length()==0){
            return s.length();
        }
        while(r<=s.length()-1){
            if(!charSet.add((int)s.charAt(r))){
                if(maxLength<charSet.size())
                    maxLength=charSet.size();
                l=l+1;
                r=l;
                charSet.clear();
                continue;
            }
            r++;
        }
        if(maxLength<charSet.size())
            maxLength=charSet.size();
        return maxLength;
    }
}
