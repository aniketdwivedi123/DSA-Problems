class Solution {
    public int percentageLetter(String s, char letter) {
        int freq = 0;
        for (char c : s.toCharArray()){
            if(c== letter) freq++;
        }
        return freq * 100/s.length();
        
    }
}