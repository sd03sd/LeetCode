class Solution {
    public int singleNumber(int[] nums) {
        int xorAns = 0;
        for(int i = 0; i < nums.length; i++){
            xorAns ^= nums[i];
        }
        return xorAns;
    }
}