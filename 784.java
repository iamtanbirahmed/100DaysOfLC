class Solution {
    
    private Set<String> findPermutations(String s, int index){
        Set<String> result;
        if(index>=s.length()){
            result = new HashSet();
            result.add(s);
            return result;
        }else{
            
            result = this.findPermutations(s, index+1);
            Set<String> moreSets = new HashSet();
            for(String str: result){
                StringBuilder sb = new StringBuilder(str);
                char ch = sb.charAt(index);
                //check for lower case
                if(Character.isLowerCase(ch)){
                    sb.setCharAt(index, Character.toUpperCase(ch));
                }else if(Character.isUpperCase(ch)){
                    sb.setCharAt(index, Character.toLowerCase(ch));
                }
                moreSets.add(sb.toString());
            }
            result.addAll(moreSets);
        }
        return result;
        
    }
    
    public List<String> letterCasePermutation(String s) {
        return new ArrayList(this.findPermutations(s,0));
    }
}