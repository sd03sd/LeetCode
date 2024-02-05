class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for(int i = 0; i < 32; i++) {
            int countOdd = 0, countEven = 0;
            for(int j = 0; j < nums.length; j++) {
                if(((nums[j] >> i) & 1) == 1) {
                    countOdd++;
                } else {
                    countEven++;
                }
            }
            if(countOdd % 3 == 1) {
                ans |= (1 << i);
            }
        }
        return ans;
    }
}