class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        int maxLeft = 0;
        int minRight = Integer.MAX_VALUE;
        for(int Left : left){
            maxLeft = Math.max(Left, maxLeft);
        }
        for(int Right : right){
            minRight = Math.min(Right, minRight);
        }
        return Math.max(maxLeft, n-minRight);
    }
}