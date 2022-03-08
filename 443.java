class Solution {
    private char[] compString(char ch, int count){
        if(count == 1) return new char[] {ch};
        StringBuilder sb = new StringBuilder();
        sb.append(ch).append(count);
        return sb.toString().toCharArray();
    }
    public int compress(char[] chars) {
        int start = 0;
        int end = 1;
        char prev = chars[0];
        int count=1;
        while(end< chars.length){
            if(chars[end]!=prev){
                char[] comp = this.compString(prev, count);
                for(char ch: comp){
                    chars[start++] = ch;
                }
                count=0;
            }
            prev = chars[end];
            end++;
            count++;
        }
        char[] tail = this.compString(prev, count);
        for(char ch: tail){
            chars[start++] = ch;
        }
        return start;
    }
}