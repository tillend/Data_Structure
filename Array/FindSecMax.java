package Array;
/**
 * 
 * @author LIn
 *
 */
public class FindSecMax {
	
	/**
	 * 找出数组中第二大的数
	 * @param a
	 * @return
	 */
	public static int FindSecMax(int[] a){
		int len = a.length;
		int max = a[0];
		int sec_max = Integer.MIN_VALUE;
		for(int i = 0; i < len; i++){
			if(a[i] > max){
				sec_max = max;
				max = a[i];
			}else{
				if(a[i] > sec_max){
					sec_max = a[i];
				}
			}
		}
		return sec_max;
	}
	

}
