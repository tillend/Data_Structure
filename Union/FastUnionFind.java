package Union;

public class FastUnionFind {
	Node[] node;
	//并查集中的结点
	private static class Node{
		int parent;
		boolean root;
		
		private Node(){
			parent = 1;
			root = true;
		}
	}
	//初始化集合
	public FastUnionFind(int n){
		node = new Node[n + 1];
		for(int e= 0; e <= n; e++){
			node[e] = new Node();
		}
	}
	/*
	 * find运算(加速)
	 * 从元素e相应的结点走到数根出，找出所在集合的名字
	 */
	public int find(int e){
		int current = e, p ,gp;
		/*排除当前结点或其父结点为根的情况后，加速find*/
		if(node[current].root){
			return current;
		}
		p = node[current].parent;
		if(node[current].root){
			return p;
		}
		gp = node[current].parent;
		
		while(true){
			node[current].parent = gp;
			if(node[gp].root){
				return gp;
			}
			current = p;
			p = gp;
			gp = node[p].parent;
		}
	}
	/*
	 * 合并两个集合(加速)
	 * 将表示小树的数根改为表示大树的数根的儿子结点
	 */
	public void union(int a, int b){
		if(node[a].parent < node[b].parent){
			node[b].parent += node[a].parent;
			node[a].root = false;
			node[a].parent = a;
		}else{
			node[a].parent += node[b].parent;
			node[b].root = false;
			node[b].parent = a;
		}
	}

}
