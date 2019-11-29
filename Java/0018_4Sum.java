import java.util.*;

/*
18.4Sum
Given an array nums of n integers and an integer target,
are there elements a, b, c, and d in nums such that a + b + c + d = target?
Find all unique quadruplets in the array which gives the sum of target.

Note:

The solution set must not contain duplicate quadruplets.

Example:

Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.

A solution set is:
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]
* */
public class Solution0018 {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length != 0) {
            Arrays.sort(nums);
            for(int i=0;i<nums.length;i++){
                if(i>0&&nums[i]==nums[i-1])continue;

                int newTarget=target-nums[i];
                int[] newNums=new int[nums.length-1];
                for(int j=0,p=0;j<nums.length;j++){
                    if(j!=i){
                        newNums[p]=nums[j];
                        p++;
                    }
                }

                List<List<Integer>> threes=new ArrayList<>();
                for (int left=0;left<newNums.length-2;left++){
                    if(left>0&&newNums[left]==newNums[left-1]) continue;
                    for (int right=newNums.length-1;right>=left+2;right--){
                        if(right<newNums.length-1&&newNums[right]==newNums[right+1]) continue;
                        int midValue=newTarget-(newNums[left]+newNums[right]);
                        if(midValue<=newNums[right]&&midValue>=newNums[left]){
                            int start=left+1,end=right-1;
                            while (start<=end){
                                int mid=(start+end)/2;
                                if(newNums[mid]<midValue){
                                    start=mid+1;
                                }else if(newNums[mid]>midValue){
                                    end=mid-1;
                                }else {
                                    List<Integer> list=new ArrayList<>();
                                    list.add(newNums[left]);
                                    list.add(newNums[mid]);
                                    list.add(newNums[right]);
                                    threes.add(list);
                                    break;
                                }
                            }
                        }
                    }
                }

                for(List<Integer> list:threes){
                    list.add(nums[i]);
                    Collections.sort(list);
                }
                result.addAll(threes);
            }
            result=new ArrayList<>(new HashSet<>(result));
        }
        return result;
    }

    public static void main(String[] args) {
        //int[] nums = {1, 0, -1, 0, -2, 2};
        int[] nums = {-4,-3, -1, 1, 1, 1,2};
        System.out.println(fourSum(nums, 0));
    }
}
