

import java.util.Map;
import java.util.HashMap;
public class Anagram{
  /*isAnagram checks if two strings s1, s2 are anagrams. Complexity O(n), space - O(1) assuming only ascii*/
  public static boolean isAnagram(String s1,String s2){
    if(!s1.isEmpty() && !s2.isEmpty()){
      Map<Character,Integer> charCounter = new HashMap<Character,Integer>();
      char[] s1Chars = s1.toLowerCase().toCharArray();
       for(int i=0;i<s1Chars.length;i++){
        Integer count = charCounter.get(s1Chars[i]);
        if(count == null)
          count=0;
        count++;
        charCounter.put(s1Chars[i],count);
       }
      char[] s2Chars = s2.toLowerCase().toCharArray();
      for(int i=0;i<s2Chars.length;i++){
        Integer count = charCounter.get(s2Chars[i]);
        if(count == null)
          return false;
        count--;
        if(count < 0)
          return false;
        charCounter.put(s2Chars[i],count);
       }
       for(Character c:charCounter.keySet()){
        if(charCounter.get(c)!=0)
          return false;
       }
       return true;
    }
    return false;
  }
  public static void main(String[] args){
    System.out.println(isAnagram("aba","baa"));
  }
}
