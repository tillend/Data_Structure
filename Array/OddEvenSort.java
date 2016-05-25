package Array;
/**
 * 
 * @author LIn
 * 问题描述：给定一个整数数组，请调整数组中数的顺序，使得所有奇数
 *        位于数组的前半部分，所有偶数位于数组的后半部分。
 *        要求时间复杂度为O(n)
 */
public class OddEvenSort {
	/**
	 * 描述：一头一尾两个指针同时往中间扫描，
	 *     若头指针所指为偶，尾指针所指为奇，则交换
	 * @param a
	 */
	public static void OddEvenSort(int[] a){
		if(a.length == 0){
			return;
		}
		
		int begin = a[0];
		int end = a[a.length - 1];
		
		while(begin < end){
			//如果begin指针指向的是奇数，正常，向右移
			if(IsOddNumber(begin)){
				begin++;
			}
			//如果begin指针指向的是偶数，正常，向左移
			else if(IsOddNumber(end)){
				end--;
			}
			else{
			//否则不正常(即奇偶相反)，交换
				swap(a, begin, end);
			}
			
		}
	}
	/**
	 * 描述：一前一后两个指针从左往右扫描，仅当j指向奇数时交换，
	 *     前指针i会使所有奇数填充到前半部分
	 * @param a
	 */
	public static void OddEvenSort2(int[] a, int low, int high){
		int i = low - 1;
		for(int j = low; j < high; j++){
			//a[j]指向奇数，交换
			if(IsOddNumber(a[j])){
				i++;
				swap(a, i, j);
			}
		}
		swap(a, i+1, high);
		
	}
	
	private static void swap(int[] a, int x, int y) {
		int temp = a[x];
		a[x] = a[y];
		a[y] = temp;
	}

	private static boolean IsOddNumber(int data){
		return (data & 1) == 1;
	}

}
