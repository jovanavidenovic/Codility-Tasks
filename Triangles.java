import java.util.*;
import java.lang.*;

class Solution {
    // compute the area of the triangle
    public double area(int x1, int y1, int x2, int y2, int x3, int y3){   
        return Math.abs((double) (x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2))/2);
    }  

    // check whether three points are collinear --> so they dont form a triangle
    public boolean collinear(int x1, int y1, int x2, int y2, int x3, int y3){  
        return (x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)) == 0;
    } 

    // check whether the point (x, y) is on the line between points (x1, y1) and (x2, y2)
    public boolean between(int x1, int y1, int x2, int y2, int x, int y){
        return collinear(x1, y1, x2, y2, x, y) && Math.min(x1, x2) <= x && x <= Math.max(x1, x2) && Math.min(y1, y2) <= y && y <= Math.max(y1, y2);
    }

    // check whether the point (x, y) is inside the triangle 
    // -    by computing the sum of the areas of three triangles 
    //      and checking if its equal to the area of the starting triangle
    // -    by checking if its between 2 vertices of the triangle
    public boolean inside_triangle(int x1, int y1, int x2, int y2, int x3, int y3, int x, int y){
        if(between(x1, y1, x2, y2, x, y) || between(x1, y1, x3, y3, x, y) || between(x2, y2, x3, y3, x, y))         
        return true;
        
        
        
        double sum_areas = area(x1, y1, x2, y2, x, y) + area(x1, y1, x3, y3, x, y) + area(x2, y2, x3, y3, x, y);
        double area_triangle = area(x1, y1, x2, y2, x3, y3);
        return sum_areas == area_triangle;
    }

    public int[] solution(int[] X, int[] Y) {
        int num_points = X.length;  
        for(int i = 0; i < num_points; i++){
            for(int j = i + 1; j < num_points; j++){
                for(int k = j + 1; k < num_points; k++){
                    if(!collinear(X[i], Y[i], X[j], Y[j], X[k], Y[k])){
                        boolean is_solution = true;
                        for(int t = 0; t < num_points; t++){
                            if(t != i && t != j && t != k){
                                if(inside_triangle(X[i], Y[i], X[j], Y[j], X[k], Y[k], X[t], Y[t])){
                                    is_solution = false;
                                    break;
                                }
                            }
                        }
                        if(is_solution){
                            int[] sol = new int[3];
                            sol[0] = i; sol[1] = j; sol[2] = k;
                            return sol;
                        }
                    }
                }
            }
        }
        int[] res = new int[0];
        return res;
    }
}