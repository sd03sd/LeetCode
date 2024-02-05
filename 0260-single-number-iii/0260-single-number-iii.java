class Solution {
    public int[] singleNumber(int[] nums) {
        int xorAns = 0;
        for(int i = 0; i < nums.length; i++){
            xorAns ^= nums[i];
        }
        xorAns = xorAns & ~(xorAns - 1);

        int set1 = 0;
        int set2 = 0;

        for(int i = 0; i < nums.length; i++){
            if((xorAns & nums[i]) != 0){
                set1^=nums[i];
            }else{
                set2^=nums[i];
            }
        }
        int[] arr = {set1, set2};
        return arr;
    }
}