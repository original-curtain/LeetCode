/*
7. Reverse Integer
Given a 32-bit signed integer, reverse digits of an integer.

Example 1:

Input: 123
Output: 321
Example 2:

Input: -123
Output: -321
Example 3:

Input: 120
Output: 21
Note:
Assume we are dealing with an environment
which could only store integers within the 32-bit signed integer range: [−2^31,  2^31 − 1].
For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
*/
public class Solution0007 {
    public static int reverse(int x) {
        double min=-Math.pow(2,31);
        double max=Math.pow(2,31)-1;
        if(x<min||x>max) return 0;
        double ans=0;
        while (x!=0){
            int n=x%10;
            x=x/10;
            ans=ans*10+n;
        }
        if(ans<min||ans>max) return 0;
        return (int)ans;
    }

    public static void main(String[] args){
        System.out.println(reverse(1534236469));
    }
}
