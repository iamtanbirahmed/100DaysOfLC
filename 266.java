class Solution {
    public boolean canPermutePalindrome(String s) {
        HashMap<Character, Integer> count = new HashMap();
        for(char ch: s.toCharArray()){
            if(count.containsKey(ch) == false){
                count.put(ch, 1);
                continue;
            }
            count.put(ch, count.get(ch)+1);
        }
        int oddCount = 0;
        for(Character ch: count.keySet()){
            oddCount+=(count.get(ch)%2);
        }
        return oddCount<=1;
    }
}