package Tree;

public class Test {

	public static void main(String[] args){
    	BinarySearchTree<Integer> t = new BinarySearchTree<Integer>();
    	int[] data = {2,8,7,4,9,3,1,6,7,5};
    	
    	System.out.print("二叉树构造前：");
    	for(int i = 0; i < data.length; i++){
    		t.insert(data[i]);
    		System.out.print(data[i] + " ");
    	}
    	System.out.println();
    	
    	System.out.print("二叉树的中序遍历：");
    	t.inOrder();
    	System.out.println();
    	System.out.print("二叉树的先序遍历：");
    	t.preOrder();
    	System.out.println();
    	System.out.print("二叉树的后序遍历：");
    	t.postOrder();
    	System.out.println();
    	System.out.print("二叉树的层次遍历：");
    	t.layerTranverse();
    	System.out.println();
    	
    	System.out.print("二叉树的删除：");
    	t.remove(8);
    	t.inOrder();
    	System.out.println();
    	
    	System.out.print("二叉树的插入：");
    	t.insert(0);
    	t.inOrder();
    	System.out.println();
    	
    	//后序遍历测试
//    	PostOrder<Integer> t = new PostOrder<Integer>();
//    	int[] preOrder = {2,1,8,7,4,3,6,5,9};
//    	int[] inOrder = {1,2,3,4,5,6,7,8,9};
//    	t.initTree(preOrder, inOrder);
//    	t.postOrder();
    }

}
