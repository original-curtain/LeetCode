/*
8. String to Integer (atoi)
Implement atoi which converts a string to an integer.

The function first discards as many whitespace characters as necessary until the first non-whitespace character is found.
Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible,
and interprets them as a numerical value.

The string can contain additional characters after those that form the integral number,
which are ignored and have no effect on the behavior of this function.

If the first sequence of non-whitespace characters in str is not a valid integral number,
or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

If no valid conversion could be performed, a zero value is returned.

Note:

Only the space character ' ' is considered as whitespace character.
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range:
[−2^31,  2^31 − 1]. If the numerical value is out of the range of representable values,
INT_MAX (2^31 − 1) or INT_MIN (−2^31) is returned.
Example 1:

Input: "42"
Output: 42
Example 2:

Input: "   -42"
Output: -42
Explanation: The first non-whitespace character is '-', which is the minus sign.
             Then take as many numerical digits as possible, which gets 42.
Example 3:

Input: "4193 with words"
Output: 4193
Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.
Example 4:

Input: "words and 987"
Output: 0
Explanation: The first non-whitespace character is 'w', which is not a numerical
             digit or a +/- sign. Therefore no valid conversion could be performed.
Example 5:

Input: "-91283472332"
Output: -2147483648
Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer.
             Therefore INT_MIN (−2^31) is returned.
*/
public class Solution0008 {
    public static int myAtoi(String str) {
        double ans=0;
        boolean isStart=true,isMinus=false,isEnd=false;
        for(char c:str.toCharArray()){
            if(c==' '&&isStart) continue;
            if(c=='-'&&isStart) {
                isMinus=true;
                isStart=false;
                continue;
            }
            if(c=='+'&&isStart){
                isMinus=false;
                isStart=false;
                continue;
            }
            switch (c){
                case '0':
                    ans=ans*10+(isMinus?-0:0);
                    isStart=false;
                    break;
                case '1':
                    ans=ans*10+(isMinus?-1:1);
                    isStart=false;
                    break;
                case '2':
                    ans=ans*10+(isMinus?-2:2);
                    break;
                case '3':
                    ans=ans*10+(isMinus?-3:3);
                    isStart=false;
                    break;
                case '4':
                    ans=ans*10+(isMinus?-4:4);
                    isStart=false;
                    break;
                case '5':
                    ans=ans*10+(isMinus?-5:5);
                    isStart=false;
                    break;
                case '6':
                    ans=ans*10+(isMinus?-6:6);
                    isStart=false;
                    break;
                case '7':
                    ans=ans*10+(isMinus?-7:7);
                    isStart=false;
                    break;
                case '8':
                    ans=ans*10+(isMinus?-8:8);
                    isStart=false;
                    break;
                case '9':
                    ans=ans*10+(isMinus?-9:9);
                    isStart=false;
                    break;
                default:
                    isEnd=true;
                    break;
            }
            if(isEnd){
                break;
            }
        }

        if(ans>Integer.MAX_VALUE) return Integer.MAX_VALUE;
        else if(ans<Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return (int)ans;
    }

    public static void main(String[] args){
        System.out.println(myAtoi("2147483648"));
    }
}
