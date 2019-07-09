/*
10. Regular Expression Matching
Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.
The matching should cover the entire input string (not partial).

Note:

s could be empty and contains only lowercase letters a-z.
p could be empty and contains only lowercase letters a-z, and characters like . or *.
Example 1:

Input:
s = "aa"
p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".
Example 2:

Input:
s = "aa"
p = "a*"
Output: true
Explanation: '*' means zero or more of the precedeng element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
Example 3:

Input:
s = "ab"
p = ".*"
Output: true
Explanation: ".*" means "zero or more (*) of any character (.)".
Example 4:

Input:
s = "aab"
p = "c*a*b"
Output: true
Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore it matches "aab".
Example 5:

Input:
s = "mississippi"
p = "mis*is*p*."
Output: false
* */
public class Solution0010 {
    public static boolean isMatch(String s, String p) {
        boolean dpCache[][]=new boolean[s.length()+1][p.length()+1];
        dpCache[s.length()][p.length()]=true;
        for(int i=s.length();i>=0;i--){
            for(int j=p.length()-1;j>=0;j--){
                boolean match=i<s.length()&&(p.charAt(j)==s.charAt(i)||p.charAt(j)=='.');
                if(j+1<p.length()&&p.charAt(j+1)=='*'){
                    dpCache[i][j]=dpCache[i][j+2]||match&&dpCache[i+1][j];
                }else {
                    dpCache[i][j]=match&&dpCache[i+1][j+1];
                }
            }
        }
        return dpCache[0][0];
    }

    public static void main(String[] args){
        String s="aaa",p="a*";
        System.out.println(isMatch(s,p));
    }
}
