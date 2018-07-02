package suanFaDemo;

/**
 * Created by Admin on 2018/4/4.
 * 检验二叉查询树一些操作；
 */
public class main {
    public static void main(String[] args){
        BinarySearchTree.BinaryNode leftLeft = new BinarySearchTree.BinaryNode(1);
        BinarySearchTree.BinaryNode leftRight = new BinarySearchTree.BinaryNode(3);
        BinarySearchTree.BinaryNode left = new BinarySearchTree.BinaryNode(2,leftLeft,leftRight);

        BinarySearchTree.BinaryNode right = new BinarySearchTree.BinaryNode(8);

        BinarySearchTree.BinaryNode binaryNodeRoot = new BinarySearchTree.BinaryNode(6,left,right);
        BinarySearchTree binarySearchTree = new BinarySearchTree(binaryNodeRoot);

        Boolean isEmpty = binarySearchTree.isEmpty();
        System.out.println(isEmpty);

        Boolean is =binarySearchTree.contains(3);
        System.out.println(is);

//        try {
//            Comparable<Integer> min = binarySearchTree.findMin();
//            System.out.println(min);
//
//            Comparable<Integer> max = binarySearchTree.findMax();
//            System.out.println(max);
//        }catch (Exception e){
//            e.printStackTrace();
//        }

        binarySearchTree.insert(4);


        binarySearchTree.remove(2);
        binarySearchTree.printTree();



    }
}
