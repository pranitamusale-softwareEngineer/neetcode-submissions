class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> sCountMap = new HashMap<>();
        Map<Character, Integer> tCountMap = new HashMap<>();
        for(int i=0; i<s.length();i++){
            sCountMap.put(s.charAt(i), sCountMap.getOrDefault(s.charAt(i),0)+1);
        }
        for(int i=0; i<t.length();i++){
            tCountMap.put(t.charAt(i), tCountMap.getOrDefault(t.charAt(i),0)+1);
        }
        for(int i=0; i<s.length();i++){
            int vals = sCountMap.getOrDefault(s.charAt(i),0);
            int valt = tCountMap.getOrDefault(s.charAt(i),0);
            if(vals!=valt)
                return false;
        }
        return true;
    }
}
