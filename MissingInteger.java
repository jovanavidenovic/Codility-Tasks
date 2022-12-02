import java.util.*;
import java.lang.*;

public class MissingInteger{
    public int solution(int[] A) {  
        Arrays.sort(A);
        int lng_A = A.length;
        
        if(A[lng_A - 1] <= 0)
            return 1;
        
        int i = 0;
        while(i < lng_A && A[i] <= 0){
            i ++;
        } 

        if(A[i] != 1)
            return 1;
        i ++;

        while(i < lng_A){
            if(A[i] - A[i - 1] >  1) {
               return A[i - 1] + 1; 
            } else i ++;
        }
        
        return A[lng_A - 1] + 1;
    }
}
