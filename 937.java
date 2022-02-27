class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (s1, s2)->{
           
            String[] split1 = s1.split(" ",2);
            String[] split2 = s2.split(" ",2);
            
            boolean digit1 = Character.isDigit(split1[1].charAt(0));
            boolean digit2 = Character.isDigit(split2[1].charAt(0));
            
            // both are logs
            if(!digit1 && !digit2){
                if(split1[1].equals(split2[1])){
                    return split1[0].compareTo(split2[0]);
                }
                return split1[1].compareTo(split2[1]);
            }else if( digit1 && !digit2){
                return 1;
            }else if( !digit1 && digit2){
                return -1;
            }else{
                return 0;
            }            
        });
        
        return logs;
    }
}