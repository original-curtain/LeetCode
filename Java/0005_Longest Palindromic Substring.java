import cucumber.api.java.it.Ma;

import java.util.Vector;

/*
5. Longest Palindromic Substring
Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: "cbbd"
Output: "bb"
*/
public class Solution0005 {
    public static String longestPalindrome(String s) {
        String res="@#";
        for(char ch:s.toCharArray()){
            res+=ch;
            res+="#";
        }

        int[] p=new int[res.length()];
        int R=-1,c=-1;
        int ansL=-1,ansC=-1;
        for(int i=1;i<res.length();i++){
            p[i]=R>i? Math.min(p[2*c-i],R-i):1;
            while (i-p[i]>-1&&i+p[i]<res.length()){
                if(res.charAt(i-p[i])==res.charAt(i+p[i])) p[i]++;
                else break;
            }
            if(i+p[i]>R){
                R=i+p[i];
                c=i;
            }
            if(ansL<p[i]){
                ansL=p[i];
                ansC=i;
            }
        }
        return s.substring((ansC-ansL)/2,(ansC-ansL)/2+ansL-1);
    }

    public static void main(String[] args){
        System.out.println(longestPalindrome("sadsadddd"));
    }
}
