                                                            class Solution {
    public boolean isValid(String s) {
        Stack<Character> brackets = new Stack<>();
        Map<Character, Character> bracketsMap = new HashMap<Character, Character>();
        bracketsMap.put('}', '{');
        bracketsMap.put(')', '(');
        bracketsMap.put(']', '[');

        for(char c: s.toCharArray()){
            if(c == '{' || c == '[' || c == '(') {
                brackets.push(c);
            } else if(bracketsMap.containsKey(c)){
                if(brackets.isEmpty() || brackets.pop() != bracketsMap.get(c)) {
                    return false;
                }
            }
        }
        return brackets.isEmpty();
    }
}
