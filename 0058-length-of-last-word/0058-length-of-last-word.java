class Solution {
    public int lengthOfLastWord(String s) {
        int count = 0;
        boolean foundNonSpace = false;
        for(int i = s.length() - 1; i >= 0; i--){
            if(s.charAt(i) != ' '){
                foundNonSpace = true;
                count++;
            }else{
                if(foundNonSpace){
                    break;
                }
            }
        }
        return count;
    }
}