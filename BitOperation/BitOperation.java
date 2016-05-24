package BitOperation;

public class BitOperation {

	/**
	 * 判断一个数是否为2的n次方
	 * 时间复杂度为O(logn)
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
	
	/**
	 * 判断一个数是否2的n次方
	 * 若一个数是2的n次方，那么这个数的二进制表示中只有一位为1，其余位均为0
	 * @param n
	 * @return
	 */
	public static boolean isPowerX(int n){
		if(n < 1){
			return false;
		}
		int m = n & (n-1);
		return m == 0;

	}
	
	/**
	 * 求二进制中1的个数,每位判断，时间复杂度为O(n)
	 * @param n
	 * @return
	 */
	public static int countOne(int n){
		int count = 0;
		while(n > 0){
			if((n & 1) == 1){  //判断最后一位是否为1
				count++;
			}
			n >>= 1;  //移位
		}
		return count;
	}
	/**
	 * 求二进制中1的个数,每次计算n&(n-1)，每次均为最后一位少1，时间复杂度为O(m)
	 * @param n
	 * @return
	 */
	public static int countOneX(int n){
		int count = 0;
		while(n > 0){
			if(n != 0){  //判断最后一位是否为1
				n = n & (n-1);
				count++;
			}
			n >>= 1;  //移位
		}
		return count;
	}

	
}
