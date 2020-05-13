// 28. Implement strStr()
// Implement strStr().

// Return the index of the first occurrence of needle in haystack, 
// or -1 if needle is not part of haystack.

// Example 1:

// Input: haystack = "hello", needle = "ll"
// Output: 2
// Example 2:

// Input: haystack = "aaaaa", needle = "bba"
// Output: -1
// Clarification:

// What should we return when needle is an empty string? 
// This is a great question to ask during an interview.

// For the purpose of this problem, we will return 0 when needle is an empty string. 
// This is consistent to C's strstr() and Java's indexOf().

#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    int strStr(string haystack, string needle) {
        if(needle.length()==0) return 0;
        if(haystack.length()==0||haystack.length()<needle.length()) return -1;
        int length=needle.length();
        for(int i=0;i<haystack.length()-length+1;i++){
            if(haystack.substr(i,length)==needle){
                return i;
            }
        }
        return -1;
    }
};

int main()
{
    Solution s;
    cout<<s.strStr("a","a");
}