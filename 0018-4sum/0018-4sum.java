class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> ans = new ArrayList<>();

        int n = nums.length;

        // Step 1: Sort
        Arrays.sort(nums);

        // Step 2: Fix first number
        for (int i = 0; i < n - 3; i++) {

            // Skip duplicate i
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // Step 3: Fix second number
            for (int j = i + 1; j < n - 2; j++) {

                // Skip duplicate j
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                // Step 4: Two pointers
                int l = j + 1;
                int k = n - 1;

                while (l < k) {

                    long sum = (long) nums[i] + nums[j]
                             + nums[l] + nums[k];

                    if (sum < target) {
                        l++;
                    }
                    else if (sum > target) {
                        k--;
                    }
                    else {

                        // Found quadruplet
                        ans.add(Arrays.asList(
                            nums[i],
                            nums[j],
                            nums[l],
                            nums[k]
                        ));

                        l++;
                        k--;

                        // Skip duplicate l
                        while (l < k && nums[l] == nums[l - 1]) {
                            l++;
                        }

                        // Skip duplicate k
                        while (l < k && nums[k] == nums[k + 1]) {
                            k--;
                        }
                    }
                }
            }
        }

        return ans;
    }
}