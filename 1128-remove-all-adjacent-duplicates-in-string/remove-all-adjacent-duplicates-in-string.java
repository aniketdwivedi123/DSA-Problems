class Solution {
    public String removeDuplicates(String s) {
        StringBuilder ans = new StringBuilder();
        
        for(int i = 0; i<s.length(); i++){
            char ch = s.charAt(i);

            //compare ans k rightmost charcter current charecter se 

            if (ans.length()>0 && ans.charAt(ans.length()-1)== ch){
                ans.deleteCharAt(ans.length()-1);

            }
            else{
                ans.append(ch);
            }
        }
     return ans.toString();
        
    }
}