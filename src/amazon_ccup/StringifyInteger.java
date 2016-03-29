import java.util.*;

class StringifyInteger{
    
  public String stringify(Integer val){
    if(val!=null){
      boolean isNegative = val<0;
      val = Math.abs(val);    
      Stack<Integer> intStack = new Stack<Integer>();     
      while(val>0){
        int rem = val%10;
        val = val/10;
        intStack.push(rem);
      }
      StringBuffer intStringBuffer = new StringBuffer();
      if(isNegative)
        intStringBuffer.append("-");
      String[] intStringValues = new String[]{"0","1","2","3","4","5","6","7","8","9"};
      while(!intStack.empty()){
          intStringBuffer.append(intStringValues[intStack.pop()]);
      }
      return intStringBuffer.toString();  
    }  
    return "";
  }
  public static void main(String[] args){
      StringifyInteger sti = new StringifyInteger();
      String result = sti.stringify(-123);
      System.out.println(result);
      result = sti.stringify(1235);
      System.out.println(result);
  }
}
