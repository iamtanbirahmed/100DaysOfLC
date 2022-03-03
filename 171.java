class Solution {
    public int titleToNumber(String columnTitle) {
        int num = 0;
        for(int i=0;i<columnTitle.length();i++){
            int digit = (int) (columnTitle.charAt(columnTitle.length()-1-i) -'A')+1;
            num+= Math.pow(26, i)*digit;
        }
        return num;
    }
}