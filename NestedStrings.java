import java.util.*;
import java.lang.*;

public class NestedStrings {

    public int solution(String S) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < S.length(); i++){
            if(S.charAt(i) == '(' || S.charAt(i) == '[' || S.charAt(i) == '{'){
                stack.push(S.charAt(i));
            } else if (S.charAt(i) == ')' || S.charAt(i) == ']' || S.charAt(i) == '}'){           
                if(stack.empty())
                    return 0;  
                char ch = stack.pop();  
                if(!((ch == '(' && S.charAt(i) == ')') || 
                (ch == '[' && S.charAt(i) == ']') || 
                (ch == '{' && S.charAt(i) == '}')))
                    return 0;
            } else return 0;
        }
        if(stack.empty())
            return 1;
        else return 0;
    }
}