import java.util.*;
import java.lang.*;

public class MaxCounters {
    public int[] solution(int N, int[] A) {
        int[] counters = new int[N];
        int min_counters = 0;
        int max_counters = 0;

        for(int i = 0; i < A.length; i++){
            if(A[i] >= 1 && A[i] <= N){
                int X = A[i] - 1;
                if(counters[X] < min_counters)
                    counters[X] = min_counters;
                
                counters[X] ++;
                if(max_counters < counters[X])
                    max_counters = counters[X];
            } else if (A[i] == N + 1){
                min_counters = max_counters;
            }
        }

        for(int i = 0; i < N; i++){
            counters[i] = Math.max(counters[i], min_counters);
        }

        return counters;
    }
}
