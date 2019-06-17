/*
6. ZigZag Conversion
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
(you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);
Example 1:

Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"
Example 2:

Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:

P     I    N
A   L S  I G
Y A   H R
P     I
*/
public class Solution0006 {
    public static String convert(String s, int numRows) {
        if(numRows==0) return null;
        if(numRows==1)return s;
        String ans="";
        int l=2*numRows-2;
        for(int i=0;i<numRows&&i<s.length();i++){
            int p=i;
            if(i==0||i==numRows-1){
                do{
                    ans+=s.charAt(p);
                    p+=l;
                }while (p<s.length());
            }else {
                boolean flag=true;
                int firstSep=l-2*i,secondSep=2*i;
                do{
                    ans+=s.charAt(p);
                    p+=flag?firstSep:secondSep;
                    flag=!flag;
                }while (p<s.length());
            }
        }
        return ans;
    }

    public static void main(String[] args){
        System.out.println(convert("a",2));
    }
}
