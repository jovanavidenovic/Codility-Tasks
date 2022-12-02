import java.util.*;
import java.lang.*;
// calculate the length of the longest substring without repeating chars

public class LongestSubstring { 

    public static int lng_longest_substring(String str){
        int i = 0;
        int res = 0;
        int start = 0;
        
        Set<Character> set = new HashSet<>();
        while (i < str.length()){
            char char_i = str.charAt(i);
            if(set.contains(char_i)){
                int j = start;
                while (j < i){
                    if(str.charAt(j) == char_i){ 
                        start = j + 1;
                        break;
                    }

                    set.remove(str.charAt(j));
                    j++;
                }
            } else {
                set.add(char_i);
                res = Math.max(res, set.size());
            }
            i++;
        }
        res = Math.max(res, set.size());
        return res;
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        System.out.println(lng_longest_substring(str));
    }
}
