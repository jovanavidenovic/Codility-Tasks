import java.util.*;
import java.lang.*;

class BinReprProduct {

    // compute the logarithm of c
    public int log2(long c){
        int res = 0;
        while(c > 1){
            res ++;
            c = (long) c / 2;
        }
        return res;
    }

    // compute 2^pwr
    public long pwr2(int pwr){
        long res = 1;
        for(int i = 0; i < pwr; i++)
            res *= 2;
        return res;
    }

    public int solution(int A, int B) {
        int res = 0;

        long c = (long) A * B;
        int log2_c = log2(c);  
        long pwr2_c = pwr2(log2_c);

        while(c > 0){
            if(c / pwr2_c == 1)
                res ++;
                
            c = c % pwr2_c;
            pwr2_c /= 2;
        }

        return res;
    }
}
