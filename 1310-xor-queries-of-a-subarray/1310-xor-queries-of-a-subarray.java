class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;

        int[] prev = new int[n];
        prev[0] = arr[0];
        for(int i = 1; i < n; i++){
            prev[i] = prev[i-1] ^ arr[i];
        }
        int numQueries = queries.length;
        int[] res = new int[numQueries];
        for(int i = 0; i < queries.length; i++){
            int L = queries[i][0];
            int R = queries[i][1];

            if(L == 0){
                res[i] = prev[R];
            }else{
                res[i] = prev[R] ^ prev[L - 1];
            }
        }

        return res;
    }
}