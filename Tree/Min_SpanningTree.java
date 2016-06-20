package Tree;

import Heap.MinHeap;
import Union.FastUnionFind;

public class Min_SpanningTree {
	/**
	 * prim算法
	 * 描述：在未连通的集合中，从当前顶点的邻接顶点中找出的一个使权最小的顶点
	 * @param n
	 * @param c
	 * c[x][y]表示顶点x到顶点y的距离，即边(i,j)的权
	 */
	public static void prim(int n,float[][] c){
		float[] lowcost = new float[n+1]; //顶点到各邻接顶点的距离
		int[] closest = new int[n+1];     //邻接顶点
		boolean[] s = new boolean[n+1];   //判断顶点是否已连通，即为已连通的顶点集合
		
		s[1] = true;                   //选中第一个顶点
		for(int i = 2; i <= n; i++){   //初始化顶点集合
			lowcost[i] = c[1][i];
			closest[i] = 1;
			s[i] = false;
		}
		
		for(int i = 1; i <= n; i++){
			float min = Integer.MAX_VALUE;
			int j = 1;
			for(int k = 2; k <= n; k++){        //选取权最小的邻接顶点
				if(lowcost[k] < min && (!s[k])){
			        min = lowcost[k];
			        j = k;
			    }
			}
			System.out.println(j + ", " + closest[j]);
			s[j] = true;                     //将顶点加入到已连通的集合中
			for(int k = 2; k <= n; k++){     //根据新加入的顶点，更新各顶点的权最小邻接顶点
			    if((c[j][k] < lowcost[k]) && (!s[k])){
					lowcost[k] = c[j][k];
			        closest[k] = j;         
			    }
			}
		}
	}
	
	
	
	//重写可比较接口的类，表示带顶端结点的边
	static class EdgeNode implements Comparable{
		float weight;
		int u,v;   //u,v为一条边两端的顶点
		
		public EdgeNode(int u,int v,float w){  //边的构造函数
			this.u = u;
			this.v = v;
			this.weight = w;
		}

		@Override
		public int compareTo(Object x) {    //重写比较方法
			double xw = ((EdgeNode)x).weight;
			if(weight < xw){
				return -1;
			}
			if(weight == xw){
				return 0;
			}
			return 1;
		}	
	}
	
	/**
	 * kruskal算法
	 * 描述：从未在连通分支的边中选出权最小的边
	 * @param n  顶点数
	 * @param e  边数
	 * @param E  边的权
	 * @param t  得到的最小生成树
	 * @return
	 */
//	public static boolean kruskal(int n,int e,EdgeNode[] E,EdgeNode[] t){
//		MinHeap H = new MinHeap(1);        //建立最小堆/优先队列
//		H.initialize(E,e);
//		FastUnionFind U = new FastUnionFind(n);   //初始化并查集
//		int k = 0;
//		while(e > 0 && k < n-1){
//			EdgeNode x = (EdgeNode)H.removeMin();   //当前最小边出堆
//			e--;
//			int a = U.find(x.u);
//			int b = U.find(x.v);
//			if(a != b){     //边的两个顶点不属于同一连通分支
//				t[k++] = x;
//				U.union(a,b);   //加入连通分支
//			}
//		}
//		return (k == n-1);
//	}

}
