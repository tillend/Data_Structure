package Array;
/**
 * 
 * @author LIn
 * 问题描述：有n个整数，找出其中最小的k个数
 * 解决方案：                                                     时间复杂度
 * 1.全部排序(快排)             O(nlogn)
 * 2.部分排序(维持大小为k的数组)    O(nk)
 * 3.维持最大堆(每次去除最大元素)    O(nk)
 * 4.快速选择算法                                             O(n)
 */
public class FindMin_K {
	//快速选择算法的实现
	private final static int CUTOFF = 10;  //截断范围
	//选择算法结束后，第k个最小元就在位置k-1上
	public static void QuickSelect(int[] a, int left, int right, int k){
		if(left + CUTOFF <= right){
			int pivot = median3(a, left, right);
			
			//开始划分
			int i = left, j = right - 1;
			for( ; ; ){
				while(a[++i] < pivot){}
				while(a[--j] > pivot){}
				if(i < j){
					swap(a, i, j);
				}
				else{
					break;
				}
			}
			
			swap(a, i, right-1);    //储存基准点
			
			if(k <= i){
				QuickSelect(a, left, i - 1, k);
			}else{
				QuickSelect(a, i + 1, right, k);   
			}
			    
			
		}
		else{   //在子数组里调用插入排序
			//InsertSort(a, left, right);
		}
	}
	
	/**
	 * 将三个数排序且隐藏基准点
	 * 返回三个数的中值
	 */
	private static int median3(int[] a, int left, int right) {
		int center = (left + right) / 2;
		if(a[center] < a[left]){
			swap(a, left, center);
		}
		if(a[right] < a[left]){
			swap(a, left, right);
		}
		if(a[right] < a[center]){
			swap(a, center, right);
		}
		
		//将基准点放置在right-1位置上
		swap(a, center, right - 1);
		return a[right-1];
	}

	private static void swap(int[] a, int x, int y){
		int temp = a[x];
		a[x] = a[y];
		a[y] = temp;
	}

}
