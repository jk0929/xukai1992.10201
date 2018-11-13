package ceshi;


/**
 * @Author: xk
 * @Date: 2018/9/28
 * @Version 1.0
 * 原矩阵的纵下标转变为新矩阵的横下标；
 * 原矩阵的横下标转变为新矩阵的纵下标，并且顺序相反。
 */
public class demo2 {
  public static void main(String[] args){
      int[][] arr = new int[][]{{1,2},{4,5}};
      arr = change(arr);
      for (int i=0;i<arr.length;i++){
          int n = 0;
          for (int j=0;j<arr[0].length;j++){
              System.out.print(arr[i][j]+" ");
              n++;
              if (n == arr[0].length){
                  System.out.println();
              }
          }
      }
  }
    public static int[][] change(int[][] matrix){
      int [][]temp=new int[matrix[0].length][matrix.length];
      int dst=matrix.length-1;
      for(int i=0;i<matrix.length;i++,dst--){
          for(int j=0;j<matrix[0].length;j++){
              temp[j][dst]=matrix[i][j];
          }
      }
      return temp;
  }
}
