/*
14. Longest Common Prefix
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:

Input: ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
Note:

All given inputs are in lowercase letters a-z.
* */
public class Solution0014 {
    public static String longestCommonPrefix(String[] strs) {
        if(strs.length==0||strs==null) return "";
        for(int i=0;i<strs[0].length();i++){
            for(int j=1;j<strs.length;j++){
                if(i==strs[j].length()||strs[j].charAt(i)!=strs[0].charAt(i)){
                    return strs[0].substring(0,i);
                }
            }
        }
        return strs[0];
    }

    public static void main(String[] args){
        String[] strs={"a"};
        System.out.println(longestCommonPrefix(strs));
    }
}
