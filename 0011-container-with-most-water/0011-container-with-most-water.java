class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length-1, maxArea = 0, minHeight;

        while(left < right){
            minHeight = Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, (right - left) * minHeight);
            while(left < right && height[left] <= minHeight){
                left++;
            }
            while(left < right && height[right] <= minHeight){
                right--;
            }
        }
        return maxArea;
    }
}