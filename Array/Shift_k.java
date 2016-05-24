package Array;
/**
 * 
 * @author LIn
 * 描述：把一个数组循环右移k位，如把数组序列12345678右移2位变为78123456
 * 算法流程：
 * 1.逆序左边子序列，即123456，数组序列形式变为65432178
 * 2.逆序右边子序列，即78，数组序列形式变为65432187
 * 3.全部逆序，数组序列形式变为78123456
 * 
 * 时间复杂度：O(n)
 */
public class Shift_k {
	
	public static void shift_k(int[] a, int k){
		int n = a.length;
		k = k % n;     //避免k比n大
		reverse(a, 0, n - k - 1);
		reverse(a, n - k, n - 1);
		reverse(a, 0, n - 1);
	}
	
	private static void reverse(int[] a, int b, int e){
		for( ; b < e; b++,e--){
			int temp = a[e];
			a[e] = a[b];
			a[b] = temp;
		}
	}
	
	public static void main(String[] args){
		int[] a = {1,2,3,4,5,6,7,8};
		shift_k(a, 2);
		for(int i = 0; i < a.length; i++){
			System.out.print(a[i] + " ");
		}
	}

}
