package Union;

/**
 * 
 * @author LIn
 * 并查集的实现
 * union时间复杂度：O(1)
 * 最坏情况下find耗时为O(n^2),因为合并可能使n个结点的树退化成一条链
 */
public class UnionFind {
	Node[] node;   //父亲数组
	//并查集中的结点
	private static class Node{
		int parent;
		boolean root;
		
		private Node(){
			parent = 1;
			root = true;
		}
	}
	//将每个元素初始化为一颗单结点树
	public UnionFind(int n){
		node = new Node[n + 1];
		for(int e= 0; e <= n; e++){
			node[e] = new Node();
		}
	}
	/*
	 * find运算就是从元素e相应的结点走到树根处，找出所在集合的名字
	 */
	public int find(int e){
		while(!node[e].root){
			e = node[e].parent;
		}
		return e;
	}
	/*
	 * union运算，合并两个集合
	 * 只要将表示其中一个集合的树的数根改为表示另一个集合的树的数根的儿子结点
	 */
	public void union(int a, int b){
		node[a].parent += node[b].parent;
		node[b].root = false;
		node[b].parent = a;
	}

}
