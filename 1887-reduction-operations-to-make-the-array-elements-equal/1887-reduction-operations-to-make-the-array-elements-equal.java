class Solution {
    public int reductionOperations(int[] nums) {
        int n = nums.length;
        int[] freq = new int[50001];

        for(int i=0; i<n; i++){
            freq[nums[i]]++;
        }
        int operation = 0, res = 0;
        for(int i=50000; i>=1; i--){
            if(freq[i] > 0){
                operation += freq[i];
                res += operation - freq[i];
            }
        }

        return res;
    }
}