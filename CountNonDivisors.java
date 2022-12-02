import java.util.*;
import java.lang.*;

public class CountNonDivisors {
    public int[] solution(int[] A) {
        int lng_A = A.length;   
        int[] nondiv_A = new int[lng_A];
        Map <Integer, Integer> elem2occ = new HashMap <>();
        for(int i = 0; i < lng_A; i ++){
            if(elem2occ.get(A[i]) == null){
                elem2occ.put(A[i], 1);
            } else {
                elem2occ.put(A[i], elem2occ.get(A[i]) + 1);
            }
        }

        for(int i = 0; i < lng_A; i++){
            int divisors = 0;

            for(int j = 1; j * j <= A[i]; j++){  
                if(A[i] % j == 0){
                    // check whether j exists in the array
                    if(elem2occ.get(j) != null){
                        divisors += elem2occ.get(j);      
                    }

                    // check whether A[i] / j exists in the array
                    if(j * j != A[i] && elem2occ.get(A[i] / j) != null){
                        divisors += elem2occ.get(A[i] / j); 
                    }
                }
            }

            nondiv_A[i] = lng_A - divisors;
        }
        return nondiv_A;
    }
}
