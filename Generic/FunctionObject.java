package Generic;

import java.util.Comparator;

public class FunctionObject {

    public static <AnyType> AnyType findMax(AnyType[] arr,
    		Comparator<? super AnyType> cmp){
    	 int maxIndex = 0;
    
    	 for(int i = 1; i < arr.length; i++){
    		 if(cmp.compare(arr[i], arr[maxIndex]) > 0){
    			 maxIndex = i;
    		 }
    	 }
         return arr[maxIndex];
    }
    
    public static void main(String[] args) {
		String[] arr = {"ZEBRA","alligator","crocodile"};
		System.out.print(FunctionObject.findMax(arr, new CaseInsensitiveCompare()));

	}


}

class CaseInsensitiveCompare implements Comparator<String>{

	@Override
	public int compare(String arg0, String arg1) {
		return arg0.compareToIgnoreCase(arg1);
	}
	
}
