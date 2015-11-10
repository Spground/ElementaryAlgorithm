package cn.edu.dlut.wujie;

public class LinkReverse {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = null;
		for(int i = 0; i < 10; i++){
			head = new Node(head, 10 - i);
		}
	
		printLink(head);
		System.out.println();
		
		Node newHead = reverseLink(head);
		printLink(newHead);
	}
	
	public static Node reverseLink(Node head){
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