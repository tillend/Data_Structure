package LinkedList;

public class Test {

	//≤‚ ‘
	public static void main(String[] args) {
		MyLinkedList list = new MyLinkedList();
		list.addNode(5);
		list.addNode(3);
		list.addNode(1);
		list.addNode(3);
		OperateList.deletDuplecate1(list.head);
		System.out.println("listLen= " + list.length());
		System.out.println("before sort:");
		list.printList();
		list.orderList();
		System.out.println("after sort:");
		list.printList();



	}

}
