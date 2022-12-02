import java.util.*;
import java.lang.*;

class Frogs {

    /*
        frogs must move in different directions to get as far as possible
        in every call of recursion we decide whether a frog can move 1 step left/right
        recursion is over when both frogs cant move anymore 
        (their next position is equal to the current position)
    */
    public int solution(int pos1, int pos2, int[] blocks){
        int next_pos1 = pos1;
        int next_pos2 =  pos2;
        if(pos1 - 1 >= 0 && blocks[pos1 - 1] >= blocks[pos1])
            next_pos1 = pos1 - 1;

        if(pos2 + 1 < blocks.length && blocks[pos2 + 1] >= blocks[pos2])
            next_pos2 = pos2 + 1;

        if(next_pos1 == pos1 && next_pos2 == pos2){
            return pos2 - pos1 + 1;
        }       
        return solution(next_pos1, next_pos2, blocks);
    }

    public int solution(int[] blocks) {
        int res = 0;
        int cur_res = 0;
        // going over all possible starts for frogs
        for(int i = 0; i < blocks.length; i++){
            cur_res = solution(i, i, blocks);
            if(cur_res > res){
                res = cur_res;
            }
        }
        return res;
    }
}
