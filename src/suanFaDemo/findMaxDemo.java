package suanFaDemo;

/**
 * Created by Admin on 2018/3/28.
 * 在寻找数组中的最值，数组中元素类型无法确定，需要使用Comparable[] arr作为参数传入；
 * Comparable[] arr1 = arr（使用接口指向它的实现类，compareTo方法调用的是String类的compareTo方法）
 * 注：数组具有协变性；
 */
public class findMaxDemo {

    public static void main(String[] args){
        String [] arr = new String []{"joe","bob","bill","zeke"};
        Comparable[] arr1= arr;
        Comparable maxString = getFindMax(arr);
        System.out.print(maxString);
    }
    private static  Comparable getFindMax(Comparable[] arr1){
        int maxIndex = 0;
        for(int i=1 ; i<arr1.length;i++){
            if(arr1[i].compareTo(arr1[maxIndex])>0){
                maxIndex = i;
            }
        }
        return arr1[maxIndex];
    }
}
