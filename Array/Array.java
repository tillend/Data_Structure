package Array;

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