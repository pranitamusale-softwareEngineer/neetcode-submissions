class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequecy = new HashMap<>();
        int[] result;
        for(int num: nums) {
            frequecy.put(num, frequecy.getOrDefault(num,0)+1);
        }
        //put indices as freq in bucket with list of numbers as their value.
        List<Integer>[] buckets = new List[nums.length+1];//adding 1 because index = frequecy
        //freq can not be 0
        for(int num: frequecy.keySet()){
            int f = frequecy.get(num);
            if(buckets[f]==null){
                buckets[f] = new ArrayList<>();
            }
            buckets[f].add(num);
        }

        //start from end of buckets, indexing from last to get max freq
        int[] res = new int[k];
        int idx=0;
        for(int i=buckets.length-1; i>=0 && idx<k; i--){
            if(buckets[i]!=null) {
                for(int num: buckets[i]) {
                    res[idx++] = num;
                    if(idx==k) break;
                }
            }
        }
        return res;
        
    }
}
