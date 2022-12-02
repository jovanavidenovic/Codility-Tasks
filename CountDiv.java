
public class CountDiv {
    public int solution(int A, int B, int K) {
        int divA = A / K;
        int divB = B / K;
        int sol = divB - divA;
        if(A % K == 0)
            sol ++;
        return sol;
    }
}