package Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Array {
	/**
	 * 寻找数组中的最小值和最大值
	 * 每次比较相邻两个数，较大者与Max比较，较小者与Min比较,比较次数为1.5N
	 * @param a
	 */
	public static MaxMin FindMaxAndMin(int[] a){
		int Max = a[0];
		int Min = a[0];
		int len = a.length;
		for(int i = 0; i < len-1; i += 2){
			if(i+1 > len){   //数组长度为偶数时的最后一位
				if(a[i] > Max){
					Max = a[i];
				}
				if(a[i] < Min){
					Min = a[i];
				}
			}
			//比较相邻的两数，较大者与Max比较，较小者与Min比较
			if(a[i] > a[i+1]){
				if(a[i] > Max){
					Max = a[i];
				}
				if(a[i+1] < Min){
					Min = a[i+1];
				}
			}else{
				if(a[i+1] > Max){
					Max = a[i+1];
				}
				if(a[i] < Min){
					Min = a[i];
				}
			}
		}
		return new MaxMin(Max,Min);
	}
	
	/**
	 * 找出数组中第二大的数
	 * @param a
	 * @return
	 */
	public static int findSecMax(int[] a){
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
	
	/**
	 * 问题描述：找出数组中重复元素最多的数
	 * @param a
	 * @return
	 */
	public static int findMostFrequnentInArray(int[] a){
		int result = 0;
		int size = a.length;
		if(size == 0){
			return Integer.MAX_VALUE;
		}
		
		//记录每个元素出现的次数
		Map<Integer,Integer> m = new HashMap<Integer,Integer>();
		for(int i = 0; i < size; i++){
			if(m.containsKey(a[i])){
				m.put(a[i], m.get(a[i]) + 1);
			}else{
				m.put(a[i], 1);
			}
		}
		
		//用迭代器找出出现次数最多的元素
		int most = 0;
		Iterator it = m.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry entry = (Map.Entry) it.next();
			int key = (int) entry.getKey();
			int value = (int) entry.getValue();
			if(value > most){
				result = key;
				most = value;
			}
		}
		return result;
	}
	
	/**
	 * 问题描述：给定数组a={3,4,5,6,5,6,7,8}，这个数组中相邻元素之差为1，
	 *        给定数字9，找出它在数组中第一次出现的下标
	 * 解决方案：跳跃搜索法(加速遍历)
	 * @param a  给定数组
	 * @param t  给定数字
	 * @return
	 */
	public static int findIndex(int[] a, int t){
		int len = a.length;
		int i = 0;
		while(i < len){
			if(a[i] == t){
				return i;
			}else{
				i += Math.abs(t - a[i]);
			}
		}
		return -1;
	}
	/**
	 * 求数组中两两相加等于定值的组合种数(能使用散列函数以空间换时间)
	 * 时间复杂度取决于排序算法
	 * @param a  
	 * @param sum
	 */
	public static void findSum(int[] a, int sum){
		Arrays.sort(a);
		int begin = 0;
		int end = a.length - 1;
		while(begin < end){
			if(a[begin] + a[end] < sum){
				begin++;
			}else if(a[begin] + a[end] > sum){
				end--;
			}else{
				System.out.print(a[begin] + "," + a[end]);
				begin++;
				end--;
			}
		}
	}

}

//找最大值和最小值时的类
class MaxMin{
	int Max;
	int Min;
	public MaxMin(int Max,int Min){
		this.Max = Max;
		this.Min = Min;
	}
}