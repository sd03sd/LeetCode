class Solution {
    public int[] countBits(int n) {
        int[] arr = new int[n+1];
        for(int i = 0; i <= n; i++){
            int count = 0, num = i;
            while(num != 0){
                count++;
                num = num & (num - 1);
            }
            arr[i] = count;
        }
        return arr;
    }
}