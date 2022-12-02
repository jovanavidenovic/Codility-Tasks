import java.util.*;
import java.lang.*;

class Triangles_Opt {
    // check whether three points are collinear --> so they dont form a triangle.
    public boolean collinear(int x1, int y1, int x2, int y2, int x3, int y3){  
        return (x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)) == 0;
    } 
    
    // compute the square of the distance between points (x1, y1) and (x2, y2)
    public int distance (int x1, int y1, int x2, int y2){
        return (int) Math.pow((x1 - x2), 2) + (int) Math.pow((y1 - y2), 2);
    }

    /*
        first point is choosen randomly (in this program its initialized to 0)
        second point is the closest point to the first
        third point is the closest point to the first, such that these three points arent collinear
    */
    public int[] solution(int[] X, int[] Y) {
        int num_points = X.length;  
        int i = 0;

        int distance_i_j = Integer.MAX_VALUE;
        int j = -1;
        for(int cur_j = 1; cur_j < num_points; cur_j++){
            if(distance(X[i], Y[i], X[cur_j], Y[cur_j]) < distance_i_j){
                distance_i_j = distance(X[i], Y[i], X[cur_j], Y[cur_j]);
                j = cur_j; 
            }
        }
        if (j == -1)
            return new int[0];

        int distance_i_k = Integer.MAX_VALUE;
        int k = -1;
        for(int cur_k = 1; cur_k < num_points; cur_k++){
            if(cur_k != j && distance(X[i], Y[i], X[cur_k], Y[cur_k]) < distance_i_k && !collinear(X[i], Y[i], X[j], Y[j], X[cur_k], Y[cur_k])){
                distance_i_k = distance(X[i], Y[i], X[cur_k], Y[cur_k]);
                k = cur_k;
            }
        }
        if (k == -1)
            return new int[0];

        int[] res = new int[3];
        res[0] = i; res[1] = j; res[2] = k;
        return res;
    }
}