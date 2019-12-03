import java.util.Stack;

/*
20. Valid Parentheses
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.

Example 1:

Input: "()"
Output: true
Example 2:

Input: "()[]{}"
Output: true
Example 3:

Input: "(]"
Output: false
Example 4:

Input: "([)]"
Output: false
Example 5:

Input: "{[]}"
Output: true
* */
public class Solution0020 {
    public static boolean isValid(String s) {
        boolean result=true,stop=false;
        Stack stack=new Stack();

        if(s==null||s.isEmpty())return result;
        for(char ch:s.toCharArray()){
            switch (ch){
                case '{':
                case '[':
                case '(':
                    stack.push(ch);
                    break;
                case '}':
                    if(stack.empty()){
                        result=false;
                        stop=true;
                    }else {
                        char outCh=(char)stack.pop();
                        if(outCh!='{'){
                            result=false;
                            stop=true;
                        }
                    }
                    break;
                case ']':
                    if(stack.empty()){
                        result=false;
                        stop=true;
                    }else {
                        char outCh=(char)stack.pop();
                        if(outCh!='['){
                            result=false;
                            stop=true;
                        }
                    }
                    break;
                case ')':
                    if(stack.empty()){
                        result=false;
                        stop=true;
                    }else {
                        char outCh=(char)stack.pop();
                        if(outCh!='('){
                            result=false;
                            stop=true;
                        }
                    }
                    break;
            }
            if(stop){
                break;
            }
        }
        if(!stack.empty()) result=false;
        return result;
    }

    public static void main(String[] args){
        System.out.println(isValid("()[]{}"));
    }
}
