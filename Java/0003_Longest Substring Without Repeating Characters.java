import java.util.ArrayList;
import java.util.List;

/*
3. Longest Substring Without Repeating Characters

Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
*/
public class Solution0003 {
    public static int lengthOfLongestSubstring(String s) {
        char[] chars=s.toCharArray();
        int length=0;

        for(int i=0;i<chars.length;i++){

            List<Character> list = new ArrayList<>();
            for (int j = i; j < chars.length; j++) {
                boolean repeat = false;
                for (int q = 0; q < list.size(); q++) {
                    if (list.get(q) == chars[j]) {
                        repeat = true;
                    }
                }
                if (!repeat) {
                    list.add(chars[j]);
                } else {
                    break;
                }
            }

            if(list.size()>length){
                length=list.size();
            }
        }

        return length;
    }

    public static void main(String[] args){
        String str="abdabcbb";
        System.out.println(lengthOfLongestSubstring(str));
    }
}
