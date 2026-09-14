class Solution {
   public int[] maxSlidingWindow(int[] nums, int k) {
       int n = nums.length;
       List<Integer> result = new ArrayList<>();
       Deque<Integer> dq = new LinkedList<>();
      
       // Process first k elements
       dq.addLast(0);
       for (int i = 1; i < k; i++) {
           while (!dq.isEmpty() && nums[i] >= nums[dq.getLast()]) {
               dq.removeLast();
           }
           dq.addLast(i);
       }
      
       result.add(nums[dq.getFirst()]);
      
       // Process remaining elements
       for (int i = k; i < n; i++) {
           // Remove elements out of window
           if (i - dq.getFirst() >= k) {
               dq.removeFirst();
           }
          
           // Remove smaller elements
           while (!dq.isEmpty() && nums[i] >= nums[dq.getLast()]) {
               dq.removeLast();
           }
          
           dq.addLast(i);
           result.add(nums[dq.getFirst()]);
       }
      
       // Convert list to array
       int[] resArr = new int[result.size()];
       for (int i = 0; i < result.size(); i++) {
           resArr[i] = result.get(i);
       }
      
       return resArr;
   }
}

