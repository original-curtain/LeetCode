import b.k.L;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
15. 3Sum
Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
Find all unique triplets in the array which gives the sum of zero.

Note:

The solution set must not contain duplicate triplets.

Example:

Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
*/
public class Solution0015 {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        if(nums.length==0) return result;
        Arrays.sort(nums);

        for (int left=0;nums[left]<=0&&left<nums.length-2;left++){
            if(left>0&&nums[left]==nums[left-1]) continue;
            for (int right=nums.length-1;nums[right]>=0&&right>=left+2;right--){
                if(right<nums.length-1&&nums[right]==nums[right+1]) continue;
                int midValue=-(nums[left]+nums[right]);
                if(midValue<=nums[right]&&midValue>=nums[left]){
                    int start=left+1,end=right-1;
                    while (start<=end){
                        int mid=(start+end)/2;
                        if(nums[mid]<midValue){
                            start=mid+1;
                        }else if(nums[mid]>midValue){
                            end=mid-1;
                        }else {
                            List<Integer> list=new ArrayList<>();
                            list.add(nums[left]);
                            list.add(nums[mid]);
                            list.add(nums[right]);
                            result.add(list);
                            break;
                        }
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args){
        int[] nums={-1,0,1,2,-1,-4};
        List<List<Integer>> lists=threeSum(nums);
        for(int i=0;i<lists.size();i++){
            System.out.println("answer "+(i+1)+": "+lists.get(i));
        }
    }
}
