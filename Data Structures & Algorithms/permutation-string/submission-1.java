class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n=s1.length();
        int m=s2.length();
        if(n>m) {
            return false;
        }
        
        int left=0, matches=0;
        int[] freqS1 = new int[26];
        int[] windowCount = new int[26];
        for(int i=0;i<n;i++) {
            freqS1[s1.charAt(i)-'a']++;
            windowCount[s2.charAt(i)-'a']++;
        }
        if(Arrays.equals(freqS1,windowCount)) return true;
        /*
        for(int i=0;i<26;i++) {
            if(freqS1[i]==windowCount[i]) matches++;
        }
        if(matches==26) return true;
        */
        //
        for(int right=n;right<m;right++){
            windowCount[s2.charAt(left)-'a']--;
            left++;
            windowCount[s2.charAt(right)-'a']++;
            if(Arrays.equals(freqS1,windowCount)) return true;
            /*int addChar = s2.charAt(right)-'a';
            int removeChar = s2.charAt(left)-'a';
            windowCount[addChar]++;
            if(windowCount[addChar]==freqS1[addChar]) {
                matches++;
            } else if(windowCount[addChar]==freqS1[addChar]+1) {
                matches--;
            }
            windowCount[removeChar]--;
            if(windowCount[removeChar]==freqS1[removeChar]) {
                matches++;
            } else if(windowCount[removeChar]==freqS1[removeChar]-1) {
                matches--;
            }
            left++;
            if(matches==26) return true;*/
        }
        return false;
            
    }
}
