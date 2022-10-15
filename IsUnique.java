/*
Implement an algorithm to determine if a string has all unique characters.
Assumptions made: I defined unique characters in practical English usage,
not by ASCII. Therefore, 'A' is not unique from 'a' and whitespace is not
a character. For example, "Aa" would not be unique and "A B C" would.
*/

import java.util.*;

public class IsUnique
{
    public static HashSet<Character> seenChars = new HashSet<>();
    
    public static boolean isUnique(char letter) {
        if (seenChars.contains(letter)) return false;
        return true;
    }
    
    public static boolean uniqueStringCheck(String data){
        data = data.replaceAll(" ", "");
        data = data.toLowerCase();
        
        char[] chars = data.toCharArray();
        for(char a : chars){
            if(isUnique(a)){
                seenChars.add(a);
            }
            else {
                seenChars.clear();
                return false;    
            }
        }
        seenChars.clear();
        return true;
    }

    public static void main(String[] args)
    {
        System.out.println(uniqueStringCheck("cat"));  //true      
        System.out.println(uniqueStringCheck("caat"));  //false
        System.out.println(uniqueStringCheck("my cat is fox"));  //true
        System.out.println(uniqueStringCheck("My cat is A fox"));  //false
    }
}
