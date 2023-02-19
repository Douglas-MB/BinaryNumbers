
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
    public static String changeBinToDec(String num){

       long binNum = 0L;

       if(num.length() <= 1){
           return num;
       }else{
           int startPoint = num.charAt(0);
           int middlePoint = num.charAt(num.length()/2);
           int endPoint = num.charAt(num.length() - 1);
           int checkerSum = startPoint + middlePoint + endPoint;

           if(checkerSum < 144 || checkerSum > 153){
               return "INVALID BINARY NUMBER\n";
           } else {
               for (int i = 0; i < num.length(); i++) {
                   if (num.charAt(i) != '0' && num.charAt(i) != '1'){
                       return "INVALID BINARY NUMBER\n";
                   }else {
                       binNum = (long)(Math.pow(2, num.length()) - 1);
                       if(num.charAt(i) == '0'){
                           binNum = (long) (binNum - Math.pow(2, num.length() -1 - i));
                       }
                   }
               }
           }
       }
        return binNum+"";
    }

}