class FreqStack {
    
    private Map<Integer, Integer> freq;
    private Map<Integer, Deque<Integer>> freqMap;
    private int maxFreq;

    public FreqStack() {
        this.freq = new HashMap();
        this.freqMap = new HashMap();
        this.maxFreq = 0;
    }
    
    public void push(int val) {
        this.freq.put(val, this.freq.getOrDefault(val, 0)+1);
        int frequency = this.freq.get(val);
        if(this.freqMap.containsKey(frequency) == false){
            this.freqMap.put(frequency, new LinkedList<Integer>());
        }
        this.freqMap.get(frequency).push(val);
        this.maxFreq = Math.max(frequency, this.maxFreq);
    }
    
    public int pop() {
        int val = this.freqMap.get(this.maxFreq).pop();
        this.freq.put(val, this.freq.get(val)-1);
        if(this.freqMap.get(this.maxFreq).size() == 0){
            this.maxFreq--;
        }
        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */