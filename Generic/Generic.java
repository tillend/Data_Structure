package Generic;

import java.util.Collection;

public class Generic<AnyType> {  //指出Generic有一个类型参数
	private AnyType storedValue; 
	
	public AnyType read(){
		return storedValue;
	}
	
	public void write(AnyType x){
		storedValue = x;
	}
	//通配符修正后的方法
	public static double totalArea(Collection<? extends Shape> arr){
		double total = 0;
		
		for(Shape s:arr){
			if(s != null){
				total += s.area();
			}
		}
		return total;
	}
	
	//显式泛型方法
	public static <AnyType> boolean contains(AnyType[] arr, AnyType x){
		for(AnyType val:arr){
			if(x.equals(val)){
				return true;
			}
		}
		return false;
	}
	
	//类型限界
    public static <AnyType extends Comparable<? super AnyType>> 
           AnyType findMax(AnyType[] arr){
        int maxIndex = 0;
        
        for(int i = 1; i < arr.length; i++){
        	if(arr[i].compareTo(arr[maxIndex]) > 0){
        		maxIndex = i;
        	}
        }
        
        return arr[maxIndex];
    }

}

class Shape{
	public double area(){
		return 1;
	}
}

class Square extends Shape{
	public double area(){
		return 1;
	}
}