class TwoSum {

    ArrayList<Integer> nums;
    boolean isSorted;
    public TwoSum() {
        this.nums = new ArrayList();
        this.isSorted = false;
    }
    
    public void add(int number) {
        this.nums.add(number);
        this.isSorted = false;
    }
    
    public boolean find(int value) {
        if(isSorted == false){
            Collections.sort(this.nums);
            this.isSorted = true;
        }
        int left = 0;
        int right = this.nums.size()-1;
        while(left<right){
            int twoSum = this.nums.get(left)+this.nums.get(right);
            
            if(twoSum>value){
                right-=1;
            }else if(twoSum<value){
                left+=1;
            }else{
                return true;
            }        
        }
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */