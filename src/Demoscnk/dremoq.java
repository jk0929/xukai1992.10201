package Demoscnk;


/**
 * @Author: xk
 * @Date: 2018/9/17
 * @Version 1.0
 */
public class dremoq {
    public static void main(String[] args){
        String[][] array = new String[2][5];
        array[0] = new String[]{"6789","11s9","2m22","240cm","10.5m"};
        array[1] = new String[]{"6790","14s","2m22","240cm","10.5"};
        printStr(array);
        System.out.println("NO   100M   800M   JUMP   BALL");
        for (int i=0;i<array.length;i++){
            for (int j=0;j<array[i].length;j++){
                System.out.print(array[i][j]+"  ");
            }
            System.out.println();
        }
    }
    public static void printStr(String[][] array){
        if(array == null || array.length == 0){
            return;
        }
        for (int i=0;i<array.length;i++){
            for (int j=0;j<array[i].length;j++){
                String str = array[i][j];
                if(j == 0){
                    continue;
                }
                if(j == 1){
                    array[i][j] = getOne(str,12.0,12.9,"s");
                }else if(j == 2){
                    array[i][j] = getOne(str,12.5,2.31,"m");
                }else if(j == 3){
                    array[i][j] = getOne(str,266.0,255.0,"cm");
                }else {
                    array[i][j] = getOne(str,10.4,9.5,"m");
                }
            }
        }
    }
    public static String getOne(String str, double num1, double num2, String string){
        String[] strings = str.split(string);
        Double num;
        Double numTwo;
        if(strings.length == 1){
             num = Double.parseDouble(strings[0]);
             numTwo = 0.0;
        }else {
            num = Double.parseDouble(strings[0]);
             numTwo = Double.parseDouble(strings[1]);
        }
        Double numEnd = num + numTwo*0.1;
        if( numEnd <= num1){
            return "GREAT";
        }else if(numEnd <= num2){
            return "GOOD";
        }else {
            return "BALL";
        }
    }
}
