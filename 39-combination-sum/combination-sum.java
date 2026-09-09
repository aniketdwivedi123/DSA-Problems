class Solution {

    static void solve(int[] candidates, int target, int index,
                      List<List<Integer>> ans, List<Integer> output) {

        // Base case: target becomes 0
        if (target == 0) {
            ans.add(new ArrayList<>(output));
            return;
        }

        // Base case: index goes out of array
        if (index >= candidates.length) {
            return;
        }

        // Base case: target becomes negative
        if (target < 0) {
            return;
        }

        // INCLUDE
        output.add(candidates[index]);

        // index remains same because an element can be used multiple times
        solve(candidates, target - candidates[index],
              index, ans, output);

        // Backtracking
        output.remove(output.size() - 1);

        // EXCLUDE
        solve(candidates, target, index + 1,
              ans, output);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> output = new ArrayList<>();

        solve(candidates, target, 0, ans, output);

        return ans;
    }
}