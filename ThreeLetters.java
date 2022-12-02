import java.util.*;
import java.lang.*;

public class ThreeLetters {
    public String solution(int A, int B) {
        StringBuilder sb = new StringBuilder();

        while (A > 0 || B > 0){
            int sb_lng = sb.length();
            if(A == B){
                if(sb_lng > 0 && sb.charAt(sb_lng - 1) == 'a'){
                    while (A > 0){
                        sb.append("ba");
                        A--;
                        B--;
                    }
                } else {
                    while (A > 0){
                        sb.append("ab");
                        A--;
                        B--;
                    }
                }
            } else if (A > B){ 
                if(A-- > 0)
                    sb.append('a');
                if(A-- > 0)
                    sb.append('a');
                if(B-- > 0)
                    sb.append('b');
            } else {
                if(B-- > 0)
                    sb.append('b');
                if(B-- > 0)
                    sb.append('b');
                if(A-- > 0)
                    sb.append('a');
            }
        }
        return sb.toString();
    }
}
