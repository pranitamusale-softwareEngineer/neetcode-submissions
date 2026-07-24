class Solution {
    public int evalRPN(String[] tokens) {
        // add all tokens to stack in reverse order of array
        // check if string is sign
        // if not sign then convert string to int
        // add an operate method that returns int as a result
        // if token length is > 1 thne proceed for operate. 
        // pop 2 elements at 1st. and pass to operate function.
        // pass the result as 2nd param to operate method and pop another number from stack along with sign.
        /*if(tokens.length==1) {
            return Integer.parseInt(tokens[0]);
        }*/
        Deque<Integer> tokensStack = new ArrayDeque<>();
        int result = 0;
        for(int i=0; i <tokens.length ;i++) {
            if("+".equals(tokens[i]) || "-".equals(tokens[i]) || "*".equals(tokens[i]) || "/".equals(tokens[i])) {
                int num2 = tokensStack.pop(); //popped 1st second operand
                int num1 = tokensStack.pop(); // first operand
                result = operate(num1, num2, tokens[i]);
                tokensStack.push(result);
            }
            else {
                tokensStack.push(Integer.parseInt(tokens[i]));
            }
        }
        return tokensStack.pop();
    }

    public int operate(int num1, int num2, String op) {
        switch(op){
            case "+": return num1+num2;
            case "-": return num1-num2;
            case "*": return num1*num2;
            case "/": return num1/num2;
            default: throw new IllegalArgumentException("Invalid operator");
        }
    }
}
