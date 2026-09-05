class Solution {

    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) {
            return false;
        }

        int[] count1 = new int[26];
        int[] count2 = new int[26];

        // Frequency of characters in s1
        for (int i = 0; i < s1.length(); i++) {
            char ch = s1.charAt(i);
            count1[ch - 'a']++;
        }

        // First window of s2
        for (int i = 0; i < s1.length(); i++) {
            char ch = s2.charAt(i);
            count2[ch - 'a']++;
        }

        // Check first window
        if (compareFreq(count1, count2)) {
            return true;
        }

        // Sliding window
        for (int i = s1.length(); i < s2.length(); i++) {

            // Add new character
            char newChar = s2.charAt(i);
            int newCharIndex = newChar - 'a';
            count2[newCharIndex]++;

            // Remove old character
            int oldCharIndex = i - s1.length();
            char oldChar = s2.charAt(oldCharIndex);

            int freqTableIndexOfOldchar = oldChar - 'a';
            count2[freqTableIndexOfOldchar]--;

            // Compare frequencies
            if (compareFreq(count1, count2)) {
                return true;
            }
        }

        return false;
    }

    // Compare two frequency arrays
    private boolean compareFreq(int[] count1, int[] count2) {

        for (int i = 0; i < 26; i++) {
            if (count1[i] != count2[i]) {
                return false;
            }
        }

        return true;
    }
}