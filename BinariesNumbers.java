
public class BinariesNumbers {

    public static void printBin(int binNum){
        System.out.println(Integer.toBinaryString(binNum));
    }

    public static int doBinNum() {
        int a = 0b0;
        int b = 0b1;
        int carry = 0;
        int sumFinal = 0;
        int sumAux = 0;


        for (int j = 0; j < 16; j++) {
            for (int i = 0; i < 5; i++) {
                int bitA = (a >> i) & 1;
                int bitB = (b >> i) & 1;
                sumAux = bitA ^ bitB ^ carry;
                carry = (bitA & bitB) | (bitB & carry) | (carry & bitA);
                sumFinal |= (sumAux << i);
            }
            BinariesNumbers.printBin(sumFinal);
            a = sumFinal;
            sumFinal = 0;
        }
        return sumFinal;
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