package cn.edu.dlut.wujie;
/**
 * reverse a linklist
 * @author wujie
 *
 */
public class LinkReverse {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = null;
//		for(int i = 0; i < 10; i++){
//			head = new Node(head, 10 - i);
//		}
//		
//		System.out.println("origin linklist:");
//		printLink(head);
//		System.out.println();
//		
//		//reverse linklist with recurrence method
//		Node headR = head;
//		System.out.println("reversed linklist(with recurrence method):");
//		printLink(reverseLinkList(headR));
//		System.out.println();
		
		//带头结点
		System.out.println("带头结点");
		for(int i = 0; i < 10; i++){
			head = new Node(head, 10 - i);
		}
		Node head0 = new Node(head, -1);
		System.out.println("origin linklist:");
		printLink0(head0);
		System.out.println();
		
		//reverse linklist with recurrence method
		System.out.println("reversed0 linklist(with recurrence method):");
		printLink0(reverseLinkList0(head0));
		//get the tail of linklist
		/*Node tail  = head;
		while(tail.next != null){
			tail = tail.next;
		}
		//reverse linklist with recursion method
		reverseLinkListRecursion(head);
		System.out.println("reversed linklist(with recursion method):");
		printLink(tail);*/
	}
	
	/**
	 * revers linklist with recurrence method
	 * @param head
	 * @return the head of reversed linklist
	 */
	public static Node reverseLinkList(Node head){
		if(head == null)
			return null;
		
		Node p,q = null;
		
		p = head.next;
		head.next = null;
		
		while(p != null){
			q = p.next;
			p.next = head;
			head = p;
			p = q;
		}
		
		return head;
	}
	
	//带头结点的链表 头插法 反转链表
	public static Node reverseLinkList0(Node head){
		if(head == null)
			return null;
		if(head.next == null || head.next.next == null)
			return head;
		
		Node p = null,q = null;
		p = head.next;
		head.next = null;
		
		while((q = p.next) != null){
			p.next = head.next;
			head.next = p;
			p = q;
		}
		return head;
	}
	
	/**
	 * recursion rerverse a linklist
	 * @param head
	 * @return 
	 */
	public static void reverseLinkListRecursion(Node head){
		
		if(head == null || head.next == null)
			return;
		
		Node p = head.next;
		head.next = null;
	    reverseLinkListRecursion(p);
	    p.next = head;
		return;
	}
	/**
	 * print linklist
	 * @param head
	 */
	public static void printLink(Node head){
		if(head == null)
			System.out.println("Link is null");
		else
			while(head != null){
				System.out.print(head.data + "<---");
				head = head.next;
			}
	}
	
	//带头结点的链表
	public static void printLink0(Node head){
			while(head.next != null){
				System.out.print(head.next.data + "<---");
				head = head.next;
			}
	}
}

/**Node Class**/
class Node{
	public Node next;
	public int data;
	public Node(Node next, int data){
		this.data = data;
		this.next = next;
	}
}