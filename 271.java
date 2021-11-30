public class Codec {

    private String delimeter; 
    
    public Codec(){
        char nonASCII = 257;
        this.delimeter = String.valueOf(nonASCII);
    }

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder encodedString = new StringBuilder();
        strs.forEach(s->{
           
            encodedString.append(s);
            encodedString.append(this.delimeter);
            
        });
        return encodedString.toString().substring(0, encodedString.length()-1);
        
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        String[] strs = s.split(this.delimeter, -5);
        return Arrays.asList(strs);
        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));