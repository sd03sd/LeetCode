class Solution {
    public int countHomogenous(String s) {
        int mod = 1000000007;
        int length = 1;
        int result = 1;
        for(int i=1; i < s.length(); i++){
            if(s.charAt(i)==s.charAt(i-1)){
                length++;
            }else{
                length = 1;
            }
            result = (result + length)%mod;
        }
        return result;
    }
}