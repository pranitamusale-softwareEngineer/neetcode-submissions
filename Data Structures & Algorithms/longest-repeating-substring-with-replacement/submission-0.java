class Solution {
    public int characterReplacement(String s, int k) {
        int left=0, maxLength=0;
        int[] count = new int[26];
        int maxFreq=0;
        for(int right=0; right<s.length();right++) {
            char c = s.charAt(right);
            count[c-'A']++;
            maxFreq = Math.max(maxFreq,count[c-'A']);
            if((right-left+1) - maxFreq > k) {
                count[s.charAt(left)-'A']--;
                left++;
            }
            maxLength = Math.max(maxLength, (right-left+1));
        }
        return maxLength;
    }
}
