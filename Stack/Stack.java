package Stack;
/**
 * ¡¥±Ì µœ÷’ª
 * @author LIn
 *
 * @param <E>
 */
class Node<E>{
	Node<E> next = null;
	E data;
	public Node(E data){
		this.data = data;
	}
}

public class Stack<E> {
	Node<E> top = null;
	
	public boolean isEmpty(){
		return top == null;
	}
	
	public void push(E e){
		Node<E> newNode = new Node<E>(e);
		newNode.next = top;
		top = newNode;

	}
	
	public E peek(){
		if(isEmpty()){
			return null;
		}else{
			return top.data;
		}
	}
	
	public E pop(){
		if(isEmpty()){
			return null;
		}else{
			E data = peek();
			top = top.next;
			return data;
		}
		
	}

	
}
