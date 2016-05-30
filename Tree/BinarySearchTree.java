package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree<AnyType extends Comparable<? super AnyType>> {
	//树的节点
	private static class Node<AnyType>{
		AnyType element;     //节点数据
		Node<AnyType> left;  //左孩子
		Node<AnyType> right; //左孩子
		
		Node(AnyType element){
			this(element, null, null);
		}
		
		Node(AnyType element, Node<AnyType> lt, Node<AnyType> rt){
			this.element = element;
			left = lt;
			right = rt;
		}
	}
	
	private Node<AnyType> root;  //根节点
	
	public BinarySearchTree(){
		root = null;
	}
	
	public void makeEmpty(){
		root = null;
	}
	public boolean isEmpty(){
		return root == null;
	}
	/**
	 * 查找元素x是否在该树中
	 * @param x
	 * @return
	 */
	public boolean contains(AnyType x){
		return contains(x, root);
	}
	/**
	 * 查找最小元素
	 * @throws Exception 
	 */
    public AnyType findMin() throws Exception{
        if( isEmpty() )
            throw new Exception();
        return findMin(root).element;
    }

    /**
     * 查找最大元素
     * @throws Exception 
     */
    public AnyType findMax() throws Exception{
        if(isEmpty())
            throw new Exception();
        return findMax(root).element;
    }
    
    public void insert(AnyType x){
        root = insert(x, root);
    }

	public void remove(AnyType x){
        root = remove(x, root);
    }

	/**
     * 查找元素的内部方法，递归
     * @param x  要查找的元素
     * @param t  子树的根节点
     * @return   是否查找成功
     */
    private boolean contains(AnyType x, Node<AnyType> t){
        if(t == null)
            return false;
            
        int compareResult = x.compareTo(t.element);
            
        if(compareResult < 0)
            return contains(x, t.left);
        else if(compareResult > 0)
            return contains(x, t.right);
        else
            return true;    //匹配
    }
    /**
     * 查找树中最小元素，递归
     * @param t
     * @return
     */
    private Node<AnyType> findMin(Node<AnyType> t){
    	if(t == null)
    		return null;
    	else if(t.left == null){
    		return t;
    	}
    	return findMin(t.left);
    }
    /**
     * 查找树中最大元素，非递归实现
     * @param t
     * @return
     */
    private Node<AnyType> findMax(Node<AnyType> t){
    	if(t != null){
    		while(t.right != null){
    			t = t.right;
    		}
    	}
    	return t;
    }
    /**
     * 将元素插入到二叉查找树
     * @param x  要查找的元素
     * @param t  子树的根节点
     * @return   插入后的树的根节点
     */
    private Node<AnyType> insert(AnyType x, Node<AnyType> t) {
    	if(t == null)
    		return new Node<>(x, null, null);
    	
    	int compareResult = x.compareTo(t.element);
    	if(compareResult < 0)
    		t.left = insert(x, t.left);
    	else if(compareResult > 0)
    		t.right = insert(x, t.right);
    	else
    		;
    	
		return t;
	}
    /**
     * 删除指定元素的节点
     * 1.被删除的节点只有一个儿子，则该结点可以在其父节点调整自己的链后删除
     * (若该节点是树叶的情况等同，此时赋值的值为null)
     * 2.被删除的节点只有两个儿子，用其右子树的最小的数据代替该节点的数据，
     * 并递归第删除那个节点
     * @param x
     * @param t
     * @return
     */
    private Node<AnyType> remove(AnyType x, Node<AnyType> t) {
    	if(t == null)
    		return t;     //未找到该元素
    	
    	int compareResult = x.compareTo(t.element);
    	
    	if(compareResult < 0)
    		t.left = remove(x, t.left);
    	else if(compareResult > 0)
    		t.right = remove(x, t.right);
    	else if(t.left != null && t.right != null){   //要删除的节点有两个孩子
    		t.element = findMin(t.right).element;
    		t.right = remove(t.element, t.right);
    	}
    	else
    		t = (t.left != null)?t.left:t.right;
    	
    	return t;
	}
    
    
    
    /*二叉树的遍历*/
    //中序遍历
    public void inOrder(){
    	this.inOrder(this.root);
    }
    private void inOrder(Node<AnyType> root){
    	if(root != null){
    		inOrder(root.left);
    		System.out.print(root.element + " ");
    		inOrder(root.right);
    	}
    }
  
    //先序遍历
    public void preOrder(){
    	this.preOrder(this.root);
    }
    private void preOrder(Node<AnyType> root){
    	if(root != null){
    		System.out.print(root.element + " ");
    		preOrder(root.left);
    		preOrder(root.right);
    	}
    }

    //后序遍历
    public void postOrder(){
    	this.postOrder(this.root);
    }
    private void postOrder(Node<AnyType> root){
    	if(root != null){
    		postOrder(root.left);
    		postOrder(root.right);
    		System.out.print(root.element + " ");
    	}
    }
    
    /**
     * 层次遍历二叉树(使用队列)
     * 描述：先将根节点放入队列中，然后每次都从队列中取出一个节点打印，
     *     若这个节点有子节点，则将它的子节点放入队列尾，直到队列为空
     */
    public void layerTranverse(){
    	if(this.root == null){
    		return;
    	}
    	
    	Queue<Node<AnyType>> q = new LinkedList<Node<AnyType>>();
    	q.add(this.root);
    	while(!q.isEmpty()){
    		Node<AnyType> n = q.poll();
    		System.out.print(n.element + " ");
    		if(n.left != null){
    			q.add(n.left);
    		}
    		if(n.right != null){
    			q.add(n.right);
    		}
    		
    	}
    }

}
