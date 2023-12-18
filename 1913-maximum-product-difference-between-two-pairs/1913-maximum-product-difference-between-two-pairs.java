class Solution {
    public int maxProductDifference(int[] nums) {
        int mul1 = 0, mul2 = 0;
        int diff = 0;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            mul1 = nums[i] * nums[i+1];
            break;
        }
        for(int i = nums.length - 1; i>=0; i--){
            mul2 = nums[i] * nums[i-1];
            break;
        }
        diff = Math.abs(mul1 - mul2);
        return diff;
    }
}