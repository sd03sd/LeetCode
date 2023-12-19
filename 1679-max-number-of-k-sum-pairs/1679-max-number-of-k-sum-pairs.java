class Solution {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length - 1;
        int count = 0;
        int sum = 0;
        while(i < j){
            sum = nums[i] + nums[j];
            if(sum == k){
                i++;
                j--;
                count++;
            }else if(sum < k){
                i++;
            }else{
                j--;
            }
        }
        return count;
    }
}