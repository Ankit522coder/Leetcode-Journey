class Solution {
    public void nextPermutation(int[] A) {

        // 1st step: Find the pivot
        int pivot = -1;
        int n = A.length;

        for (int i = n - 2; i >= 0; i--) {
            if (A[i] < A[i + 1]) {
                pivot = i;
                break;
            }
        }

        // If no pivot is found, array is in descending order
        if (pivot == -1) {
            reverse(A, 0, n - 1);
            return;
        }

        // 2nd step: Find the next larger element
        for (int i = n - 1; i > pivot; i--) {
            if (A[i] > A[pivot]) {
                swap(A, i, pivot);
                break;
            }
        }

        // 3rd step: Reverse the elements after pivot
        reverse(A, pivot + 1, n - 1);
    }

    // Swap two elements
    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    // Reverse array from left to right
    private void reverse(int[] A, int left, int right) {
        while (left < right) {
            swap(A, left, right);
            left++;
            right--;
        }
    }
}