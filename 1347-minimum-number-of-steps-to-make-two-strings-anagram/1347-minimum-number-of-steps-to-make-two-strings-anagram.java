class Solution {
    public int minSteps(String s, String t) {
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for(char ch : s.toCharArray()){
            freq1[ch-'a']++;
        }
        for(char ch : t.toCharArray()){
            freq2[ch-'a']++;
        }
        int sum = 0;
        for(int i = 0; i < freq1.length; i++){
            sum += Math.max(0, (freq1[i] - freq2[i]));
        }
        return sum;
    }
}