class Solution {

    public long minInversionCount(int[] nums, int k) {
        int n = nums.length;

        // Coordinate compression
        int[] sorted = nums.clone();
        java.util.Arrays.sort(sorted);

        int[] rank = new int[n];

        for (int i = 0; i < n; i++) {
            rank[i] = java.util.Arrays.binarySearch(sorted, nums[i]) + 1;
        }

        FenwickTree bit = new FenwickTree(n);

        long inversions = 0;

        // Build the first window
        for (int i = 0; i < k; i++) {
            // Number of previous elements greater than nums[i]
            int greater = i - bit.query(rank[i]);

            inversions += greater;
            bit.add(rank[i], 1);
        }

        long answer = inversions;

        // Slide the window
        for (int left = 0; left + k < n; left++) {

            int removeRank = rank[left];

            // Remove nums[left]
            // Since it is the leftmost element,
            // count elements smaller than it.
            long smaller = bit.query(removeRank - 1);

            inversions -= smaller;

            bit.add(removeRank, -1);

            // Add the new element at the right
            int right = left + k;
            int addRank = rank[right];

            // Current window size is k - 1.
            // Count elements greater than nums[right].
            long greater = (k - 1) - bit.query(addRank);

            inversions += greater;

            bit.add(addRank, 1);

            answer = Math.min(answer, inversions);
        }

        return answer;
    }

    // Fenwick Tree / Binary Indexed Tree
    class FenwickTree {

        int[] tree;

        FenwickTree(int n) {
            tree = new int[n + 1];
        }

        void add(int index, int value) {
            while (index < tree.length) {
                tree[index] += value;
                index += index & -index;
            }
        }

        int query(int index) {
            int sum = 0;

            while (index > 0) {
                sum += tree[index];
                index -= index & -index;
            }

            return sum;
        }
    }
}