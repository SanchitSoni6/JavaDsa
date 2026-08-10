class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder mer = new StringBuilder();
        int maxLen = Math.max(word1.length(), word2.length());
        
        for (int i = 0; i < maxLen; i++) {
            if (i < word1.length()) {
                mer.append(word1.charAt(i));
            }
            if (i < word2.length()) {
                mer.append(word2.charAt(i));
            }
        }
        
        return mer.toString();
    }
}