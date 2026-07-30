class TimeMap {
    private Map<String, List<Pair>> map;
    static class Pair {
        String value;
        int timestamp;
        public Pair(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }

    public TimeMap() {
        this.map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key,new ArrayList<>());
        map.get(key).add(new Pair(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return "";
        List<Pair> values = map.get(key);
        int s=0, e= values.size()-1;
        String result = "";
        while(s<=e) {
            int mid = s+(e-s)/2;
            if(values.get(mid).timestamp <= timestamp) {
                result = values.get(mid).value;
                s = mid+1;
            } else {
                e=mid-1;
            }
        }
        return result;
    }
}
