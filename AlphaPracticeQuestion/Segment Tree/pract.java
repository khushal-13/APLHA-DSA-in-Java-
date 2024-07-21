class Solution{
    public static String removeConsecutiveCharacter(String str){
        String s ="";
        s += str.charAt(0);
        for(int i=1;i<str.length();i++){
            if(str.charAt(i)==str.charAt(i-1)){
                continue;
            }            
            s += str.charAt(i);
        }       
        return s;
    }

    public static void main(String[] args) {
        String  s = "aabaa";
        System.out.println(removeConsecutiveCharacter(s));

    }
}