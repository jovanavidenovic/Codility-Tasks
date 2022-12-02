import java.util.*;
import java.lang.*;

public class TreeLongestZigZag {
    public int solution(Tree T, char prev_dir){
        if(T == null)
            return 0;
        if(T.l == null && T.r == null)
            return 0;

        if(T.l == null){
            if(prev_dir == 'l'){
                return solution(T.r, 'r') + 1;
             } else return solution(T.r, 'r');
             
        } else if (T.r == null){
            if(prev_dir == 'l'){
                return solution(T.l, 'l');
            } else return solution(T.l, 'l') + 1;
        }
        
        if(prev_dir == 'l'){
            return Math.max(solution(T.l, 'l'), solution(T.r, 'r') + 1);
        } else return Math.max(solution(T.l, 'l') + 1, solution(T.r, 'r'));
        
    }
    public int solution(Tree T) {
        if(T == null)
            return 0;
        int left = solution(T.l, 'l');
        int right = solution(T.r, 'r');
        return Math.max(left, right);
    }
}