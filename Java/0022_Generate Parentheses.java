import java.util.ArrayList;
import java.util.List;

/*
22. Generate Parentheses
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
* */
public class Solution0022 {
    public static List<String> generateParenthesis(int n) {
        List<String> r=new ArrayList<>();
        backtrack(r,"",0,0,n);
        return r;
    }

    public static void backtrack(List<String> ans, String cur, int open, int close, int max){
        if (cur.length() == max * 2) {
            ans.add(cur);
            return;
        }

        if (open < max)
            backtrack(ans, cur+"(", open+1, close, max);
        if (close < open)
            backtrack(ans, cur+")", open, close+1, max);
    }

    public static void main(String[] args) {
        List<String> result=generateParenthesis(4);
        if(result==null){
            System.out.println("null");
        }else {
            for(String s:result){
                System.out.println(s);
            }
            System.out.println(result.size());
        }
    }
}
