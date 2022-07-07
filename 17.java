class Solution {
    
    private List<String> result = new LinkedList();
    private Map<Character, String> map = Map.of(
        '2', "abc", '3' , "def", '4', "ghi",
        '5', "jkl", '6', "mno", '7', "pqrs", 
        '8', "tuv", '9', "wxyz"
    );
    
    private void findCombination(int index, StringBuilder sb, String digits){
        if(sb.length() == digits.length()){
            this.result.add(sb.toString());
            return;
        }
        char[] digitChars = this.map.get(digits.charAt(index)).toCharArray();
        for(char ch: digitChars){
            sb.append(ch);
            this.findCombination(index+1, sb, digits);
            sb.setLength(sb.length()-1);
        }        
    }
    
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return this.result;
        this.findCombination(0, new StringBuilder(), digits);
        return this.result;
    }
}