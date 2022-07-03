class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()) return false;
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        int len = s1.length();
        for(int i=0;i<len;i++){
            count1[s1.charAt(i)-'a']++;
            count2[s2.charAt(i)-'a']++;
        }
        int left = 0;
        if(Arrays.equals(count1, count2)) return true;
        for(int i=len;i<s2.length();i++){
            count2[s2.charAt(i)-'a']++;            
            count2[s2.charAt(left)-'a']--;
            left++;
            if(Arrays.equals(count1, count2)) 
                return true;
        }
        
        return false;
    }
}