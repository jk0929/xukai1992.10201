package suanFaDemo;

/**
 * Created by Admin on 2018/4/4.
 * 二叉查找树类
 * 子树根据左子树根节点值小于root值，右子树的根节点的值大于root值；
 */
public class BinarySearchTree <T extends Comparable<? super T>>{

    public static class BinaryNode<T> {//嵌套类，用于定义二叉树的子树；
        T element;
        BinaryNode<T> left;
        BinaryNode<T> right;
        public BinaryNode(T data){
            this(data,null,null);
        }
        public BinaryNode(T data,BinaryNode left,BinaryNode right){
            this.element = data;
            this.left = left;
            this.right = right;
        }
    }
    private BinaryNode<T> root;//根节点

    public BinarySearchTree(){
        root = null;
    }
    public BinarySearchTree(BinaryNode<T> root){
        this.root = root;
    }

    public void makeEmpty(){
        root = null;
    }

    public boolean isEmpty(){
        return root == null;
    }
    private boolean contains(T x,BinaryNode<T> binaryNode){
        if(binaryNode == null){
            return false;
        }
        int compareResult = x.compareTo(binaryNode.element);
        if(compareResult < 0){//如果x小于子树的根节点的element，则递归调用查找下一个左子树；
            return contains(x,binaryNode.left);
        }
        if(compareResult > 0){//如果x大于子树的根节点的element，则递归调用查找下一个右子树；
            return contains(x,binaryNode.right);
        }
        return true;//如果x等于子树的根节点的element，则找到了x；
    }

    public boolean contains(T x){//查找x是否存在整个二叉树中；
      return contains(x,root);
    }

    private BinaryNode<T> findMin(BinaryNode<T> binaryNode){//找整个树中最小值；
        if(binaryNode == null){
            return null;
        }
        if(binaryNode.left == null){
            return binaryNode;
        }
        return findMin(binaryNode.left);
    }
    public T findMin()throws Exception{
        if(isEmpty()){
            throw new Exception();
        }
        return findMin(root).element;
    }

    private BinaryNode<T> findMax(BinaryNode<T> binaryNode){//找整个树中最大值；
        if(binaryNode != null){
            while (binaryNode.right != null){
                binaryNode =  binaryNode.right;
            }
        }
        return binaryNode;
    }

    public T findMax()throws Exception{
        if (isEmpty()){
            throw new Exception();
        }
        return findMax(root).element;
    }

    private BinaryNode<T> insert(BinaryNode<T> binaryNode,T x){
        if(binaryNode == null){
            return new BinaryNode<>(x);
        }
        int compareResult = x.compareTo(binaryNode.element);
        if(compareResult < 0){
           binaryNode.left = insert(binaryNode.left,x);
        }else if(compareResult > 0){
           binaryNode.right = insert(binaryNode.right,x);
        }else {//如果相等的话，没有任何步骤；

        }
        return binaryNode;
    }
    public void insert(T x){
        root = insert(root,x);
    }

    private void printTree(BinaryNode<T> binaryNode){
        if(binaryNode != null){
            printTree(binaryNode.left);
            System.out.println(binaryNode.element);
            printTree(binaryNode.right);
        }
    }

    public void printTree(){
        if(isEmpty()){
            System.out.println("Empty Tree!");
        }
        else printTree(root);
    }

    private BinaryNode<T> remove(T x,BinaryNode<T> binaryNode){
        if(binaryNode == null){//1
            return null;
        }
        int compareResult = x.compareTo(binaryNode.element);
        if(compareResult < 0){//左子树
            binaryNode.left = remove(x,binaryNode.left);//2
        }else if(compareResult > 0){//右子树
           binaryNode.right = remove(x,binaryNode.right);//3
        }else //相等的时候；
            if(binaryNode.left!=null && binaryNode.right!=null){//要删除的节点有两个子树；4
                binaryNode.element = findMin(binaryNode.right).element;
                binaryNode.right = remove(binaryNode.element,binaryNode.right);
            }
        else
            if(binaryNode.left != null){//5
                binaryNode = binaryNode.left;
            }else if(binaryNode.right!=null){//6
                binaryNode = binaryNode.right;
            }else {//7
                binaryNode = null;
            }

        return binaryNode;//8
    }

    public void remove(T x){
        root = remove(x,root);
    }
}
