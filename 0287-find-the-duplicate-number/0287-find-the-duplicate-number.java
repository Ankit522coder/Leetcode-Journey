
class Solution {
   public int findDuplicate(int[] nums) {
       int n = nums.length;


       // Initialize slow and fast pointers
       int slow = nums[0];
       int fast = nums[0];


       // Move slow by 1 step and fast by 2 steps until they meet
       while (true) {
           slow = nums[slow];
           fast = nums[nums[fast]];
          
           if (slow == fast) {
               break;
           }
       }


       // Reset slow to the start and move both pointers at the same speed
       slow = nums[0];
       while (slow != fast) {
           slow = nums[slow];
           fast = nums[fast];
       }
      
       return slow;
   }
}
