package BitOperation;

public class BitOperation {

	/**
	 * 判断一个数是否为2的n次方
	 * @param n
	 * @return
	 */
	public static boolean isPower(int n){
		if(n < 1){
			return false;
		}
		int i = 1;
		while(i <= n){
			if(i == n){
				return true;
			}
			i <<= 1;     //每次左移一位，相当于i *= 2
		}
		return false;
	}

	
}
