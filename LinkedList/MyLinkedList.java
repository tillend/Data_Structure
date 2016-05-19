package LinkedList;
//链表结点
class Node{
	Node next = null;
	int data;
	public Node(int data){
		this.data = data;
	}
}

public class MyLinkedList {
	
	Node head = null;    //链表的头指针
	
	/**向链表中插入数据
	 * @param d:插入数据的内容
	 * */
	public void addNode(int d){
		Node newNode = new Node(d);
		
		if(head == null){  //空链表，插入为头指针
			head = newNode;
		}else{
			Node p = head;
			while(p.next != null){
				p = p.next;
			}
			p.next = newNode;	
		}
	}
	
	/**
	 * @param index:删除第index个节点
	 * @return 成功返回true，失败返回false
	 * */
	public boolean delNode(int index){
		if(index < 1 || index > length()){
			return false;
		}
		//删除链表第一个节点
		if(index == 1){
			head = head.next;
			return true;
		}else{
			//不是第一个节点
			int i = 1;
			Node preNode = head;
			Node curNode = preNode.next;
			while(curNode != null){
				if(i == index){
					preNode.next = curNode.next;
					return true;
				}
				preNode = curNode;
				curNode = curNode.next;
				i++;
			}
		}
		return true;
	}
	
	/**
	 * @return 返回节点的长度
	 */
	public int length(){
		int length = 0;
		Node p = head;
		while(p != null){
			length++;
			p = p.next;
		}
		return length;
	}
	
	public int length(Node head){
		int length = 0;
		Node p = head;
		while(p != null){
			length++;
			p = p.next;
		}
		return length;
	}
	
	/**
	 * 对链表进行排序
	 * 方法为选择排序
	 * @return 返回排序后的头节点
	 */
	public Node orderList(){
		Node nextNode = null;
		int temp = 0;
		Node curNode = head;
		while(curNode.next != null){
			nextNode = curNode.next;
			while(nextNode != null){
				if(nextNode.data < curNode.data){
					swap(curNode,nextNode);
				}
				nextNode = nextNode.next;
			}
			curNode = curNode.next;
		}
		return head;
	}
	
	/**
	 * 交换两个节点的值
	 */
	private static void swap(Node i,Node j){
		int temp = i.data;
		i.data = j.data;
		j.data = temp;
	}
	
	/**
	 * 输出链表
	 */
	public void printList(){
		Node p = head;
		while(p != null){
			System.out.println(p.data);
			p = p.next;
		}
	}

}
