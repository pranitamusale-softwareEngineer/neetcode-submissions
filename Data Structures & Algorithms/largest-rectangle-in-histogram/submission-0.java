class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        int result =0;
        for(int i=0;i <= heights.length;i++) {
            int currHeight = (i == heights.length) ? 0 : heights[i];
            while(!stack.isEmpty() && currHeight < heights[stack.peek()]) {
                int h = heights[stack.pop()];
                int w = stack.isEmpty() ? i : i - stack.peek()-1;
                result = Math.max(result, h*w);
            }
            stack.push(i);
        }
        return result;
    }
}
