package Tree;

public class Test {

	public static void main(String[] args){
    	BinarySearchTree<Integer> t = new BinarySearchTree<Integer>();
    	int[] data = {2,8,7,4,9,3,1,6,7,5};
    	for(int i = 0; i < data.length; i++){
    		t.insert(data[i]);
    	}
    	
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
    }

}
