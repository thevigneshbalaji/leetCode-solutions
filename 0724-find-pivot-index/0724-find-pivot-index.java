class Solution {
    public int pivotIndex(int[] nums) {
        int totalsum = 0;
        for(int a : nums ){
            totalsum += a;
        }
        int preSum = 0, rightSum = totalsum;
        for(int i = 0; i < nums.length; i++){
            rightSum = rightSum - nums[i];
            if(preSum == rightSum) return i;
            preSum += nums[i];
        }
        return -1;
    }
}