import java.util.Arrays;

/*
16. 3Sum Closest
Given an array nums of n integers and an integer target,
find three integers in nums such that the sum is closest to target.
Return the sum of the three integers.
You may assume that each input would have exactly one solution.

Example:

Given array nums = [-1, 2, 1, -4], and target = 1.

The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
* */
public class Solution0016 {
    public static int threeSumClosest(int[] nums, int target) {
        if(nums.length==0) return 0;
        int result=nums[0]+nums[1]+nums[nums.length-1];
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            int start=i+1,end=nums.length-1;
            while (start<end){
                int sum=nums[i]+nums[start]+nums[end];
                if(sum>target){
                    end--;
                }else if(sum<target){
                    start++;
                }else {
                    return target;
                }
                if(Math.abs(sum-target)<Math.abs(result-target)){
                    result=sum;
                }
            }
        }
        return result;
    }

    public static void main(String[] args){
        int[] nums={-4,-1,1,2};
        System.out.println(threeSumClosest(nums,1));
    }
}
