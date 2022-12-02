import java.util.*;
import java.lang.*;

public class MinimumAverageSlice {
    double min = Double.MAX_VALUE;
	int min_starting_idx = -1;

    public void min_slice(int[] A, int start, int end){
        if (start == end)
            return;
        if (start == end - 1){ 
            double c_min = (double) (A[start] + A[end])/2;
            if(c_min < min || (c_min == min && start < min_starting_idx)){
                min = c_min;
                min_starting_idx = start;
            } 
            return;
        }
            
        int middle = (start + end)/2;
        min_slice(A, start, middle);
        min_slice(A, middle + 1, end);
        
        double cur_min = (double) (A[middle] + A[middle + 1]) / 2;
        double cur_sum = A[middle] + A[middle + 1];
        
        int num_elems = 2;

        int starting_idx_min = middle;

        for(int i = middle - 1; i >= start; i--){
            cur_sum += A[i];
            num_elems ++;
            if((double) cur_sum / num_elems < cur_min){
                cur_min = (double) cur_sum / num_elems;
                starting_idx_min = i;
            }
        }   
        
        if(cur_min == (double) (A[middle] + A[middle + 1]) / 2){
            num_elems = 2;
            cur_sum = A[middle] + A[middle + 1];
            starting_idx_min = middle;
        }
        
        for(int i = middle + 2; i <= end; i++){
            cur_sum += A[i];
            num_elems ++;
            if((double) cur_sum / num_elems < cur_min){
                cur_min = (double) cur_sum / num_elems;
            }
        }  

        if(cur_min < min || (cur_min == min && starting_idx_min < min_starting_idx)){
            min = cur_min;
            min_starting_idx = starting_idx_min;
        }
    }   

    public int solution(int[] A) {
        min_slice(A, 0, A.length - 1);
        return min_starting_idx;
    }
}