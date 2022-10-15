/*
Write a method to replace all spaces in a string with '%20'.
You may assume the string has sufficient space at the end to
hold the additional characters, and that you are given the 
'true' length of the string.
Example: 
Input: "My name is Beth      ", 15
Output: My%20name%20is%20Beth
*/

public class URLify
{
    static char[] replacementChars = {'%', '2', '0'};
    static char[] invertedChars = {'0', '2', '%'};

    public static int calculateSpaces(String input) {
        int count = 0;
        char[] mod = input.toCharArray(); 
        
        int j = mod.length-1;
        while(mod[j] == ' '){
            count++;
            j--;
        }
        return count/2;
    }
    
    // StringBuilder Solution
    public static String sbReplace(String input, int numSpaces) {
        char[] mod = input.toCharArray();
        StringBuilder sb = new StringBuilder(mod.length);
        for (int i = 0; i < mod.length; i++) {
            if (mod[i] != ' ') {
                sb.append(mod[i]);
            } else {
                if(numSpaces == 0){
                    break;
                }
                sb.append(replacementChars);
                numSpaces--;
            }
        }
        return sb.toString();
    }
    
    // In-place Solution
    public static String inplaceReplace(String input, int trueLength) {
        char[] mod = input.toCharArray();
        int endOfString = mod.length-1;
        
        for (int i = trueLength-1; i >= 0; i--) {
            if (mod[i] != ' ') {
                mod[endOfString] = mod[i];
                endOfString--;
            } else {
                for(char j : invertedChars){
                    mod[endOfString] = j;
                    endOfString--;              
                }
            }
        }
        return new String(mod);
    }
   
    public static void main(String[] args)
    {
        String input = "My name is Beth      ";
        System.out.println("Input: " + input);
        
        //Solution 1: StringBuilder
        int numSpaces = calculateSpaces(input);
        System.out.println("StringBuilder output: " + sbReplace(input,numSpaces));   
        
        //Solution 2: In place manipulation of char[]
        System.out.println("In place output: " + inplaceReplace(input,15));
    }
}
