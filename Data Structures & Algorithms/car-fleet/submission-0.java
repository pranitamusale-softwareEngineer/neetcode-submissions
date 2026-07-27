class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n=position.length;
        double cars[][] = new double[n][2]; //store position and time
        for(int i=0; i<n;i++) {
            cars[i][0] = position[i];
            cars[i][1] = (double) (target-position[i])/speed[i];
        }
        //sort on the basis of positions
        Arrays.sort(cars, (a,b) -> Double.compare(b[0], a[0]));
        //store time in stack
        Deque<Double> timeStack = new ArrayDeque<>();
        for(int i=0;i<n;i++) {
            double time = cars[i][1];
            if(timeStack.isEmpty() || time > timeStack.peek()) //time is greater so new fleet generated.
            { timeStack.push(time); }
        }
        return timeStack.size();
    }
}
