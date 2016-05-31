package Tree;
/**
 * 
 * @author LIn
 * 问题描述：已知先序遍历和中序遍历，求后序遍历
 * 解题思路：1.确定树的根节点
 *        2.求解树的子树
 *        3.对二叉树的左、右孩子分别进行步骤1、2
 * (中序遍历能直接求解出根，依次划分为左右子树)
 * @param <AnyType>
 */
public class PostOrder<AnyType extends Comparable<? super AnyType>> {
	private Node<AnyType> root;
	
	public PostOrder(){}
	
	public void initTree(int[] preOrder, int[] inOrder){
		this.root = this.initTree(preOrder, 0, preOrder.length - 1, inOrder, 0, inOrder.length - 1);
	}
	
	private Node<AnyType> initTree(int[] preOrder, int start1, int end1, 
			int[] inOrder, int start2, int end2){
		if(start1 > end1 || start2 > end2){
			return null;
		}
		
		int rootData = preOrder[start1];
		Node head = new Node<>(rootData);
		//找到根节点所在的位置
		int rootIndex = findIndexInArray(inOrder, rootData, start2, end2);
		int offSet = rootIndex - start2 - 1;
		//构建左子树
		Node<AnyType> left = initTree(preOrder, start1 + 1, start1 + 1 + offSet, 
				inOrder, start2, start2 + offSet);
		
		//构建左子树
		Node<AnyType> right = initTree(preOrder, start1 + 2 + offSet, end1, 
				inOrder, rootIndex + 1, end2);
		
		head.left = left;
		head.right = right;
		return head;
		
	}

	private int findIndexInArray(int[] a, int x, int begin, 
			int end) {
		for(int i = begin; i <= end; i++){
			if(a[i] == x)
				return i;
		}
		return -1;
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

}
