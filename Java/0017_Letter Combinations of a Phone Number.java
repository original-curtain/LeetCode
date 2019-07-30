import java.util.*;

/*
17. Letter Combinations of a Phone Number
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.



Example:

Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:

Although the above answer is in lexicographical order, your answer could be in any order you want.
* */
public class Solution0017 {
    public static List<String> letterCombinations(String digits) {
        Map<String,String> data=new HashMap<>();
        data.put("2","abc");
        data.put("3","def");
        data.put("4","ghi");
        data.put("5","jkl");
        data.put("6","mno");
        data.put("7","pqrs");
        data.put("8","tuv");
        data.put("9","wxyz");
        List<String> result=new ArrayList<>();
        while (digits.length()!=0){
            String digit=digits.substring(0,1);
            String letters=data.get(digit);
            if(result.size()!=0){
                int num=result.size();
                while (num>0){
                    String pre=result.get(0);
                    result.remove(0);
                    num--;
                    for(int j=0;j<letters.length();j++){
                        String letter=letters.substring(j,j+1);
                        result.add(pre+letter);
                    }
                }
            }else {
                for(int i=0;i<letters.length();i++){
                    String letter=letters.substring(i,i+1);
                    result.add(letter);
                }
            }
            digits=digits.substring(1);
        }
        return result;
    }

    public static void main(String[] args){
        System.out.println(letterCombinations("224"));
    }
}
