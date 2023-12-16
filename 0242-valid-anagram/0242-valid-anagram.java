class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        int freq[] = new int[26];
        for(char chs : s.toCharArray()){
            freq[chs - 'a']++;
        }
        for(char cht : t.toCharArray()){
            freq[cht - 'a']--;
        }

        for(int num : freq){
            if(num != 0){
                return false;
            }
        }
        return true;
    }
}