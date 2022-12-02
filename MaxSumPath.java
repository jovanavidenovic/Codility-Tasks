public class MaxSumPath {

    public static int max_sum(int[] arr){
        int max_sum = 0;
        int i = 0;
        for(; i < arr.length; i++){
            if(arr[i] >= 0)
                break;
        }

        if(i == arr.length)
            return arr[arr.length - 1];

        for(; i < arr.length; i++){
            max_sum += arr[i];
        }

        return max_sum;
    }

    public static int max_positive_path (int[] arr1, int[] arr2, int i1, int i2){
        int res = 0;
        int sum1 = 0;
        int sum2 = 0;

        while(i1 < arr1.length && i2 < arr2.length){
            if(arr1[i1] < arr2[i2]){
                sum1 += arr1[i1];
                i1 ++;
            } else if (arr1[i1] > arr2[i2]){
                sum2 += arr2[i2];
                i2 ++;
            } else {
                res += Math.max(sum1, sum2);
                res += arr1[i1];
                sum1 = 0;
                sum2 = 0;
                i1 ++;
                i2 ++;
            }       
        }

        while(i1 < arr1.length){
            res += arr1[i1];
            i1 ++;
        }
           

        while(i2 < arr2.length){
            res += arr2[i2];
            i2 ++;
        }
            


        return res;
    }


    public static int max_sum_path(int[] arr1, int[] arr2){

        //find the first positive number in both arrays
        int i1 = 0;
        for(; i1 < arr1.length; i1 ++){
            if(arr1[i1] >= 0){
                break;
            }
        }

        if(i1 == arr1.length){
            return max_sum(arr2);
        }

        int i2 = 0;    
        for(; i2 < arr2.length; i2 ++){
            if(arr2[i2] >= 0){
                break;
            }
        }

        if(i2 == arr2.length){
            return max_sum(arr1);
        }

        return max_positive_path(arr1, arr2, i1, i2);
    }   


    public static void main (String[] args){
        int arr1[] = {2, 3, 7, 10, 12};
        int arr2[] = {1, 5, 7, 8};

        System.out.println(max_sum_path(arr1, arr2));


        int ar1[] = { 2, 3, 7, 10, 12, 15, 30, 34 };
        int ar2[] = { 1, 5, 7, 8, 10, 15, 16, 19 };

        System.out.println(max_sum_path(ar1, ar2));

    } 
}

