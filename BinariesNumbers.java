
public class BinariesNumbers {

  public void getBinNum(){
      int carry = 0b0000;
      int x = 0b0000;
      int y = 0b0001;
      int sum = 0b0000;
      int res = 0b0000;

      int cnt = 0;

      while (cnt < 5){
              while (y != 0) {
                  sum = x ^ y; // 1 0 10 0
                  carry = x & y << 1; // 0 10 0 100
                  res = sum | carry; // 1 10 10 100

                  System.out.println(Integer.toBinaryString(res));

                  x = res; // 1 10 10
                  y = sum; // 1 0 10
              }
          cnt++;
      }
  }
  public String doBinNum(String num){ //do a check if the digits are only 0 or 1
      String numStr = num+"";
       long binNum = 0L;

       if(numStr.length() <= 1){
           return num+"";
       }else{
           binNum = (long)(Math.pow(2, numStr.length()) - 1);

           for (int i = numStr.length() -1 ; i > 0; i--) {
               if(numStr.charAt(i) == '0'){
                   binNum = (long) (binNum - Math.pow(2, numStr.length() -1 - i));
               }
           }
       }
        return binNum+"";
    }

}