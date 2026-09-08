class Solution {

    static void solve(String digits, int index, String[] mapping,
                      List<String> result, StringBuilder output) {

        // Base case
        if (index >= digits.length()) {
            result.add(output.toString());
            return;
        }

        // Get current digit
        int value = digits.charAt(index) - '0';

        // Get mapped characters
        String mappedString = mapping[value];

        // Try each character
        for (int i = 0; i < mappedString.length(); i++) {

            // Choose
            output.append(mappedString.charAt(i));

            // Recursion
            solve(digits, index + 1, mapping, result, output);

            // Backtracking / Undo
            output.deleteCharAt(output.length() - 1);
        }
    }

    public List<String> letterCombinations(String digits) {

        String[] mapping = {
            "", "", "abc", "def", "ghi",
            "jkl", "mno", "pqrs", "tuv", "wxyz"
        };

        List<String> result = new ArrayList<>();

        // Important: empty input
        if (digits.length() == 0) {
            return result;
        }

        StringBuilder output = new StringBuilder();

        solve(digits, 0, mapping, result, output);

        return result;
    }
}