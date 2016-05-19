package Stack;
import java.util.Arrays;
/**
 * 用数组构造栈
 * @author LIn
 *
 * @param <E>
 */
public class MyStack<E> {

	private Object[] stack;
	private int size;  //数组中的元素
	public MyStack(){
		stack = new Object[10];  //初始长度
	}
	
	//判断栈是否为空
	public boolean isEmpty(){
		return size == 0;
	}
	
	//取栈顶元素的值
	public E peek(){
		if(isEmpty()){
			return null;
		}else{
			return (E)stack[size-1];
		}
	}
	
	//将栈顶元素出栈
	public E pop(){
		E e = peek();
		stack[size-1] = null;
		size--;
		return e;
	}
	
	//入栈
	public E push(E e){
		ensureCapacity(size + 1); //检查容量
		stack[size++] = e;
		return e;
	}
	
	//判断数组是否已满，若已满，则扩充数组空间
	private void ensureCapacity(int size){
		int len = stack.length;
		if(size > len){  //数组已满
			int newLen = 10;
			stack = Arrays.copyOf(stack, newLen);
		}
	}

}
