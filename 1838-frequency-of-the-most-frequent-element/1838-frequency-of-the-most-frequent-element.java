class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int maxLength = 0;
        int i = 0, j = 0;
        long sum = 0;

        while (i < nums.length) {
            sum += nums[i];
            while ((long) nums[i] * (i - j + 1) - sum > k) {
                sum -= nums[j];
                j++;
            }
            maxLength = Math.max(maxLength, i - j + 1);
            i++;
        }

        return maxLength;
    }
}