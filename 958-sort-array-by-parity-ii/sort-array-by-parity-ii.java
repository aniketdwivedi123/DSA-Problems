
class Solution {

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int[] sortArrayByParityII(int[] nums) {

        int j = 1;

        for (int i = 0; i < nums.length; i += 2) {

            // Even index should contain even number
            if (nums[i] % 2 != 0) {

                // Find an even number at an odd index
                while (nums[j] % 2 != 0) {
                    j += 2;
                }

                swap(nums, i, j);
            }
        }

        return nums;
    }
}
