class Solution {
    private boolean isVowel(char c){
        return c == 'a' || c == 'e' || c == 'o' || c == 'i' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U'; 
    }
    public String sortVowels(String s) {
        Map<Character, Integer> count = new HashMap<>();

        for(char c : s.toCharArray()){
            if(isVowel(c)){
                count.put(c, count.getOrDefault(c, 0)+1);
            }
        }

        String sortedVowel = "AEIOUaeiou";
        StringBuilder ans = new StringBuilder();
        int j=0;
        for(char c : s.toCharArray()){
            if(!isVowel(c)){
                ans.append(c);
            }else {
                while(count.get(sortedVowel.charAt(j)) == null || count.get(sortedVowel.charAt(j)) == 0){
                    j++;
                }
                ans.append(sortedVowel.charAt(j));
                count.put(sortedVowel.charAt(j), count.get(sortedVowel.charAt(j))-1);
            }
        }
        return ans.toString();
    }
}