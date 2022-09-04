class Solution {
    Set<Integer> result = new HashSet();
    
    private void findNumbers(int currentNum, int currLength, int digit, int n, int k){
        if(digit >9 || digit<0 || currLength>n) return;
        int temp = currentNum;
        currentNum = (currentNum*10) + digit;
        currLength++;
        if(currLength  == n){
            this.result.add(currentNum);
        }
        int[] dx = {-k, k};
        for(int i=0;i<2;i++){
            this.findNumbers(currentNum, currLength, digit+dx[i], n, k);
        }
        currLength--;
        currentNum = temp;
    }
    
    public int[] numsSameConsecDiff(int n, int k) {
        
        for(int i=1;i<=9;i++){
            this.findNumbers(i, 1, i+k, n, k);
            this.findNumbers(i, 1, i-k, n, k);
        }
        int[] finalResult = new int[this.result.size()];
        int j=0;
        for(int num: this.result){
            finalResult[j++] = num;
        }
        
        return finalResult;
        
    }
}