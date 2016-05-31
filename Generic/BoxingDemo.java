package Generic;

import java.util.Collection;
import java.util.LinkedList;

public class BoxingDemo {   //自动装箱和自动拆箱

	public static void main(String[] args) {
		Generic<String> g = new Generic<>();
		
		g.write("aas");
		String val = g.read();
		System.out.println("值为：" + val);
		
		Collection<Square> arr = new LinkedList<Square>();
		arr.add(new Square());
		g.totalArea(arr);

	}

}
