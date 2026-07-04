class Solution {
    public int lengthOfLongestSubstring(String s) {
        int length = 0;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            while (right != s.indexOf(s.charAt(right), left)) {
                left++;
            }
            length = Math.max(length, right - left + 1);
        }
        return length;
    }
}