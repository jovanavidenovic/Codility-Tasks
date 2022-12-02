
import java.util.*;
import java.lang.*;

public class Peaks {

    public List<Integer> peaks(int[] A){
        List<Integer> peaks = new ArrayList<>();

        for(int i = 1; i < A.length - 1; i++){
            if(A[i - 1] < A[i] && A[i] > A[i + 1]){
                peaks.add(i);
            }
        }

        return peaks;
    }

    public int solution(int[] A) {
        int lng_A = A.length;

        List<Integer> peaks = peaks(A);
        int num_peaks = peaks.size();
        if(num_peaks == 0)
            return 0;
        
        int max_num_blocks = 1;
        boolean found = false;
        for(int i = num_peaks; i >= 2 && !found; i--){
            if(lng_A % i == 0){
            //check if we can have blocks of equal size
                int size_of_block = lng_A / i;
                int cur_block = 0;
                for(int ii = 0; ii < peaks.size(); ii++){
                //go through the peaks and check whether we have them in all blocks
                    if(peaks.get(ii) / size_of_block == cur_block){
                        cur_block ++;
                        if(cur_block == i){
                            max_num_blocks = i;
                            found = true;        
                            break;
                        }
                    } else if (peaks.get(ii) / size_of_block > cur_block){
                        break;
                    }   
                }
            }            
        }

        return max_num_blocks;
    }
}