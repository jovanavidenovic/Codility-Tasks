import java.util.*;
import java.lang.*;

class Turbines {

    public int distance(int x_i, int y_i, int x_j, int y_j){
        return Math.abs(x_i - x_j) + Math.abs(y_i - y_j);
    }

    public int solution(int[][] A, int K) {
        int res = 0;
        // fill the matrix with all places where the company cant build turbines
        // if it can put 0, if it cant put 1.
        int[][] fill_A = new int[A.length][A[0].length];
        for(int i = 0; i < A.length; i++){
            for(int j = 0; j < A[0].length; j++){
                if(A[i][j] == 1){
                    // if there is a bird in that field
                    fill_A[i][j] = 1;   
                    
                    // fill vertical
                    for(int ii = Math.max(i - K, 0); ii <= Math.min(i + K, A.length - 1); ii++)
                        fill_A[ii][j] = 1;

                    // fill horizontal
                    for(int jj = Math.max(j - K, 0); jj <= Math.min(j + K, A[0].length - 1); jj++)
                        fill_A[i][jj] = 1;

                    // fill other
                    for(int kk_i = 1; kk_i <= K - 1; kk_i++){
                        for(int kk_j = 1; kk_j + kk_i <= K; kk_j++){
                            if(i + kk_i < A.length && j + kk_j < A[0].length)
                                fill_A[i + kk_i][j + kk_j] = 1;
                            if(i - kk_i >= 0 && j + kk_j < A[0].length)
                                fill_A[i - kk_i][j + kk_j] = 1;
                            if(i + kk_i < A.length && j - kk_j >= 0)
                                fill_A[i + kk_i][j - kk_j] = 1;
                            if(i - kk_i >= 0 && j - kk_j >= 0)
                                fill_A[i - kk_i][j - kk_j] = 1;
                        }
                    }
                }
            }
        }

        // the number of turbines the company can build is equal to
        // the number of 0 fields in matrix.
        for(int i = 0; i < fill_A.length; i ++){
            for(int j = 0; j < fill_A[0].length; j++){
                if(fill_A[i][j] == 0)   
                    res ++;
            }
        }
        
        return res;
    }
}
