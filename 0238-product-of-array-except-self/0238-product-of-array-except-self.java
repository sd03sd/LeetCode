class Solution {
    public int[] productExceptSelf(int[] nums) {
        int arr[] = new int[nums.length];
        int leftProd = 1;
        int rightProd = 1;
        for(int i = 0; i<nums.length; i++){
            arr[i] = leftProd;
            leftProd *= nums[i];
        }
        for(int i = nums.length - 1; i>=0; i--){
            arr[i] = arr[i] * rightProd;
            rightProd *= nums[i];
        }
        return arr;
    }
}